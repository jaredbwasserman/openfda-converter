package com.jaredbwasserman.openfda.model.generated;

import lombok.NonNull;

import java.util.List;

public class DeviceEvent {
    @NonNull
    public static List<String> getFields() {
        return List.of(
                "adverse_event_flag",
                "date_facility_aware",
                "date_manufacturer_received",
                "date_of_event",
                "date_received",
                "date_report",
                "date_report_to_fda",
                "date_report_to_manufacturer",
                "device",
                "device_date_of_manufacturer",
                "distributor_address_1",
                "distributor_address_2",
                "distributor_city",
                "distributor_name",
                "distributor_state",
                "distributor_zip_code",
                "distributor_zip_code_ext",
                "event_key",
                "event_location",
                "event_type",
                "expiration_date_of_device",
                "health_professional",
                "initial_report_to_fda",
                "manufacturer_address_1",
                "manufacturer_address_2",
                "manufacturer_city",
                "manufacturer_contact_address_1",
                "manufacturer_contact_address_2",
                "manufacturer_contact_area_code",
                "manufacturer_contact_city",
                "manufacturer_contact_country",
                "manufacturer_contact_exchange",
                "manufacturer_contact_extension",
                "manufacturer_contact_f_name",
                "manufacturer_contact_l_name",
                "manufacturer_contact_pcity",
                "manufacturer_contact_pcountry",
                "manufacturer_contact_phone_number",
                "manufacturer_contact_plocal",
                "manufacturer_contact_postal_code",
                "manufacturer_contact_state",
                "manufacturer_contact_t_name",
                "manufacturer_contact_zip_code",
                "manufacturer_contact_zip_ext",
                "manufacturer_country",
                "manufacturer_g1_address_1",
                "manufacturer_g1_address_2",
                "manufacturer_g1_city",
                "manufacturer_g1_country",
                "manufacturer_g1_name",
                "manufacturer_g1_postal_code",
                "manufacturer_g1_state",
                "manufacturer_g1_zip_code",
                "manufacturer_g1_zip_code_ext",
                "manufacturer_link_flag",
                "manufacturer_name",
                "manufacturer_postal_code",
                "manufacturer_state",
                "manufacturer_zip_code",
                "manufacturer_zip_code_ext",
                "mdr_report_key",
                "mdr_text",
                "number_devices_in_event",
                "number_patients_in_event",
                "patient",
                "previous_use_code",
                "product_problem_flag",
                "product_problems",
                "remedial_action",
                "removal_correction_number",
                "report_date",
                "report_number",
                "report_source_code",
                "report_to_fda",
                "report_to_manufacturer",
                "reporter_occupation_code",
                "reprocessed_and_reused_flag",
                "single_use_flag",
                "source_type",
                "type_of_report"
        );
    }
}
