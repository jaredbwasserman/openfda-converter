package com.jaredbwasserman.openfda.zip;

import lombok.NonNull;

import java.util.Optional;

public interface FileZipper {
    @NonNull
    Optional<String> unzipFile(@NonNull String sourceZipFilePathString);
}
