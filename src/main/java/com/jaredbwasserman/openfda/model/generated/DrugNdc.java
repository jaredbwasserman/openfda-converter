package com.jaredbwasserman.openfda.model.generated;

import lombok.NonNull;

import java.util.List;

public class DrugNdc {
    @NonNull
    public static List<String> getFields() {
        return List.of(
                "active_ingredients.name",
                "active_ingredients.strength",
                "application_number",
                "brand_name",
                "brand_name_base",
                "brand_name_suffix",
                "dea_schedule",
                "dosage_form",
                "finished",
                "generic_name",
                "listing_expiration_date",
                "marketing_category",
                "marketing_end_date",
                "marketing_start_date",
                "openfda.is_original_packager",
                "openfda.manufacturer_name",
                "openfda.nui",
                "openfda.pharm_class_cs",
                "openfda.pharm_class_epc",
                "openfda.pharm_class_moa",
                "openfda.pharm_class_pe",
                "openfda.rxcui",
                "openfda.spl_set_id",
                "openfda.unii",
                "openfda.upc",
                "packaging.description",
                "packaging.marketing_end_date",
                "packaging.marketing_start_date",
                "packaging.package_ndc",
                "packaging.sample",
                "pharm_class",
                "product_id",
                "product_ndc",
                "product_type",
                "route",
                "spl_id"
        );
    }
}
