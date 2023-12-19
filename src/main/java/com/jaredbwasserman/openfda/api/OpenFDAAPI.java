package com.jaredbwasserman.openfda.api;

import lombok.NonNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// See https://open.fda.gov/apis/
public class OpenFDAAPI {
    // TODO: Fix me
    // Field names

    // Endpoint display names
    private static final String ENDPOINT_ADVERSE_EVENTS_DISPLAY_NAME = "Adverse Events";
    private static final String ENDPOINT_PRODUCT_LABELING_DISPLAY_NAME = "Product Labeling";
    private static final String ENDPOINT_NDC_DIRECTORY_DISPLAY_NAME = "NDC Directory";
    private static final String ENDPOINT_RECALL_ENFORCEMENT_REPORTS_DISPLAY_NAME = "Recall Enforcement Reports";
    private static final String ENDPOINT_DRUGS_AT_FDA_DISPLAY_NAME = "Drugs@FDA";
    private static final String ENDPOINT_510_K_DISPLAY_NAME = "510(k)";
    private static final String ENDPOINT_CLASSIFICATION_DISPLAY_NAME = "Classification";
    private static final String ENDPOINT_PRE_MARKET_APPROVAL_DISPLAY_NAME = "Pre-market Approval";
    private static final String ENDPOINT_RECALLS_DISPLAY_NAME = "Recalls";
    private static final String ENDPOINT_REGISTRATIONS_AND_LISTINGS_DISPLAY_NAME = "Registrations and Listings";
    private static final String ENDPOINT_COVID_19_SEROLOGICAL_TESTING_EVALUATIONS_DISPLAY_NAME = "COVID-19 Serological Testing Evaluations";
    private static final String ENDPOINT_UNIQUE_DEVICE_IDENTIFIER_DISPLAY_NAME = "Unique Device Identifier";
    private static final String ENDPOINT_NSDE_DISPLAY_NAME = "NSDE";
    private static final String ENDPOINT_SUBSTANCE_DATA_REPORTS_DISPLAY_NAME = "Substance Data Reports";
    private static final String ENDPOINT_UNII_DISPLAY_NAME = "UNII";
    private static final String ENDPOINT_PROBLEM_REPORTS_DISPLAY_NAME = "Problem Reports";

    // Endpoint names
    private static final FriendlyName ENDPOINT_ADVERSE_EVENTS_NAME = new FriendlyName(
            ENDPOINT_ADVERSE_EVENTS_DISPLAY_NAME,
            "event"
    );
    private static final FriendlyName ENDPOINT_PRODUCT_LABELING_NAME = new FriendlyName(
            ENDPOINT_PRODUCT_LABELING_DISPLAY_NAME,
            "label"
    );
    private static final FriendlyName ENDPOINT_NDC_DIRECTORY_NAME = new FriendlyName(
            ENDPOINT_NDC_DIRECTORY_DISPLAY_NAME,
            "ndc"
    );
    private static final FriendlyName ENDPOINT_RECALL_ENFORCEMENT_REPORTS_NAME = new FriendlyName(
            ENDPOINT_RECALL_ENFORCEMENT_REPORTS_DISPLAY_NAME,
            "enforcement"
    );
    private static final FriendlyName ENDPOINT_DRUGS_AT_FDA_NAME = new FriendlyName(
            ENDPOINT_DRUGS_AT_FDA_DISPLAY_NAME,
            "drugsfda"
    );
    private static final FriendlyName ENDPOINT_510_K_NAME = new FriendlyName(
            ENDPOINT_510_K_DISPLAY_NAME,
            "510k"
    );
    private static final FriendlyName ENDPOINT_CLASSIFICATION_NAME = new FriendlyName(
            ENDPOINT_CLASSIFICATION_DISPLAY_NAME,
            "classification"
    );
    private static final FriendlyName ENDPOINT_PRE_MARKET_APPROVAL_NAME = new FriendlyName(
            ENDPOINT_PRE_MARKET_APPROVAL_DISPLAY_NAME,
            "pma"
    );
    private static final FriendlyName ENDPOINT_RECALLS_NAME = new FriendlyName(
            ENDPOINT_RECALLS_DISPLAY_NAME,
            "recall"
    );
    private static final FriendlyName ENDPOINT_REGISTRATIONS_AND_LISTINGS_NAME = new FriendlyName(
            ENDPOINT_REGISTRATIONS_AND_LISTINGS_DISPLAY_NAME,
            "registrationlisting"
    );
    private static final FriendlyName ENDPOINT_COVID_19_SEROLOGICAL_TESTING_EVALUATIONS_NAME = new FriendlyName(
            ENDPOINT_COVID_19_SEROLOGICAL_TESTING_EVALUATIONS_DISPLAY_NAME,
            "covid19serology"
    );
    private static final FriendlyName ENDPOINT_UNIQUE_DEVICE_IDENTIFIER_NAME = new FriendlyName(
            ENDPOINT_UNIQUE_DEVICE_IDENTIFIER_DISPLAY_NAME,
            "udi"
    );
    private static final FriendlyName ENDPOINT_NSDE_NAME = new FriendlyName(
            ENDPOINT_NSDE_DISPLAY_NAME,
            "nsde"
    );
    private static final FriendlyName ENDPOINT_SUBSTANCE_DATA_REPORTS_NAME = new FriendlyName(
            ENDPOINT_SUBSTANCE_DATA_REPORTS_DISPLAY_NAME,
            "substance"
    );
    private static final FriendlyName ENDPOINT_UNII_NAME = new FriendlyName(
            ENDPOINT_UNII_DISPLAY_NAME,
            "unii"
    );
    private static final FriendlyName ENDPOINT_PROBLEM_REPORTS_NAME = new FriendlyName(
            ENDPOINT_PROBLEM_REPORTS_DISPLAY_NAME,
            "problem"
    );

