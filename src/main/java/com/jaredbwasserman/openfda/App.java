package com.jaredbwasserman.openfda;

import com.jaredbwasserman.openfda.api.Endpoint;
import com.jaredbwasserman.openfda.api.EndpointCategory;
import com.jaredbwasserman.openfda.api.OpenFDAAPI;
import com.jaredbwasserman.openfda.download.EndpointDownloadClient;
import com.jaredbwasserman.openfda.download.EndpointDownloadClientFactory;
import com.jaredbwasserman.openfda.excel.ExcelWriter;
import com.jaredbwasserman.openfda.excel.ExcelWriterFactory;
import com.jaredbwasserman.openfda.util.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    // TODO: Fix me
    public static void main(String[] args) {
        // Helpers
        final EndpointDownloadClient endpointDownloadClient = EndpointDownloadClientFactory.getEndpointDownloadClient();
        final ExcelWriter excelWriter = ExcelWriterFactory.getExcelWriter();

        // TODO: This is ugly
        // Drug label endpoint
        final EndpointCategory drugEndpointCategory = OpenFDAAPI.getEndpointCategories().stream().filter((endpointCategory) -> "drug".equals(endpointCategory.friendlyName().internalName())).findFirst().get();
        final Endpoint drugLabelEndpoint = drugEndpointCategory.endpoints().stream().filter((endpoint) -> "label".equals(endpoint.friendlyName().internalName())).findFirst().get();

        // Download
        final List<String> endpointDatasetFilePathStrings = endpointDownloadClient
                .downloadAndUnzipEndpointFiles(
                        drugLabelEndpoint,
                        "/Users/jwasserman/Desktop"
                );

        // Write to Excel
        excelWriter.writeWorkbooks(drugLabelEndpoint, endpointDatasetFilePathStrings, "/Users/jwasserman/Desktop");

        // Clean up
        endpointDatasetFilePathStrings.forEach(FileUtil::deleteFile);
    }
}
