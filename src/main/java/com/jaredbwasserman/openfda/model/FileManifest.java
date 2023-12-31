package com.jaredbwasserman.openfda.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public record FileManifest(
        @JsonProperty("meta") Map<String, Object> meta,
        @JsonProperty("results") Map<String, Map<String, FileManifestDataset>> results) {
}
