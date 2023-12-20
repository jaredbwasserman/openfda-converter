package com.jaredbwasserman.openfda.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record FileManifestDataset(
        @JsonProperty("export_date") String exportDate,
        @JsonProperty("partitions") List<FileManifestDatasetPartition> partitions,
        @JsonProperty("total_records") long totalRecords) {
}
