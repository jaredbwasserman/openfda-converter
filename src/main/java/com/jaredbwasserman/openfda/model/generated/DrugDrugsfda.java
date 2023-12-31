package com.jaredbwasserman.openfda.model.generated;

import lombok.NonNull;

import java.util.List;

public class DrugDrugsfda {
    @NonNull
    public static List<String> getFields() {
        return List.of(
                "application_number",
                "openfda.application_number",
                "openfda.brand_name",
                "openfda.generic_name",
                "openfda.manufacturer_name",
                "openfda.nui",
                "openfda.package_ndc",
                "openfda.pharm_class_cs",
                "openfda.pharm_class_epc",
                "openfda.pharm_class_moa",
                "openfda.pharm_class_pe",
                "openfda.product_ndc",
                "openfda.route",
                "openfda.rxcui",
                "openfda.spl_id",
                "openfda.spl_set_id",
                "openfda.substance_name",
                "openfda.unii",
                "products.active_ingredients.name",
                "products.active_ingredients.strength",
                "products.brand_name",
                "products.dosage_form",
                "products.marketing_status",
                "products.product_number",
                "products.reference_drug",
                "products.reference_standard",
                "products.route",
                "products.te_code",
                "sponsor_name",
                "submissions.application_docs",
                "submissions.review_priority",
                "submissions.submission_class_code",
                "submissions.submission_class_code_description",
                "submissions.submission_number",
                "submissions.submission_property_type",
                "submissions.submission_public_notes",
                "submissions.submission_status",
                "submissions.submission_status_date",
                "submissions.submission_type"
        );
    }
}
