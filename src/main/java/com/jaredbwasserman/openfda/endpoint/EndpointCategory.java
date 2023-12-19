package com.jaredbwasserman.openfda.endpoint;

import java.util.Map;

public record EndpointCategory(
        String displayName,
        String internalName,
        Map<String, Endpoint> endpoints) {
}
