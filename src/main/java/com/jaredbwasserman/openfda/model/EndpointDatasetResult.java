package com.jaredbwasserman.openfda.model;

import lombok.NonNull;
import org.apache.commons.lang3.SerializationUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class EndpointDatasetResult {
    private final HashMap<String, Object> map;

    EndpointDatasetResult(HashMap<String, Object> map) {
        this.map = map;
    }

    @NonNull
    public HashMap<String, Object> getDeepCopyOfMap() {
        return SerializationUtils.clone(map);
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Optional<Object> getFieldValue(@NonNull String field) {
        final List<String> fieldSplits = Arrays.stream(field.split("\\.")).toList();

        if (fieldSplits.isEmpty()) {
            return Optional.empty();
        }

        Map<String, Object> fieldMap = map;
        for (int i = 0; i < fieldSplits.size(); ++i) {
            final String fieldSplit = fieldSplits.get(i);
            if (fieldSplits.size() - 1 == i) {
                final Object fieldValue = fieldMap.getOrDefault(fieldSplit, null);
                if (null == fieldValue) {
                    return Optional.empty();
                }
                return Optional.of(fieldValue);
            } else {
                fieldMap = (Map<String, Object>) fieldMap.getOrDefault(fieldSplit, null);
                if (null == fieldMap) {
                    return Optional.empty();
                }
            }
        }

        throw new RuntimeException(String.format(
                "Could not get field value for field %s", field
        ));
    }

    @SuppressWarnings("unchecked")
    public void putFieldValue(@NonNull String field, @NonNull String newFieldValue) {
        final List<String> fieldSplits = Arrays.stream(field.split("\\.")).toList();

        if (fieldSplits.isEmpty()) {
            return;
        }

        Map<String, Object> fieldMap = map;
        for (int i = 0; i < fieldSplits.size(); ++i) {
            final String fieldSplit = fieldSplits.get(i);
            if (fieldSplits.size() - 1 == i) {
                fieldMap.put(fieldSplit, newFieldValue);
                return;
            } else {
                fieldMap = (Map<String, Object>) fieldMap.getOrDefault(fieldSplit, null);
                if (null == fieldMap) {
                    return;
                }
            }
        }

        throw new RuntimeException(String.format(
                "Could not put field value %s for field %s", newFieldValue, field
        ));
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public String getFieldValueAsString(@NonNull String field) {
        final Optional<Object> fieldValueOptional = getFieldValue(field);
        if (fieldValueOptional.isEmpty()) {
            return StringUtils.EMPTY;
        }
        final Object fieldValue = fieldValueOptional.get();

        if (fieldValue instanceof List) {
            return String.join(
                    ", ",
                    ((List<Object>) fieldValue).stream().map(String::valueOf).toList()
            );
        }
        return String.valueOf(fieldValue);
    }

    @NonNull
    public EndpointDatasetResult copyWithSubstitutions(@NonNull EndpointDatasetResult endpointDatasetResultOriginal,
                                                       @NonNull Map<String, String> substitutions) {
        final EndpointDatasetResult endpointDatasetResult = new EndpointDatasetResult(
                endpointDatasetResultOriginal.getDeepCopyOfMap()
        );
        for (final Map.Entry<String, String> substitution : substitutions.entrySet()) {
            endpointDatasetResult.putFieldValue(substitution.getKey(), substitution.getValue());
        }
        return endpointDatasetResult;
    }
}
