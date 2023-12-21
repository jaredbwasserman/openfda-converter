package com.jaredbwasserman.openfda.json;

import lombok.NonNull;

import java.util.Set;

public interface JsonHelper {
    @NonNull
    Set<String> getUniqueKeysForEndpointDataset(@NonNull String sourceJsonFilePathString);
}
