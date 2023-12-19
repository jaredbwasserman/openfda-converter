package com.jaredbwasserman.openfda.download;

import lombok.NonNull;

import java.util.Optional;

public interface FileDownloadClient {
    @NonNull
    Optional<String> downloadFile(@NonNull String sourceUrlString, @NonNull String destinationDirectoryPathString);
}
