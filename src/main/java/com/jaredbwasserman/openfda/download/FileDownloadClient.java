package com.jaredbwasserman.openfda.download;

import lombok.NonNull;

public interface FileDownloadClient {
    boolean downloadFile(@NonNull String sourceUrlString, @NonNull String destinationFilePathString);
}
