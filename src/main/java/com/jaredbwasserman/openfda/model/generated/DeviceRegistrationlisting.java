package com.jaredbwasserman.openfda.model.generated;

import lombok.NonNull;

import java.util.List;

public class DeviceRegistrationlisting {
    @NonNull
    public static List<String> getFields() {
        return List.of(
                "establishment_type",
                "k_number",
                "pma_number",
                "products",
                "proprietary_name",
                "registration.address_line_1",
                "registration.address_line_2",
                "registration.city",
                "registration.fei_number",
                "registration.initial_importer_flag",
                "registration.iso_country_code",
                "registration.name",
                "registration.owner_operator.contact_address.address_1",
                "registration.owner_operator.contact_address.address_2",
                "registration.owner_operator.contact_address.city",
                "registration.owner_operator.contact_address.iso_country_code",
                "registration.owner_operator.contact_address.postal_code",
                "registration.owner_operator.contact_address.state_code",
                "registration.owner_operator.contact_address.state_province",
                "registration.owner_operator.firm_name",
                "registration.owner_operator.official_correspondent.first_name",
                "registration.owner_operator.official_correspondent.last_name",
                "registration.owner_operator.official_correspondent.middle_initial",
                "registration.owner_operator.official_correspondent.phone_number",
                "registration.owner_operator.official_correspondent.subaccount_company_name",
                "registration.owner_operator.owner_operator_number",
                "registration.postal_code",
                "registration.reg_expiry_date_year",
                "registration.registration_number",
                "registration.state_code",
                "registration.status_code",
                "registration.us_agent.address_line_1",
                "registration.us_agent.address_line_2",
                "registration.us_agent.bus_phone_area_code",
                "registration.us_agent.bus_phone_extn",
                "registration.us_agent.bus_phone_num",
                "registration.us_agent.business_name",
                "registration.us_agent.city",
                "registration.us_agent.email_address",
                "registration.us_agent.fax_area_code",
                "registration.us_agent.fax_num",
                "registration.us_agent.iso_country_code",
                "registration.us_agent.name",
                "registration.us_agent.postal_code",
                "registration.us_agent.state_code",
                "registration.us_agent.zip_code",
                "registration.zip_code"
        );
    }
}
