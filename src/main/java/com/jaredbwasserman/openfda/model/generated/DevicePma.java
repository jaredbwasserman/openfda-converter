package com.jaredbwasserman.openfda.model.generated;

import lombok.NonNull;

import java.util.List;

public class DevicePma {
    @NonNull
    public static List<String> getFields() {
        return List.of(
                "advisory_committee",
                "advisory_committee_description",
                "ao_statement",
                "applicant",
                "city",
                "date_received",
                "decision_code",
                "decision_date",
                "docket_number",
                "expedited_review_flag",
                "fed_reg_notice_date",
                "generic_name",
                "openfda.device_class",
                "openfda.device_name",
                "openfda.fei_number",
                "openfda.medical_specialty_description",
                "openfda.registration_number",
                "openfda.regulation_number",
                "pma_number",
                "product_code",
                "state",
                "street_1",
                "street_2",
                "supplement_number",
                "supplement_reason",
                "supplement_type",
                "trade_name",
                "zip",
                "zip_ext"
        );
    }
}
