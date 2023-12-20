package com.jaredbwasserman.openfda.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record FileManifestDatasetPartition(
        @JsonProperty("display_name") String displayName,
        @JsonProperty("file") String file,
        @JsonProperty("size_mb") String sizeMb,
        @JsonProperty("records") long records) {
}
