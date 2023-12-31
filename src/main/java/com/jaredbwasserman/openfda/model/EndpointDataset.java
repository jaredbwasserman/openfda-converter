package com.jaredbwasserman.openfda.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NonNull;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public record EndpointDataset(
        Map<String, Object> meta,
        List<EndpointDatasetResult> endpointDatasetResults) {
    private static final ObjectMapper mapper = new ObjectMapper();

    @SuppressWarnings("unchecked")
    public static EndpointDataset getEndpointDataset(@NonNull String sourceFilePathString) throws IOException {
        final EndpointDatasetRaw endpointDatasetRaw = mapper.readValue(
                new File(sourceFilePathString),
                EndpointDatasetRaw.class
        );

        List<EndpointDatasetResult> endpointDatasetResults = new ArrayList<>();
        for (final Object endpointDatasetResult : endpointDatasetRaw.endpointDatasetResults()) {
            endpointDatasetResults.add(new EndpointDatasetResult((HashMap<String, Object>) endpointDatasetResult));
        }

        return new EndpointDataset(
                endpointDatasetRaw.meta(),
                endpointDatasetResults
        );
    }

    private record EndpointDatasetRaw(
            @JsonProperty("meta") Map<String, Object> meta,
            @JsonProperty("results") List<Object> endpointDatasetResults) {
    }
}
