package com.jaredbwasserman.openfda.excel;

import lombok.NonNull;

import java.util.List;

public interface ExcelWriter {
    @NonNull
    List<String> writeWorkbooks(@NonNull List<String> fields,
                                @NonNull List<String> splitFields,
                                @NonNull List<String> sourceFilePathStrings,
                                @NonNull String destinationDirectoryPathString,
                                @NonNull String destinationFilenamePrefix);
}
