package com.jaredbwasserman.openfda.zip;

import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

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

        // Source file name
        String sourceFilename;
        try (final ZipFile sourceZipFile = new ZipFile(sourceZipFilePathString)) {
            final List<String> sourceZipFileEntries = sourceZipFile
                    .stream()
                    .map(ZipEntry::getName)
                    .toList();

            if (1 != sourceZipFileEntries.size()) {
                throw new RuntimeException(String.format(
                        "There should be exactly 1 file in %s but there were %d files", sourceZipFilePathString, sourceZipFileEntries.size()
                ));
            }

            sourceFilename = sourceZipFileEntries.get(0);
        } catch (Exception exception) {
            logger.error(
                    "Error while computing source zip file name for {}",
                    sourceZipFilePathString,
                    exception
            );
            return Optional.empty();
        }

        // Destination file path
        final String destinationFilePathString = sourceZipFilePathString.substring(
                0,
                sourceZipFilePathString.lastIndexOf(ZIP_SUFFIX)
        );

        // Extract
        try (final FileSystem zipFileSystem = FileSystems.newFileSystem(Paths.get(sourceZipFilePathString))) {
            Files.copy(
                    zipFileSystem.getPath(sourceFilename),
                    Paths.get(destinationFilePathString)
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
