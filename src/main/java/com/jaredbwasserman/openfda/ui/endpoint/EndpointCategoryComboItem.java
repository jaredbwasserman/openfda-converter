package com.jaredbwasserman.openfda.ui.endpoint;

import com.jaredbwasserman.openfda.api.EndpointCategory;
import lombok.NonNull;

public record EndpointCategoryComboItem(
        @NonNull String label,
        @NonNull EndpointCategory endpointCategory) {
    @Override
    public String toString() {
        return label;
    }
}
