package com.jaredbwasserman.openfda;

import com.jaredbwasserman.openfda.api.OpenFDAAPI;
import com.jaredbwasserman.openfda.download.EndpointDownloadClient;
import com.jaredbwasserman.openfda.download.EndpointDownloadClientFactory;
import com.jaredbwasserman.openfda.json.JsonHelperFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        // TODO: Fix me
        final EndpointDownloadClient endpointDownloadClient = EndpointDownloadClientFactory.getEndpointDownloadClient();
        final List<String> endpointFiles = endpointDownloadClient.downloadAndUnzipEndpointFiles(
                OpenFDAAPI.getEndpoint(OpenFDAAPI.ENDPOINT_CATEGORY_DRUG, OpenFDAAPI.ENDPOINT_PRODUCT_LABELING),
                "/Users/jwasserman/Desktop"
        );
        if (!endpointFiles.isEmpty()) {
            logger.info("Download successful: {}", endpointFiles);
        } else {
            logger.warn("Download unsuccessful");
        }

        // TODO: Fix me
        final Set<String> drugLabelKeys = new HashSet<>();
        for (final String endpointFile : endpointFiles) {
            drugLabelKeys.addAll(JsonHelperFactory.getJsonHelper().getUniqueKeysForEndpointDataset(endpointFile));
        }
        final List<String> drugLabelKeysList = new ArrayList<>(drugLabelKeys);
        Collections.sort(drugLabelKeysList);
        drugLabelKeysList.forEach(logger::info);
    }
}
