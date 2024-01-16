package com.jaredbwasserman.openfda.ui.endpoint;

import com.jaredbwasserman.openfda.api.Endpoint;
import lombok.NonNull;

public record EndpointComboItem(
        @NonNull String label,
        @NonNull Endpoint endpoint) {
    @Override
    public String toString() {
        return label;
    }
}
