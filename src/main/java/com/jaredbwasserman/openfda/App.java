package com.jaredbwasserman.openfda;

import com.jaredbwasserman.openfda.api.EndpointCategory;
import com.jaredbwasserman.openfda.api.OpenFDAAPI;
import com.jaredbwasserman.openfda.download.FileDownloadClient;
import com.jaredbwasserman.openfda.download.FileDownloadClientFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Optional;

public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        // TODO: Fix me
        final Map<String, EndpointCategory> endpointCategories = OpenFDAAPI.getEndpointCategories();
        for (final Map.Entry<String, EndpointCategory> endpointCategoryEntry : endpointCategories.entrySet()) {
            logger.info(endpointCategoryEntry.getKey());
            logger.info("\t" + OpenFDAAPI.getEndpoints(endpointCategoryEntry.getValue()));
        }

        // TODO: Fix me
        final FileDownloadClient fileDownloadClient = FileDownloadClientFactory.getFileDownloadClient();
        final Optional<String> destinationFilePathStringOptional = fileDownloadClient.downloadFile(
                "https://api.fda.gov/download.json",
                "/Users/jwasserman/Desktop/"
        );
        if (destinationFilePathStringOptional.isPresent()) {
            logger.info("Download successful: {}", destinationFilePathStringOptional.get());
        } else {
            logger.warn("Download unsuccessful");
        }
    }
}
