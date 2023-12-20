package com.jaredbwasserman.openfda.zip;

import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

public class SimpleFileZipper implements FileZipper {
    private static final Logger logger = LoggerFactory.getLogger(SimpleFileZipper.class);

    private static final String ZIP_SUFFIX = ".zip";

    @Override
    @NonNull
    public Optional<String> unzipFile(@NonNull String sourceZipFilePathString) {
        if (!sourceZipFilePathString.endsWith(ZIP_SUFFIX)) {
            logger.error(
                    "Could not extract {} because it does not end with {}",
                    sourceZipFilePathString,
                    ZIP_SUFFIX
            );
            return Optional.empty();
        }

        final String destinationFilePathString = sourceZipFilePathString.substring(
                0,
                sourceZipFilePathString.lastIndexOf(ZIP_SUFFIX)
        );
        final Path destinationFilePath = Paths.get(destinationFilePathString);

        try (final FileSystem zipFileSystem = FileSystems.newFileSystem(Paths.get(sourceZipFilePathString))) {
            Files.copy(
                    zipFileSystem.getPath(destinationFilePath.getFileName().toString()),
                    destinationFilePath
            );
            return Optional.of(destinationFilePathString);
        } catch (Exception exception) {
            logger.error(
                    "Error while extracting zip file {} to {}",
                    sourceZipFilePathString,
                    destinationFilePathString,
                    exception
            );
            return Optional.empty();
        }
    }
}
