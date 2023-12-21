package com.jaredbwasserman.openfda.download;

import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.util.Optional;

public class NIOFileDownloadClient implements FileDownloadClient {
    private static final Logger logger = LoggerFactory.getLogger(NIOFileDownloadClient.class);

    @Override
    @NonNull
    public Optional<String> downloadFile(@NonNull String sourceUrlString, @NonNull String destinationDirectoryPathString) {
        logger.info(
                "Download starting: {} -> {}",
                sourceUrlString,
                destinationDirectoryPathString
        );

        URL sourceUrl;
        try {
            sourceUrl = new URL(sourceUrlString);
        } catch (MalformedURLException malformedURLException) {
            logger.error(
                    "Error while creating URL for {}",
                    sourceUrlString,
                    malformedURLException
            );
            return Optional.empty();
        }

        final String destinationFilePathString = getDestinationFilePathString(sourceUrl, destinationDirectoryPathString);

        try (final InputStream urlInputStream = sourceUrl.openStream()) {
            try (final FileOutputStream fileOutputStream = new FileOutputStream(destinationFilePathString)) {
                fileOutputStream.getChannel().transferFrom(
                        Channels.newChannel(urlInputStream),
                        0,
                        Long.MAX_VALUE
                );
            } catch (IOException ioException) {
                logger.error(
                        "Error while creating FileOutputStream for {}",
                        destinationFilePathString,
                        ioException
                );
                return Optional.empty();
            }
        } catch (IOException ioException) {
            logger.error(
                    "Error while opening stream for URL {}",
                    sourceUrl,
                    ioException
            );
            return Optional.empty();
        }

        logger.info(
                "Download finished: {} -> {}",
                sourceUrlString,
                destinationDirectoryPathString
        );
        return Optional.of(destinationFilePathString);
    }

    @NonNull
    private String getDestinationFilePathString(@NonNull URL sourceUrl, @NonNull String destinationDirectoryPathString) {
        return String.join(
                "/",
                destinationDirectoryPathString,
                sourceUrl.getPath().replace("/", "-").replaceFirst("^-", "")
        );
    }
}
