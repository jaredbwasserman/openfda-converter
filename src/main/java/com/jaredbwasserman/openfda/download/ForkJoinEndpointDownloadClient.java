package com.jaredbwasserman.openfda.download;

import com.jaredbwasserman.openfda.api.Endpoint;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;

public record ForkJoinEndpointDownloadClient(
        FileManifestClient fileManifestClient,
        FileDownloadClient fileDownloadClient) implements EndpointDownloadClient {
    private static final Logger logger = LoggerFactory.getLogger(ForkJoinEndpointDownloadClient.class);

    @Override
    @NonNull
    public List<String> downloadEndpointFiles(@NonNull Endpoint endpoint, @NonNull String destinationDirectoryPathString) {
        logger.info(
                "Download starting: {} -> {}",
                endpoint,
                destinationDirectoryPathString
        );

        // First, get the file URL strings for this endpoint
        final List<String> fileUrlStrings = fileManifestClient.getFileUrlStrings(endpoint, destinationDirectoryPathString);
        if (fileUrlStrings.isEmpty()) {
            logger.warn(
                    "Could not get files for endpoint {} from file manifest",
                    endpoint
            );
            return Collections.emptyList();
        }

        // TODO: Implement me

        // TODO: Fix me
        logger.info(
                "Download finished: {} -> {}",
                endpoint,
                destinationDirectoryPathString
        );
        return Collections.emptyList();
    }
}
