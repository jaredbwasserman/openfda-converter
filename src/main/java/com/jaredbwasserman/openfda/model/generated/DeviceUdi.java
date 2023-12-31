package com.jaredbwasserman.openfda.model.generated;

import lombok.NonNull;

import java.util.List;

public class DeviceUdi {
    @NonNull
    public static List<String> getFields() {
        return List.of(
                "brand_name",
                "catalog_number",
                "commercial_distribution_end_date",
                "commercial_distribution_status",
                "company_name",
                "customer_contacts",
                "device_count_in_base_package",
                "device_description",
                "device_sizes",
                "gmdn_terms",
                "has_donation_id_number",
                "has_expiration_date",
                "has_lot_or_batch_number",
                "has_manufacturing_date",
                "has_serial_number",
                "identifiers",
                "is_combination_product",
                "is_direct_marking_exempt",
                "is_hct_p",
                "is_kit",
                "is_labeled_as_no_nrl",
                "is_labeled_as_nrl",
                "is_otc",
                "is_pm_exempt",
                "is_rx",
                "is_single_use",
                "labeler_duns_number",
                "mri_safety",
                "premarket_submissions",
                "product_codes",
                "public_version_date",
                "public_version_number",
                "public_version_status",
                "publish_date",
                "record_key",
                "record_status",
                "sterilization.is_sterile",
                "sterilization.is_sterilization_prior_use",
                "sterilization.sterilization_methods",
                "storage",
                "version_or_model_number"
        );
    }
}
