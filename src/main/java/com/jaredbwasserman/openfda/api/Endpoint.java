package com.jaredbwasserman.openfda.api;

import lombok.NonNull;

public record Endpoint(
        @NonNull FriendlyName friendlyName,
        @NonNull EndpointCategory endpointCategory) {
}
