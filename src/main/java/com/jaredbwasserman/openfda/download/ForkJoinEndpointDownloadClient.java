package com.jaredbwasserman.openfda.download;

import com.jaredbwasserman.openfda.api.Endpoint;
import com.jaredbwasserman.openfda.util.FileUtil;
import com.jaredbwasserman.openfda.zip.FileZipper;
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
        FileDownloadClient fileDownloadClient,
        FileZipper fileZipper) implements EndpointDownloadClient {
    private static final Logger logger = LoggerFactory.getLogger(ForkJoinEndpointDownloadClient.class);

    private static final int MAX_THREADS = 20;

    @Override
    @NonNull
    public List<String> downloadAndUnzipEndpointFiles(@NonNull Endpoint endpoint, @NonNull String destinationDirectoryPathString) {
        logger.info(
                "Download and unzip starting: {} -> {}",
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
            destinationFilePathStrings = new ForkJoinPool(Math.min(fileUrlStrings.size(), MAX_THREADS))
                    .submit(() -> processFileUrlStrings(fileUrlStrings, destinationDirectoryPathString))
                    .get();
        } catch (Exception exception) {
            logger.error(
                    "Error while downloading and unzipping files for endpoint {} with files {} to {}",
                    endpoint,
                    fileUrlStrings,
                    destinationDirectoryPathString,
                    exception
            );
            return Collections.emptyList();
        }

        logger.info(
                "Download and unzip finished: {} -> {}",
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
        // Download
        final Optional<String> zippedFilePathStringOptional = fileDownloadClient.downloadFile(
                fileUrlString,
                destinationDirectoryPathString
        );
        if (zippedFilePathStringOptional.isEmpty()) {
            throw new RuntimeException(String.format(
                    "Unable to download file %s to directory %s", fileUrlString, destinationDirectoryPathString
            ));
        }
        final String zippedFilePathString = zippedFilePathStringOptional.get();

        // Unzip
        final Optional<String> unzippedFilePathStringOptional = fileZipper.unzipFile(zippedFilePathString);
        if (unzippedFilePathStringOptional.isEmpty()) {
            throw new RuntimeException(String.format(
                    "Unable to extract file %s", zippedFilePathString
            ));
        }

        // Delete the zipped file
        FileUtil.deleteFile(zippedFilePathString);

        return unzippedFilePathStringOptional.get();
    }
}
