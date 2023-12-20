package com.jaredbwasserman.openfda.download;

import com.jaredbwasserman.openfda.api.Endpoint;
import lombok.NonNull;

import java.util.List;

public interface FileManifestClient {
    @NonNull
    List<String> getFileUrlStrings(@NonNull Endpoint endpoint, @NonNull String destinationDirectoryPathString);
}
