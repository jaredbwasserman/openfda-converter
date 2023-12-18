package com.jaredbwasserman.openfda.endpoint;

import java.util.List;

public record EndpointCategory(
        String displayName,
        String internalName,
        List<Endpoint> endpoints) {
}
