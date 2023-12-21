package com.jaredbwasserman.openfda.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public record EndpointDataset(
        @JsonProperty("meta") Map<String, Object> meta,
        @JsonProperty("results") List<Map<String, Object>> results) {
    private static final Logger logger = LoggerFactory.getLogger(EndpointDataset.class);
    private static final ObjectMapper mapper = new ObjectMapper();

    private static final String OPEN_FDA_KEY = "openfda";

    public static Optional<EndpointDataset> fromFilePathString(@NonNull String sourceJsonFilePathString) {
        EndpointDatasetRaw endpointDatasetRaw;
        try {
            endpointDatasetRaw = mapper.readValue(new File(sourceJsonFilePathString), EndpointDatasetRaw.class);
        } catch (Exception exception) {
            logger.error(
                    "Error while reading EndpointDatasetRaw for {}",
                    sourceJsonFilePathString,
                    exception
            );
            return Optional.empty();
        }

        return Optional.of(fromEndpointDatasetRaw(endpointDatasetRaw));
    }

    private static EndpointDataset fromEndpointDatasetRaw(EndpointDatasetRaw endpointDatasetRaw) {
        final List<Map<String, Object>> results = new ArrayList<>();
        for (final Map<String, Object> rawResult : endpointDatasetRaw.results()) {
            final Map<String, Object> result = new HashMap<>(rawResult
                    .entrySet()
                    .stream()
                    .filter((entry) -> !entry.getKey().equals(OPEN_FDA_KEY))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)) // TODO: Fix Null Pointer
            );

            @SuppressWarnings("unchecked") final Map<String, Object> rawResultOpenFDA = (Map<String, Object>) rawResult.getOrDefault(OPEN_FDA_KEY, null);
            if (null != rawResultOpenFDA) {
                rawResultOpenFDA.forEach((key, value) ->
                        result.put(String.join(".", OPEN_FDA_KEY, key), value)
                );
            }

            results.add(result);
        }

        return new EndpointDataset(
                endpointDatasetRaw.meta(),
                results
        );
    }
}