    // Endpoint category display names
    private static final String ENDPOINT_CATEGORY_ANIMAL_AND_VETERINARY_DISPLAY_NAME = "Animal & Veterinary";
    private static final String ENDPOINT_CATEGORY_DRUG_DISPLAY_NAME = "Drug";
    private static final String ENDPOINT_CATEGORY_DEVICE_DISPLAY_NAME = "Device";
    private static final String ENDPOINT_CATEGORY_FOOD_DISPLAY_NAME = "Food";
    private static final String ENDPOINT_CATEGORY_OTHER_DISPLAY_NAME = "Other";
    private static final String ENDPOINT_CATEGORY_TOBACCO_DISPLAY_NAME = "Tobacco";

    // Endpoint category names
    private static final FriendlyName ENDPOINT_CATEGORY_ANIMAL_AND_VETERINARY_NAME = new FriendlyName(
            ENDPOINT_CATEGORY_ANIMAL_AND_VETERINARY_DISPLAY_NAME,
            "animalandveterinary"
    );
    private static final FriendlyName ENDPOINT_CATEGORY_DRUG_NAME = new FriendlyName(
            ENDPOINT_CATEGORY_DRUG_DISPLAY_NAME,
            "drug"
    );
    private static final FriendlyName ENDPOINT_CATEGORY_DEVICE_NAME = new FriendlyName(
            ENDPOINT_CATEGORY_DEVICE_DISPLAY_NAME,
            "device"
    );
    private static final FriendlyName ENDPOINT_CATEGORY_FOOD_NAME = new FriendlyName(
            ENDPOINT_CATEGORY_FOOD_DISPLAY_NAME,
            "food"
    );
    private static final FriendlyName ENDPOINT_CATEGORY_OTHER_NAME = new FriendlyName(
            ENDPOINT_CATEGORY_OTHER_DISPLAY_NAME,
            "other"
    );
    private static final FriendlyName ENDPOINT_CATEGORY_TOBACCO_NAME = new FriendlyName(
            ENDPOINT_CATEGORY_TOBACCO_DISPLAY_NAME,
            "tobacco"
    );

    // Endpoint category endpoints
    private static final Map<FriendlyName, List<FriendlyName>> ENDPOINT_CATEGORY_ENDPOINTS = Map.of(
            ENDPOINT_CATEGORY_ANIMAL_AND_VETERINARY_NAME,
            List.of(
                    ENDPOINT_ADVERSE_EVENTS_NAME
            ),
            ENDPOINT_CATEGORY_DRUG_NAME,
            List.of(
                    ENDPOINT_ADVERSE_EVENTS_NAME,
                    ENDPOINT_PRODUCT_LABELING_NAME,
                    ENDPOINT_NDC_DIRECTORY_NAME,
                    ENDPOINT_RECALL_ENFORCEMENT_REPORTS_NAME,
                    ENDPOINT_DRUGS_AT_FDA_NAME
            ),
            ENDPOINT_CATEGORY_DEVICE_NAME,
            List.of(
                    ENDPOINT_510_K_NAME,
                    ENDPOINT_CLASSIFICATION_NAME,
                    ENDPOINT_RECALL_ENFORCEMENT_REPORTS_NAME,
                    ENDPOINT_ADVERSE_EVENTS_NAME,
                    ENDPOINT_PRE_MARKET_APPROVAL_NAME,
                    ENDPOINT_RECALLS_NAME,
                    ENDPOINT_REGISTRATIONS_AND_LISTINGS_NAME,
                    ENDPOINT_COVID_19_SEROLOGICAL_TESTING_EVALUATIONS_NAME,
                    ENDPOINT_UNIQUE_DEVICE_IDENTIFIER_NAME
            ),
            ENDPOINT_CATEGORY_FOOD_NAME,
            List.of(
                    ENDPOINT_RECALL_ENFORCEMENT_REPORTS_NAME,
                    ENDPOINT_ADVERSE_EVENTS_NAME
            ),
            ENDPOINT_CATEGORY_OTHER_NAME,
            List.of(
                    ENDPOINT_NSDE_NAME,
                    ENDPOINT_SUBSTANCE_DATA_REPORTS_NAME,
                    ENDPOINT_UNII_NAME
            ),
            ENDPOINT_CATEGORY_TOBACCO_NAME,
            List.of(
                    ENDPOINT_PROBLEM_REPORTS_NAME
            )
    );

    @NonNull
    public static Map<String, EndpointCategory> getEndpointCategories() {
        final Map<String, EndpointCategory> endpointCategories = new HashMap<>();
        for (final FriendlyName endpointCategoryFriendlyName : ENDPOINT_CATEGORY_ENDPOINTS.keySet()) {
            endpointCategories.put(
                    endpointCategoryFriendlyName.displayName(),
                    new EndpointCategory(
                            endpointCategoryFriendlyName
                    )
            );
        }
        return endpointCategories;
    }

    @NonNull
    public static Map<String, Endpoint> getEndpoints(EndpointCategory endpointCategory) {
        final Map<String, Endpoint> endpoints = new HashMap<>();
        final List<FriendlyName> endpointFriendlyNames = ENDPOINT_CATEGORY_ENDPOINTS.get(endpointCategory.friendlyName());
        for (final FriendlyName endpointFriendlyName : endpointFriendlyNames) {
            endpoints.put(
                    endpointFriendlyName.displayName(),
                    new Endpoint(
                            endpointFriendlyName,
                            endpointCategory
                    ));
        }
        return endpoints;
    }
}
