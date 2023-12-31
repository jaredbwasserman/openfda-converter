package com.jaredbwasserman.openfda.model.generated;

import lombok.NonNull;

import java.util.List;

public class Device510k {
    @NonNull
    public static List<String> getFields() {
        return List.of(
                "address_1",
                "address_2",
                "advisory_committee",
                "advisory_committee_description",
                "applicant",
                "city",
                "clearance_type",
                "contact",
                "country_code",
                "date_received",
                "decision_code",
                "decision_date",
                "decision_description",
                "device_name",
                "expedited_review_flag",
                "k_number",
                "openfda.device_class",
                "openfda.device_name",
                "openfda.fei_number",
                "openfda.medical_specialty_description",
                "openfda.registration_number",
                "openfda.regulation_number",
                "postal_code",
                "product_code",
                "review_advisory_committee",
                "state",
                "statement_or_summary",
                "third_party_flag",
                "zip_code"
        );
    }
}
