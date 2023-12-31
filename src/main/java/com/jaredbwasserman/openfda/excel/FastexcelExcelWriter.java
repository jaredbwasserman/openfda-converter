package com.jaredbwasserman.openfda.excel;

import com.jaredbwasserman.openfda.model.EndpointDataset;
import com.jaredbwasserman.openfda.model.EndpointDatasetResult;
import com.jaredbwasserman.openfda.util.PermutationUtil;
import lombok.NonNull;
import org.dhatim.fastexcel.Workbook;
import org.dhatim.fastexcel.Worksheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

// TODO: Add validation that split fields are all arrays of strings
// TODO: Add support for more than one worksheet
// TODO: Add support for more than one workbook (where each workbook filename says part X of Y)
public class FastexcelExcelWriter implements ExcelWriter {
    private static final Logger logger = LoggerFactory.getLogger(FastexcelExcelWriter.class);

    private static final String APPLICATION_NAME = "openfda-converter";
    private static final String APPLICATION_VERSION = "1.0";
    private static final String SHEET_NAME = "Sheet 1";
    private static final String EXCEL_FILENAME_EXTENSION = "xlsx";

    @Override
    @NonNull
    public List<String> writeWorkbooks(@NonNull List<String> fields,
                                       @NonNull List<String> splitFields,
                                       @NonNull List<String> sourceFilePathStrings,
                                       @NonNull String destinationDirectoryPathString,
                                       @NonNull String destinationFilenamePrefix) {
        logger.info(
                "Write to Excel starting: {}",
                destinationDirectoryPathString
        );

        // Verify all the split fields are fields
        for (final String splitField : splitFields) {
            if (!fields.contains(splitField)) {
                logger.error("Fields does not contain split field {}", splitField);
                return Collections.emptyList();
            }
        }

        final String workbookPath = getWorkbookPath(destinationFilenamePrefix, destinationDirectoryPathString);

        try (final OutputStream outputStream = new FileOutputStream(workbookPath);
             final Workbook workbook = new Workbook(outputStream, APPLICATION_NAME, APPLICATION_VERSION)) {
            final Worksheet worksheet = workbook.newWorksheet(SHEET_NAME);

            writeHeader(fields, worksheet);
            writeRows(fields, splitFields, sourceFilePathStrings, worksheet);
        } catch (Exception exception) {
            logger.error(
                    "Error while writing Excel files to {}",
                    destinationDirectoryPathString,
                    exception
            );
            return Collections.emptyList();
        }

        logger.info(
                "Write to Excel finished: {}",
                destinationDirectoryPathString
        );
        return List.of(workbookPath);
    }

    @NonNull
    private String getWorkbookPath(@NonNull String filenamePrefix, @NonNull String destinationDirectoryPathString) {
        return String.join(
                "/",
                destinationDirectoryPathString,
                String.join(
                        "-",
                        filenamePrefix,
                        new SimpleDateFormat("yyyyMMdd-HHmmss").format(System.currentTimeMillis())
                ) + "." + EXCEL_FILENAME_EXTENSION
        );
    }

    private void writeHeader(@NonNull List<String> fields, @NonNull Worksheet worksheet) {
        int headerColCounter = 0;
        for (final String field : fields) {
            worksheet.value(0, headerColCounter, field);
            ++headerColCounter;
        }
    }

    private void writeRows(@NonNull List<String> fields,
                           @NonNull List<String> splitFields,
                           @NonNull List<String> sourceFilePathStrings,
                           @NonNull Worksheet worksheet) throws IOException {
        int rowCounter = 1;
        for (final String sourceFilePathString : sourceFilePathStrings) {
            final EndpointDataset endpointDataset = EndpointDataset.getEndpointDataset(sourceFilePathString);
            for (final EndpointDatasetResult endpointDatasetResult : endpointDataset.endpointDatasetResults()) {
                List<EndpointDatasetResult> results;
                if (!splitFields.isEmpty()) {
                    results = splitResult(endpointDatasetResult, splitFields);
                } else {
                    results = List.of(endpointDatasetResult);
                }

                for (final EndpointDatasetResult result : results) {
                    int colCounter = 0;
                    for (final String field : fields) {
                        worksheet.value(rowCounter, colCounter, result.getFieldValueAsString(field));
                        ++colCounter;
                    }
                    ++rowCounter;
                }
            }
        }
    }

    @NonNull
    @SuppressWarnings("unchecked")
    private List<EndpointDatasetResult> splitResult(@NonNull EndpointDatasetResult endpointDatasetResult,
                                                    @NonNull List<String> splitFields) {
        // Figure out how many of each split field
        final List<Integer> splitFieldsSizes = new ArrayList<>();
        for (final String splitField : splitFields) {
            final Optional<Object> fieldValueOptional = endpointDatasetResult.getFieldValue(splitField);
            if (fieldValueOptional.isEmpty()) {
                return Collections.emptyList();
            } else {
                final Object fieldValue = fieldValueOptional.get();
                final List<String> fieldValueStringList = (List<String>) fieldValue;
                splitFieldsSizes.add(fieldValueStringList.size());
            }
        }

        // Next, get the permuted indices
        final List<List<Integer>> permutedIndices = PermutationUtil.getPermutedIndices(splitFieldsSizes);

        // Finally, use the permuted indices to create results
        final List<EndpointDatasetResult> splitResults = new ArrayList<>();
        for (final List<Integer> indices : permutedIndices) {
            final Map<String, String> substitutions = new HashMap<>();
            for (int indicesIndex = 0; indicesIndex < indices.size(); ++indicesIndex) {
                final String field = splitFields.get(indicesIndex);
                final Optional<Object> fieldValuesOptional = endpointDatasetResult.getFieldValue(field);

                assert fieldValuesOptional.isPresent();

                final List<String> fieldValues = (List<String>) fieldValuesOptional.get();
                substitutions.put(field, fieldValues.get(indices.get(indicesIndex)));
            }
            splitResults.add(endpointDatasetResult.copyWithSubstitutions(endpointDatasetResult, substitutions));
        }

        return splitResults;
    }
}
