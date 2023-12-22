package com.jaredbwasserman.openfda.excel;

import com.jaredbwasserman.openfda.api.Endpoint;
import lombok.NonNull;

import java.util.List;

public interface ExcelWriter {
    @NonNull
    List<String> writeWorkbooks(@NonNull Endpoint endpoint,
                                @NonNull List<String> sourceFilePathStrings,
                                @NonNull String destinationDirectoryPathString);
}
