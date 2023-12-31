package com.jaredbwasserman.openfda.model.generated;

import lombok.NonNull;

import java.util.List;

public class OtherNsde {
    @NonNull
    public static List<String> getFields() {
        return List.of(
                "application_number_or_citation",
                "billing_unit",
                "dosage_form",
                "inactivation_date",
                "marketing_category",
                "marketing_end_date",
                "marketing_start_date",
                "package_ndc",
                "package_ndc11",
                "product_type",
                "proprietary_name",
                "reactivation_date"
        );
    }
}
