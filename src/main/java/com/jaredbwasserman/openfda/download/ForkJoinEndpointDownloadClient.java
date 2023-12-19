package com.jaredbwasserman.openfda.download;

import com.jaredbwasserman.openfda.api.Endpoint;
import lombok.NonNull;

import java.util.Collections;
import java.util.List;

public record ForkJoinEndpointDownloadClient(
        FileDownloadClient fileDownloadClient) implements EndpointDownloadClient {
    @Override
    @NonNull
    public List<String> downloadEndpointFiles(@NonNull Endpoint endpoint, @NonNull String destinationDirectoryPathString) {
        // TODO: Fix me
        return Collections.emptyList();
    }
}
