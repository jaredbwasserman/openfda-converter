package com.jaredbwasserman.openfda.api;

import lombok.NonNull;

public record FriendlyName(
        @NonNull String displayName,
        @NonNull String internalName) {
}
