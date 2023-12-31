package com.jaredbwasserman.openfda.model.generated;

import lombok.NonNull;

import java.util.List;

public class DrugEnforcement {
    @NonNull
    public static List<String> getFields() {
        return List.of(
                "address_1",
                "address_2",
                "center_classification_date",
                "city",
                "classification",
                "code_info",
                "country",
                "distribution_pattern",
                "event_id",
                "initial_firm_notification",
                "more_code_info",
                "openfda.application_number",
                "openfda.brand_name",
                "openfda.generic_name",
                "openfda.is_original_packager",
                "openfda.manufacturer_name",
                "openfda.nui",
                "openfda.original_packager_product_ndc",
                "openfda.package_ndc",
                "openfda.pharm_class_cs",
                "openfda.pharm_class_epc",
                "openfda.pharm_class_moa",
                "openfda.pharm_class_pe",
                "openfda.product_ndc",
                "openfda.product_type",
                "openfda.route",
                "openfda.rxcui",
                "openfda.spl_id",
                "openfda.spl_set_id",
                "openfda.substance_name",
                "openfda.unii",
                "openfda.upc",
                "product_code",
                "product_description",
                "product_quantity",
                "product_type",
                "reason_for_recall",
                "recall_initiation_date",
                "recall_number",
                "recalling_firm",
                "report_date",
                "state",
                "status",
                "termination_date",
                "voluntary_mandated"
        );
    }
}
