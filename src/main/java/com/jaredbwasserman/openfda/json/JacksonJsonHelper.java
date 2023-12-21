package com.jaredbwasserman.openfda.json;

import com.jaredbwasserman.openfda.model.EndpointDataset;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class JacksonJsonHelper implements JsonHelper {
    private static final Logger logger = LoggerFactory.getLogger(JacksonJsonHelper.class);

    @Override
    @NonNull
    public Set<String> getUniqueKeysForEndpointDataset(@NonNull String sourceJsonFilePathString) {
        Optional<EndpointDataset> endpointDatasetOptional = EndpointDataset.fromFilePathString(sourceJsonFilePathString);
        if (endpointDatasetOptional.isEmpty()) {
            logger.warn(
                    "Could not create EndpointDataset for {}",
                    sourceJsonFilePathString
            );
            return Collections.emptySet();
        }

        final Set<String> uniqueKeys = new HashSet<>();
        for (final Map<String, Object> result : endpointDatasetOptional.get().results()) {
            uniqueKeys.addAll(result.keySet());
        }
        return uniqueKeys;
    }
}
