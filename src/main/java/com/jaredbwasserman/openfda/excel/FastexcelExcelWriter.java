package com.jaredbwasserman.openfda.excel;

import com.jaredbwasserman.openfda.api.Endpoint;
import com.jaredbwasserman.openfda.model.EndpointDataset;
import lombok.NonNull;
import org.dhatim.fastexcel.Workbook;
import org.dhatim.fastexcel.Worksheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

// TODO: Figure out a better way to deal with certain keys
// TODO: Add support for more than one worksheet
// TODO: Add support for returning more than one workbook
// TODO: Each workbook should have a part
public class FastexcelExcelWriter implements ExcelWriter {
    private static final Logger logger = LoggerFactory.getLogger(FastexcelExcelWriter.class);

    private static final String APPLICATION_NAME = "openfda-converter";
    private static final String APPLICATION_VERSION = "1.0";

    @Override
    @NonNull
    public List<String> writeWorkbooks(@NonNull Endpoint endpoint,
                                       @NonNull List<String> sourceFilePathStrings,
                                       @NonNull String destinationDirectoryPathString) {
        logger.info(
                "Write to Excel starting: {} -> {}",
                endpoint.getHyphenatedName(),
                destinationDirectoryPathString
        );

        final String workbookPath = getWorkbookPath(destinationDirectoryPathString);

        // TODO: Figure out a better way to deal with this
        final List<String> keys = List.of(
                "openfda.application_number",
                "openfda.package_ndc",
                "openfda.brand_name",
                "openfda.generic_name",
                "openfda.is_original_packager",
                "openfda.manufacturer_name",
                "indications_and_usage",
                "openfda.original_packager_product_ndc",
                "openfda.pharm_class_cs",
                "openfda.pharm_class_epc",
                "openfda.pharm_class_moa",
                "openfda.pharm_class_pe",
                "openfda.product_ndc",
                "openfda.product_type",
                "openfda.route",
                "openfda.rxcui",
                "openfda.spl_id",
                "openfda.spl_set_id",
                "openfda.substance_name",
                "openfda.unii",
                "openfda.upc"
        );

        int badCounter = 0;
        try (final OutputStream outputStream = new FileOutputStream(workbookPath);
             final Workbook workbook = new Workbook(outputStream, APPLICATION_NAME, APPLICATION_VERSION)) {
            // TODO: Generalize this
            final Worksheet worksheet = workbook.newWorksheet("Sheet 1");

            // Header
            int headerColCounter = 0;
            for (final String key : keys) {
                worksheet.value(0, headerColCounter, key);
                ++headerColCounter;
            }

            // Rows
            int rowCounter = 1;
            for (final String sourceFilePathString : sourceFilePathStrings) {
                final Optional<EndpointDataset> endpointDatasetOptional = EndpointDataset.fromFilePathString(sourceFilePathString);
                if (endpointDatasetOptional.isEmpty()) {
                    logger.warn(
                            "Could not create EndpointDataset for {}",
                            sourceFilePathString
                    );
                    return Collections.emptyList();
                }
                final EndpointDataset endpointDataset = endpointDatasetOptional.get();

                for (final Map<String, Object> result : endpointDataset.results()) {
                    if (null == result.get("openfda.package_ndc")) {
                        ++badCounter;
                        continue;
                    }
                    for (final String package_ndc : (List<String>) result.getOrDefault("openfda.package_ndc", Collections.emptyList())) {
                        int colCounter = 0;
                        for (final String key : keys) {
                            String val = null;
                            if ("openfda.package_ndc".equals(key)) {
                                val = package_ndc;
                            } else {
                                Object valIntermediate = result.getOrDefault(key, null);
                                if (null != valIntermediate) {
                                    if (valIntermediate instanceof List) {
                                        val = String.join("\n", ((List) valIntermediate).stream().map(a -> String.valueOf(a)).toList());

                                        if ("indications_and_usage".equals(key)) {
                                            val = getIndicationsAndUsageValue(val);
                                        }
                                    }
                                }
                            }
                            if (null != val) {
                                worksheet.value(rowCounter, colCounter, val);
                            }
                            ++colCounter;
                        }
                        ++rowCounter;
                    }
                }
            }
        } catch (Exception exception) {
            logger.error(
                    "Error while writing Excel files for endpoint {}",
                    endpoint,
                    exception
            );
            return Collections.emptyList();
        }

        logger.info(
                "Write to Excel finished: {} -> {}",
                endpoint.getHyphenatedName(),
                destinationDirectoryPathString
        );
        logger.info("Bad row count: {}", badCounter);
        // TODO: Fix this for more than one file
        return List.of(workbookPath);
    }

    @NonNull
    private String getWorkbookPath(@NonNull String destinationDirectoryPathString) {
        return String.join(
                "/",
                destinationDirectoryPathString,
                "drug-label-" +
                        new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(System.currentTimeMillis())
                        + ".xlsx"
        );
    }

    private String getIndicationsAndUsageValue(String input) {
        if (input.contains("•")) {
            return String.join("\n•", input.split("•"));
        } else if (input.contains("■")) {
            return String.join("\n■", input.split("■"));
        } else if (input.contains(". ")) {
            return String.join(".\n", input.split("\\. "));
        } else if (input.contains(", ")) {
            return String.join(",\n", input.split(", "));
        }
        return input;
    }
}
