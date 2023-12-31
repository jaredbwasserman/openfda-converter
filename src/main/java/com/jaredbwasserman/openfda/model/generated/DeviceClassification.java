package com.jaredbwasserman.openfda.model.generated;

import lombok.NonNull;

import java.util.List;

public class DeviceClassification {
    @NonNull
    public static List<String> getFields() {
        return List.of(
                "definition",
                "device_class",
                "device_name",
                "gmp_exempt_flag",
                "implant_flag",
                "life_sustain_support_flag",
                "medical_specialty",
                "medical_specialty_description",
                "openfda.fei_number",
                "openfda.k_number",
                "openfda.registration_number",
                "product_code",
                "regulation_number",
                "review_code",
                "review_panel",
                "submission_type_id",
                "summary_malfunction_reporting",
                "third_party_flag",
                "unclassified_reason"
        );
    }
}
