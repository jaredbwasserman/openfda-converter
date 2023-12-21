package com.jaredbwasserman.openfda.api;

import lombok.NonNull;

import java.util.List;

public record EndpointCategory(
        @NonNull FriendlyName friendlyName,
        @NonNull List<Endpoint> endpoints) {
}
