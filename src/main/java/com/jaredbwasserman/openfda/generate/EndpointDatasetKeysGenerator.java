package com.jaredbwasserman.openfda.generate;

import com.jaredbwasserman.openfda.api.Endpoint;
import com.jaredbwasserman.openfda.api.EndpointCategory;
import com.jaredbwasserman.openfda.api.OpenFDAAPI;
import com.jaredbwasserman.openfda.download.EndpointDownloadClient;
import com.jaredbwasserman.openfda.download.EndpointDownloadClientFactory;
import com.jaredbwasserman.openfda.model.EndpointDataset;
import com.jaredbwasserman.openfda.util.FileUtil;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class EndpointDatasetKeysGenerator {
    private static final Logger logger = LoggerFactory.getLogger(EndpointDatasetKeysGenerator.class);

    public static void generateKeysForAllEndpoints(@NonNull String destinationDirectoryPathString) {
        logger.info("Keys generation starting");

        final EndpointDownloadClient endpointDownloadClient = EndpointDownloadClientFactory.getEndpointDownloadClient();
        for (final EndpointCategory endpointCategory : OpenFDAAPI.getEndpointCategories()) {
            for (final Endpoint endpoint : endpointCategory.endpoints()) {

                // TODO: Remove skipping
//                if (!endpoint.endpointCategoryFriendlyName().internalName().equals("drug") ||
//                        !endpoint.friendlyName().internalName().equals("label")) {
//                    logger.info(
//                            "Skip {}-{}",
//                            endpoint.endpointCategoryFriendlyName().displayName(),
//                            endpoint.friendlyName().displayName()
//                    );
//                    continue;
//                }

                final String endpointDatasetKeysName = endpoint.getConcatenatedName() + "Keys";
                logger.info(
                        "Keys generation starting: {}",
                        endpointDatasetKeysName
                );

                // Download
                final List<String> endpointDatasetFilePathStrings = endpointDownloadClient
                        .downloadAndUnzipEndpointFiles(
                                endpoint,
                                destinationDirectoryPathString
                        );
                if (endpointDatasetFilePathStrings.isEmpty()) {
                    logger.warn(
                            "Could not download files for endpoint dataset {}",
                            endpointDatasetKeysName
                    );
                    continue;
                }

                // Get keys
                final Set<String> endpointDatasetKeys = new HashSet<>();
                for (final String endpointDatasetFilePathString : endpointDatasetFilePathStrings) {
                    final Set<String> endpointDatasetFileKeys = getKeys(endpointDatasetFilePathString);
                    if (endpointDatasetFileKeys.isEmpty()) {
                        logger.warn(
                                "Could not get keys for endpoint dataset file {}",
                                endpointDatasetFilePathString
                        );
                        continue;
                    }
                    endpointDatasetKeys.addAll(endpointDatasetFileKeys);
                }
                final List<String> endpointDatasetKeysUnsorted = new ArrayList<>(endpointDatasetKeys);
                Collections.sort(endpointDatasetKeysUnsorted);

                // Write
                writeKeys(
                        destinationDirectoryPathString,
                        endpointDatasetKeysName,
                        endpointDatasetKeysUnsorted.stream().toList()
                );

                // Clean up
                endpointDatasetFilePathStrings.forEach(FileUtil::deleteFile);

                logger.info(
                        "Keys generation finished: {}",
                        endpointDatasetKeysName
                );
            }
        }

        logger.info("Keys generation finished");
    }

    @NonNull
    private static Set<String> getKeys(@NonNull String sourceFilePathString) {
        logger.info(
                "Keys extraction starting: {}",
                sourceFilePathString
        );

        Optional<EndpointDataset> endpointDatasetOptional = EndpointDataset.fromFilePathString(sourceFilePathString);
        if (endpointDatasetOptional.isEmpty()) {
            logger.warn(
                    "Could not create EndpointDataset for {}",
                    sourceFilePathString
            );
            return Collections.emptySet();
        }

        final Set<String> uniqueKeys = new HashSet<>();
        for (final Map<String, Object> result : endpointDatasetOptional.get().results()) {
            uniqueKeys.addAll(result.keySet());
        }

        logger.info(
                "Keys extraction finished: {}",
                sourceFilePathString
        );
        return uniqueKeys;
    }

    private static void writeKeys(@NonNull String destinationDirectoryPathString,
                                  @NonNull String endpointDatasetKeysName,
                                  @NonNull List<String> endpointDatasetKeys) {
        final Path destinationPath = Paths.get(String.join(
                "/",
                destinationDirectoryPathString,
                endpointDatasetKeysName + ".java"
        ));
        try {
            Files.writeString(destinationPath, getFileContents(endpointDatasetKeysName, endpointDatasetKeys));
        } catch (Exception exception) {
            logger.error(
                    "Error while writing keys for {} to {}",
                    endpointDatasetKeysName,
                    destinationPath,
                    exception
            );
        }
    }

    private static String getFileContents(@NonNull String endpointDatasetKeysName,
                                          @NonNull List<String> endpointDatasetKeys) {
        return String.format("""
                        package com.jaredbwasserman.openfda.model.generated;
                                        
                        import lombok.NonNull;
                                        
                        import java.util.List;
                                        
                        public class %s {
                            @NonNull
                            public static List<String> getKeys() {
                                return List.of(
                                    %s
                                );
                            }
                        }
                        """,
                endpointDatasetKeysName,
                String.join(
                        ",\n            ",
                        endpointDatasetKeys.stream()
                                .map((endpointDatasetKey) -> "\"" + endpointDatasetKey + "\"")
                                .toList()
                )
        );
    }
}
