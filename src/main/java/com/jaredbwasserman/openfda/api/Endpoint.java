package com.jaredbwasserman.openfda.api;

import lombok.NonNull;
import org.apache.commons.lang3.StringUtils;

public record Endpoint(
        @NonNull FriendlyName friendlyName,
        @NonNull FriendlyName endpointCategoryFriendlyName) {
    @NonNull
    public String getConcatenatedName() {
        return StringUtils.capitalize(endpointCategoryFriendlyName.internalName()) +
                StringUtils.capitalize(friendlyName.internalName());
    }
}
