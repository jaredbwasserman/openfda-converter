package com.jaredbwasserman.openfda.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

public record EndpointDatasetRaw(
        @JsonProperty("meta") Map<String, Object> meta,
        @JsonProperty("results") List<Map<String, Object>> results) {
}
