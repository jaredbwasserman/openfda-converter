package com.jaredbwasserman.openfda.model.generated;

import lombok.NonNull;

import java.util.List;

public class DeviceCovid19serology {
    @NonNull
    public static List<String> getFields() {
        return List.of(
                "antibody_agree",
                "antibody_truth",
                "control",
                "date_performed",
                "days_from_symptom",
                "device",
                "evaluation_id",
                "group",
                "iga_agree",
                "iga_result",
                "igg_agree",
                "igg_result",
                "igg_titer",
                "igg_truth",
                "igm_agree",
                "igm_iga_agree",
                "igm_iga_result",
                "igm_igg_agree",
                "igm_igg_result",
                "igm_result",
                "igm_titer",
                "igm_truth",
                "lot_number",
                "manufacturer",
                "pan_agree",
                "pan_result",
                "pan_titer",
                "panel",
                "sample_id",
                "sample_no"
        );
    }
}
