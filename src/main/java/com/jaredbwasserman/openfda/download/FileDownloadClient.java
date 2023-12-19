package com.jaredbwasserman.openfda.download;

import lombok.NonNull;

public interface FileDownloadClient {
    void downloadFile(@NonNull String sourceUrlString, @NonNull String destinationFilePathString);
}
