package com.jaredbwasserman.openfda.model.generated;

import lombok.NonNull;

import java.util.List;

public class TobaccoProblem {
    @NonNull
    public static List<String> getFields() {
        return List.of(
                "date_submitted",
                "nonuser_affected",
                "number_health_problems",
                "number_product_problems",
                "number_tobacco_products",
                "report_id",
                "reported_health_problems",
                "reported_product_problems",
                "tobacco_products"
        );
    }
}
