package com.jaredbwasserman.openfda.download;

import com.jaredbwasserman.openfda.api.Endpoint;
import lombok.NonNull;

import java.util.List;

public interface EndpointDownloadClient {
    @NonNull
    List<String> downloadAndUnzipEndpointFiles(@NonNull Endpoint endpoint, @NonNull String destinationDirectoryPathString);
}
