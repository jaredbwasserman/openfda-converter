package com.jaredbwasserman.openfda;

import com.jaredbwasserman.openfda.api.Endpoint;
import com.jaredbwasserman.openfda.api.EndpointCategory;
import com.jaredbwasserman.openfda.api.OpenFDAAPI;
import com.jaredbwasserman.openfda.download.EndpointDownloadClient;
import com.jaredbwasserman.openfda.download.EndpointDownloadClientFactory;
import com.jaredbwasserman.openfda.excel.ExcelWriter;
import com.jaredbwasserman.openfda.excel.ExcelWriterFactory;
import com.jaredbwasserman.openfda.ui.MainForm;
import com.jaredbwasserman.openfda.util.FileUtil;

import java.util.List;

public class App {
    public static void main(String[] args) {
        new MainForm();
    }

    // TODO: Fix me
    private void doWork() {
        // Helpers
        final EndpointDownloadClient endpointDownloadClient = EndpointDownloadClientFactory.getEndpointDownloadClient();
        final ExcelWriter excelWriter = ExcelWriterFactory.getExcelWriter();

        // TODO: This is ugly
        // Drug label endpoint
        final EndpointCategory drugEndpointCategory = OpenFDAAPI.getEndpointCategories().stream().filter((endpointCategory) -> "drug".equals(endpointCategory.friendlyName().internalName())).findFirst().get();
        final Endpoint drugLabelEndpoint = drugEndpointCategory.endpoints().stream().filter((endpoint) -> "label".equals(endpoint.friendlyName().internalName())).findFirst().get();

        // Download
        final List<String> endpointDatasetFilePathStrings = endpointDownloadClient.downloadAndUnzipEndpointFiles(drugLabelEndpoint, "/Users/jwasserman/Desktop");

        // Write to Excel
        excelWriter.writeWorkbooks(
                List.of(
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
                ),
                List.of(
                        "openfda.package_ndc"
                ),
                endpointDatasetFilePathStrings,
                "/Users/jwasserman/Desktop",
                drugLabelEndpoint.getCamelCaseName()
        );

        // Clean up
        endpointDatasetFilePathStrings.forEach(FileUtil::deleteFile);
    }
}
