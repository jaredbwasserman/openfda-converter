package com.jaredbwasserman.openfda.generate;

import com.jaredbwasserman.openfda.api.Endpoint;
import com.jaredbwasserman.openfda.api.EndpointCategory;
import com.jaredbwasserman.openfda.api.OpenFDAAPI;
import com.jaredbwasserman.openfda.download.FileDownloadClient;
import com.jaredbwasserman.openfda.download.FileDownloadClientFactory;
import com.jaredbwasserman.openfda.util.FileUtil;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class EndpointDatasetFieldsGenerator {
    private static final Logger logger = LoggerFactory.getLogger(EndpointDatasetFieldsGenerator.class);

    private static final FileDownloadClient fileDownloadClient = FileDownloadClientFactory.getFileDownloadClient();
    private static final Yaml yaml = new Yaml();

    public static void generateFieldsForAllEndpoints(@NonNull String destinationDirectoryPathString) {
        logger.info("Fields generation starting for all endpoints");

        for (final EndpointCategory endpointCategory : OpenFDAAPI.getEndpointCategories()) {
            for (final Endpoint endpoint : endpointCategory.endpoints()) {
                final String endpointDatasetFieldsName = endpoint.getCamelCaseName();
                logger.info(
                        "Fields generation starting for endpoint dataset: {}",
                        endpointDatasetFieldsName
                );

                // Download
                final Optional<String> fieldsYamlFilePathStringOptional = fileDownloadClient.downloadFile(
                        OpenFDAAPI.getFieldsYamlUrlString(endpoint.fieldsYamlFilename()),
                        destinationDirectoryPathString
                );
                if (fieldsYamlFilePathStringOptional.isEmpty()) {
                    logger.warn(
                            "Could not download fields YAML for endpoint dataset {}",
                            endpointDatasetFieldsName
                    );
                    continue;
                }
                final String fieldsYamlFilePathString = fieldsYamlFilePathStringOptional.get();

                // Get fields
                final List<String> endpointDatasetFields = getEndpointDatasetFields(fieldsYamlFilePathString);

                // Clean up
                FileUtil.deleteFile(fieldsYamlFilePathString);

                // Check if something went wrong
                if (endpointDatasetFields.isEmpty()) {
                    logger.warn(
                            "Could not get fields for {}",
                            fieldsYamlFilePathString
                    );
                    continue;
                }

                // Write file
                writeEndpointDatasetFields(
                        destinationDirectoryPathString,
                        endpointDatasetFieldsName,
                        endpointDatasetFields
                );

                logger.info(
                        "Fields generation finished for endpoint dataset: {}",
                        endpointDatasetFieldsName
                );
            }
        }

        logger.info("Fields generation finished for all endpoints");
    }

    @NonNull
    @SuppressWarnings("unchecked")
    private static List<String> getEndpointDatasetFields(@NonNull String sourceFilePathString) {
        final Set<String> uniqueFields = new HashSet<>();
        try (final FileInputStream fileInputStream = new FileInputStream(sourceFilePathString)) {
            final Map<String, Object> yamlMap = yaml.load(fileInputStream);
            addFields(
                    (Map<String, Object>) yamlMap.get("properties"),
                    "",
                    uniqueFields
            );
        } catch (Exception exception) {
            logger.error(
                    "Error while opening FileInputStream for {}",
                    sourceFilePathString,
                    exception
            );
            return Collections.emptyList();
        }

        final List<String> uniqueFieldsSorted = new ArrayList<>(uniqueFields);
        Collections.sort(uniqueFieldsSorted);
        return uniqueFieldsSorted;
    }

    @SuppressWarnings("unchecked")
    private static void addFields(Map<String, Object> properties, String prefix, Set<String> uniqueFields) {
        for (final Map.Entry<String, Object> propertiesEntry : properties.entrySet()) {
            final String field = propertiesEntry.getKey();
            if ("meta".equals(field) || "type".equals(field)) {
                continue;
            }

            final Map<String, Object> property = (Map<String, Object>) propertiesEntry.getValue();
            if ("object".equals(property.get("type"))) {
                addFields(
                        (Map<String, Object>) property.get("properties"),
                        prefix + field + ".",
                        uniqueFields
                );
            } else {
                uniqueFields.add(prefix + field);
            }
        }
    }

    private static void writeEndpointDatasetFields(@NonNull String destinationDirectoryPathString,
                                                   @NonNull String endpointDatasetFieldsName,
                                                   @NonNull List<String> endpointDatasetFields) {
        final String destinationFilePathString = String.join(
                "/",
                destinationDirectoryPathString,
                endpointDatasetFieldsName + ".java"
        );

        // Delete existing file
        FileUtil.deleteFile(destinationFilePathString);

        try {
            Files.writeString(
                    Paths.get(destinationFilePathString),
                    getFileContents(endpointDatasetFieldsName, endpointDatasetFields)
            );
        } catch (Exception exception) {
            logger.error(
                    "Error while writing fields for {} to {}",
                    endpointDatasetFieldsName,
                    destinationFilePathString,
                    exception
            );
        }
    }

    private static String getFileContents(@NonNull String endpointDatasetFieldsName,
                                          @NonNull List<String> endpointDatasetFields) {
        return String.format("""
                        package com.jaredbwasserman.openfda.model.generated;
                                        
                        import lombok.NonNull;
                                        
                        import java.util.List;
                                        
                        public class %s {
                            @NonNull
                            public static List<String> getFields() {
                                return List.of(
                                        %s
                                );
                            }
                        }
                        """,
                endpointDatasetFieldsName,
                String.join(
                        ",\n                ",
                        endpointDatasetFields.stream()
                                .map((endpointDatasetKey) -> "\"" + endpointDatasetKey + "\"")
                                .toList()
                )
        );
    }
}
