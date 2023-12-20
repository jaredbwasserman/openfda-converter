package com.jaredbwasserman.openfda.download;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jaredbwasserman.openfda.api.Endpoint;
import com.jaredbwasserman.openfda.api.OpenFDAAPI;
import com.jaredbwasserman.openfda.model.FileManifest;
import com.jaredbwasserman.openfda.model.FileManifestDataset;
import com.jaredbwasserman.openfda.model.FileManifestDatasetPartition;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public record SimpleFileManifestClient(
        FileDownloadClient fileDownloadClient) implements FileManifestClient {
    private static final Logger logger = LoggerFactory.getLogger(SimpleFileManifestClient.class);
    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    @NonNull
    public List<String> getFileUrlStrings(@NonNull Endpoint endpoint, @NonNull String destinationDirectoryPathString) {
        // First, download the file manifest
        final Optional<String> fileManifestFilePathStringOptional = fileDownloadClient.downloadFile(
                OpenFDAAPI.getFileManifestUrlString(),
                destinationDirectoryPathString
        );
        if (fileManifestFilePathStringOptional.isEmpty()) {
            logger.warn(
                    "Could not download file manifest for endpoint {} and destination directory {}",
                    endpoint,
                    destinationDirectoryPathString
            );
            return Collections.emptyList();
        }
        final String fileManifestFilePathString = fileManifestFilePathStringOptional.get();

        // Next, create a file manifest object
        FileManifest fileManifest;
        try {
            fileManifest = mapper.readValue(new File(fileManifestFilePathString), FileManifest.class);
        } catch (Exception exception) {
            logger.error(
                    "Error while reading file manifest {} into FileManifest object",
                    fileManifestFilePathString,
                    exception
            );
            return Collections.emptyList();
        }

        // Finally, parse the file manifest to get the list of files to download
        return getFileUrlStrings(endpoint, fileManifest);
    }

    @NonNull
    private List<String> getFileUrlStrings(@NonNull Endpoint endpoint, @NonNull FileManifest fileManifest) {
        final String endpointCategoryInternalName = endpoint.endpointCategory().friendlyName().internalName();
        final String endpointInternalName = endpoint.friendlyName().internalName();

        final Map<String, FileManifestDataset> fileManifestDatasets = fileManifest.results().getOrDefault(endpointCategoryInternalName, null);
        if (null == fileManifestDatasets) {
            logger.warn(
                    "Could not get datasets for endpoint category {} from file manifest",
                    endpointCategoryInternalName
            );
            return Collections.emptyList();
        }

        final FileManifestDataset fileManifestDataset = fileManifestDatasets.getOrDefault(endpointInternalName, null);
        if (null == fileManifestDataset) {
            logger.warn(
                    "Could not get dataset for endpoint {} from file manifest",
                    endpointInternalName
            );
            return Collections.emptyList();
        }

        final List<String> fileUrlStrings = new ArrayList<>();
        for (final FileManifestDatasetPartition fileManifestDatasetPartition : fileManifestDataset.partitions()) {
            fileUrlStrings.add(fileManifestDatasetPartition.file());
        }
        return fileUrlStrings;
    }
}
