package com.jaredbwasserman.openfda.model.generated;

import lombok.NonNull;

import java.util.List;

public class DeviceRecall {
    @NonNull
    public static List<String> getFields() {
        return List.of(
                "action",
                "additional_info_contact",
                "address_1",
                "address_2",
                "cfres_id",
                "city",
                "code_info",
                "country",
                "distribution_pattern",
                "event_date_created",
                "event_date_initiated",
                "event_date_posted",
                "event_date_terminated",
                "firm_fei_number",
                "k_numbers",
                "openfda.device_class",
                "openfda.device_name",
                "openfda.fei_number",
                "openfda.k_number",
                "openfda.medical_specialty_description",
                "openfda.registration_number",
                "openfda.regulation_number",
                "other_submission_description",
                "pma_numbers",
                "postal_code",
                "product_code",
                "product_description",
                "product_quantity",
                "product_res_number",
                "reason_for_recall",
                "recall_status",
                "recalling_firm",
                "res_event_number",
                "root_cause_description",
                "state"
        );
    }
}
