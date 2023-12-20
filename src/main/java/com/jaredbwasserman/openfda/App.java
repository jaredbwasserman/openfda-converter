package com.jaredbwasserman.openfda;

import com.jaredbwasserman.openfda.api.OpenFDAAPI;
import com.jaredbwasserman.openfda.download.EndpointDownloadClient;
import com.jaredbwasserman.openfda.download.EndpointDownloadClientFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        // TODO: Fix me
        final EndpointDownloadClient endpointDownloadClient = EndpointDownloadClientFactory.getEndpointDownloadClient();
        final List<String> endpointFiles = endpointDownloadClient.downloadEndpointFiles(
                OpenFDAAPI.getEndpoint(OpenFDAAPI.ENDPOINT_CATEGORY_DRUG, OpenFDAAPI.ENDPOINT_PRODUCT_LABELING),
                "/Users/jwasserman/Desktop"
        );
        if (!endpointFiles.isEmpty()) {
            logger.info("Download successful: {}", endpointFiles);
        } else {
            logger.warn("Download unsuccessful");
        }
    }
}
