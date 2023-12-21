package com.jaredbwasserman.openfda.api;

import lombok.NonNull;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public record Endpoint(
        @NonNull FriendlyName friendlyName,
        @NonNull FriendlyName endpointCategoryFriendlyName,
        @NonNull List<String> keys) {
    @NonNull
    public String getConcatenatedName() {
        return StringUtils.capitalize(endpointCategoryFriendlyName.internalName()) +
                StringUtils.capitalize(friendlyName.internalName());
    }
}
