package com.jaredbwasserman.openfda.model.generated;

import lombok.NonNull;

import java.util.List;

public class FoodEvent {
    @NonNull
    public static List<String> getFields() {
        return List.of(
                "consumer.age",
                "consumer.age_unit",
                "consumer.gender",
                "date_created",
                "date_started",
                "outcomes",
                "products",
                "reactions",
                "report_number"
        );
    }
}
