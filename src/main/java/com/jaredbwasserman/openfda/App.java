package com.jaredbwasserman.openfda;

import com.jaredbwasserman.openfda.api.Endpoint;
import com.jaredbwasserman.openfda.api.EndpointCategory;
import com.jaredbwasserman.openfda.api.FriendlyName;
import com.jaredbwasserman.openfda.api.OpenFDAAPI;
import com.jaredbwasserman.openfda.download.EndpointDownloadClient;
import com.jaredbwasserman.openfda.download.EndpointDownloadClientFactory;
import com.jaredbwasserman.openfda.download.FileDownloadClient;
import com.jaredbwasserman.openfda.download.FileDownloadClientFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        // TODO: Fix me
        final Map<String, EndpointCategory> endpointCategories = OpenFDAAPI.getEndpointCategories();

        // TODO: Fix me
        final EndpointDownloadClient endpointDownloadClient = EndpointDownloadClientFactory.getEndpointDownloadClient();
        final List<String> endpointFiles = endpointDownloadClient.downloadEndpointFiles(
                OpenFDAAPI.getEndpoints(endpointCategories.get(OpenFDAAPI.ENDPOINT_CATEGORY_DRUG_DISPLAY_NAME))
                        .get(OpenFDAAPI.ENDPOINT_PRODUCT_LABELING_DISPLAY_NAME),
                "/Users/jwasserman/Desktop/"
        );
        if (!endpointFiles.isEmpty()) {
            logger.info("Download successful: {}", endpointFiles);
        }
        else {
            logger.warn("Download unsuccessful");
        }
    }
}
