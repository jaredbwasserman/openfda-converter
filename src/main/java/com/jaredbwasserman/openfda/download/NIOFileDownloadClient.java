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

public class NIOFileDownloadClient implements FileDownloadClient {
    private static final Logger logger = LoggerFactory.getLogger(NIOFileDownloadClient.class);

    @Override
    public void downloadFile(@NonNull String sourceUrlString, @NonNull String destinationFilePathString) {
        logger.info(
                "Download starting: {} -> {}",
                sourceUrlString,
                destinationFilePathString
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
            return;
        }

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
                return;
            }
        } catch (IOException ioException) {
            logger.error(
                    "Error while opening stream for URL {}",
                    sourceUrl,
                    ioException
            );
            return;
        }

        logger.info(
                "Download finished: {} -> {}",
                sourceUrlString,
                destinationFilePathString
        );
    }
}
