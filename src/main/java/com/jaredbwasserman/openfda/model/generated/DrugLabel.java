package com.jaredbwasserman.openfda.model.generated;

import lombok.NonNull;

import java.util.List;

public class DrugLabel {
    @NonNull
    public static List<String> getFields() {
        return List.of(
                "abuse",
                "abuse_table",
                "accessories",
                "accessories_table",
                "active_ingredient",
                "active_ingredient_table",
                "adverse_reactions",
                "adverse_reactions_table",
                "alarms",
                "alarms_table",
                "animal_pharmacology_and_or_toxicology",
                "animal_pharmacology_and_or_toxicology_table",
                "ask_doctor",
                "ask_doctor_or_pharmacist",
                "ask_doctor_or_pharmacist_table",
                "ask_doctor_table",
                "assembly_or_installation_instructions",
                "assembly_or_installation_instructions_table",
                "boxed_warning",
                "boxed_warning_table",
                "calibration_instructions",
                "calibration_instructions_table",
                "carcinogenesis_and_mutagenesis_and_impairment_of_fertility",
                "carcinogenesis_and_mutagenesis_and_impairment_of_fertility_table",
                "cleaning",
                "cleaning_table",
                "clinical_pharmacology",
                "clinical_pharmacology_table",
                "clinical_studies",
                "clinical_studies_table",
                "compatible_accessories",
                "compatible_accessories_table",
                "components",
                "components_table",
                "contraindications",
                "contraindications_table",
                "controlled_substance",
                "controlled_substance_table",
                "dependence",
                "dependence_table",
                "description",
                "description_table",
                "diagram_of_device",
                "diagram_of_device_table",
                "disposal_and_waste_handling",
                "disposal_and_waste_handling_table",
                "do_not_use",
                "do_not_use_table",
                "dosage_and_administration",
                "dosage_and_administration_table",
                "dosage_forms_and_strengths",
                "dosage_forms_and_strengths_table",
                "drug_abuse_and_dependence",
                "drug_abuse_and_dependence_table",
                "drug_and_or_laboratory_test_interactions",
                "drug_and_or_laboratory_test_interactions_table",
                "drug_interactions",
                "drug_interactions_table",
                "effective_time",
                "environmental_warning",
                "environmental_warning_table",
                "food_safety_warning",
                "food_safety_warning_table",
                "general_precautions",
                "general_precautions_table",
                "geriatric_use",
                "geriatric_use_table",
                "guaranteed_analysis_of_feed",
                "guaranteed_analysis_of_feed_table",
                "health_care_provider_letter",
                "health_care_provider_letter_table",
                "health_claim",
                "health_claim_table",
                "how_supplied",
                "how_supplied_table",
                "id",
                "inactive_ingredient",
                "inactive_ingredient_table",
                "indications_and_usage",
                "indications_and_usage_table",
                "information_for_owners_or_caregivers",
                "information_for_owners_or_caregivers_table",
                "information_for_patients",
                "information_for_patients_table",
                "instructions_for_use",
                "instructions_for_use_table",
                "intended_use_of_the_device",
                "intended_use_of_the_device_table",
                "keep_out_of_reach_of_children",
                "keep_out_of_reach_of_children_table",
                "labor_and_delivery",
                "labor_and_delivery_table",
                "laboratory_tests",
                "laboratory_tests_table",
                "mechanism_of_action",
                "mechanism_of_action_table",
                "microbiology",
                "microbiology_table",
                "nonclinical_toxicology",
                "nonclinical_toxicology_table",
                "nonteratogenic_effects",
                "nonteratogenic_effects_table",
                "nursing_mothers",
                "nursing_mothers_table",
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
                "other_safety_information",
                "other_safety_information_table",
                "overdosage",
                "overdosage_table",
                "package_label_principal_display_panel",
                "package_label_principal_display_panel_table",
                "patient_medication_information",
                "patient_medication_information_table",
                "pediatric_use",
                "pediatric_use_table",
                "pharmacodynamics",
                "pharmacodynamics_table",
                "pharmacogenomics",
                "pharmacogenomics_table",
                "pharmacokinetics",
                "pharmacokinetics_table",
                "precautions",
                "precautions_table",
                "pregnancy",
                "pregnancy_or_breast_feeding",
                "pregnancy_or_breast_feeding_table",
                "pregnancy_table",
                "purpose",
                "purpose_table",
                "questions",
                "questions_table",
                "recent_major_changes",
                "recent_major_changes_table",
                "references",
                "references_table",
                "residue_warning",
                "residue_warning_table",
                "risks",
                "risks_table",
                "route",
                "route_table",
                "safe_handling_warning",
                "safe_handling_warning_table",
                "set_id",
                "spl_indexing_data_elements",
                "spl_indexing_data_elements_table",
                "spl_medguide",
                "spl_medguide_table",
                "spl_patient_package_insert",
                "spl_patient_package_insert_table",
                "spl_product_data_elements",
                "spl_product_data_elements_table",
                "spl_unclassified_section",
                "spl_unclassified_section_table",
                "statement_of_identity",
                "statement_of_identity_table",
                "stop_use",
                "stop_use_table",
                "storage_and_handling",
                "storage_and_handling_table",
                "summary_of_safety_and_effectiveness",
                "summary_of_safety_and_effectiveness_table",
                "teratogenic_effects",
                "teratogenic_effects_table",
                "troubleshooting",
                "troubleshooting_table",
                "use_in_specific_populations",
                "use_in_specific_populations_table",
                "user_safety_warnings",
                "user_safety_warnings_table",
                "version",
                "warnings",
                "warnings_and_cautions",
                "warnings_and_cautions_table",
                "warnings_table",
                "when_using",
                "when_using_table"
        );
    }
}