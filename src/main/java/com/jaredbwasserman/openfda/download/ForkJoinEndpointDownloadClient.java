package com.jaredbwasserman.openfda.download;

import com.jaredbwasserman.openfda.api.Endpoint;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

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

        // Next, download all the files
        List<String> destinationFilePathStrings;
        try {
            destinationFilePathStrings = new ForkJoinPool(fileUrlStrings.size())
                    .submit(() -> processFileUrlStrings(fileUrlStrings, destinationDirectoryPathString))
                    .get();
        } catch (Exception exception) {
            logger.error(
                    "Error while downloading files for endpoint {} with files {} to {}",
                    endpoint,
                    fileUrlStrings,
                    destinationDirectoryPathString,
                    exception
            );
            return Collections.emptyList();
        }

        logger.info(
                "Download finished: {} -> {}",
                endpoint,
                destinationDirectoryPathString
        );
        return destinationFilePathStrings;
    }

    @NonNull
    private List<String> processFileUrlStrings(@NonNull List<String> fileUrlStrings, @NonNull String destinationDirectoryPathString) {
        return fileUrlStrings
                .stream()
                .parallel()
                .map((fileUrlString) -> processFileUrlString(fileUrlString, destinationDirectoryPathString))
                .collect(Collectors.toList());
    }

    @NonNull
    private String processFileUrlString(@NonNull String fileUrlString, @NonNull String destinationDirectoryPathString) {
        final Optional<String> filePathStringOptional = fileDownloadClient.downloadFile(
                fileUrlString,
                destinationDirectoryPathString
        );
        if (filePathStringOptional.isEmpty()) {
            throw new RuntimeException(String.format(
                    "Unable to download file %s to directory %s", fileUrlString, destinationDirectoryPathString
            ));
        }
        return filePathStringOptional.get();
    }
}
