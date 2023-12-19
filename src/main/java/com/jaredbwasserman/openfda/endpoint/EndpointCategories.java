package com.jaredbwasserman.openfda.endpoint;

import java.util.Map;

// See https://open.fda.gov/apis/
public class EndpointCategories {
    // Endpoint names
    private static final String ENDPOINT_ADVERSE_EVENTS_NAME = "Adverse Events";
    private static final String ENDPOINT_PRODUCT_LABELING_NAME = "Product Labeling";
    private static final String ENDPOINT_NDC_DIRECTORY_NAME = "NDC Directory";
    private static final String ENDPOINT_RECALL_ENFORCEMENT_REPORTS_NAME = "Recall Enforcement Reports";
    private static final String ENDPOINT_DRUGS_AT_FDA_NAME = "Drugs@FDA";
    private static final String ENDPOINT_510_K_NAME = "510(k)";
    private static final String ENDPOINT_CLASSIFICATION_NAME = "Classification";
    private static final String ENDPOINT_PRE_MARKET_APPROVAL_NAME = "Pre-market Approval";
    private static final String ENDPOINT_RECALLS_NAME = "Recalls";
    private static final String ENDPOINT_REGISTRATIONS_AND_LISTINGS_NAME = "Registrations and Listings";
    private static final String ENDPOINT_COVID_19_SEROLOGICAL_TESTING_EVALUATIONS_NAME = "COVID-19 Serological Testing Evaluations";
    private static final String ENDPOINT_UNIQUE_DEVICE_IDENTIFIER_NAME = "Unique Device Identifier";
    private static final String ENDPOINT_NSDE_NAME = "NSDE";
    private static final String ENDPOINT_SUBSTANCE_DATA_REPORTS_NAME = "Substance Data Reports";
    private static final String ENDPOINT_UNII_NAME = "UNII";
    private static final String ENDPOINT_PROBLEM_REPORTS_NAME = "Problem Reports";

    // Endpoints
    private static final Endpoint ENDPOINT_ADVERSE_EVENTS = new Endpoint(
            ENDPOINT_ADVERSE_EVENTS_NAME,
            "event"
    );
    private static final Endpoint ENDPOINT_PRODUCT_LABELING = new Endpoint(
            ENDPOINT_PRODUCT_LABELING_NAME,
            "label"
    );
    private static final Endpoint ENDPOINT_NDC_DIRECTORY = new Endpoint(
            ENDPOINT_NDC_DIRECTORY_NAME,
            "ndc"
    );
    private static final Endpoint ENDPOINT_RECALL_ENFORCEMENT_REPORTS = new Endpoint(
            ENDPOINT_RECALL_ENFORCEMENT_REPORTS_NAME,
            "enforcement"
    );
    private static final Endpoint ENDPOINT_DRUGS_AT_FDA = new Endpoint(
            ENDPOINT_DRUGS_AT_FDA_NAME,
            "drugsfda"
    );
    private static final Endpoint ENDPOINT_510_K = new Endpoint(
            ENDPOINT_510_K_NAME,
            "510k"
    );
    private static final Endpoint ENDPOINT_CLASSIFICATION = new Endpoint(
            ENDPOINT_CLASSIFICATION_NAME,
            "classification"
    );
    private static final Endpoint ENDPOINT_PRE_MARKET_APPROVAL = new Endpoint(
            ENDPOINT_PRE_MARKET_APPROVAL_NAME,
            "pma"
    );
    private static final Endpoint ENDPOINT_RECALLS = new Endpoint(
            ENDPOINT_RECALLS_NAME,
            "recall"
    );
    private static final Endpoint ENDPOINT_REGISTRATIONS_AND_LISTINGS = new Endpoint(
            ENDPOINT_REGISTRATIONS_AND_LISTINGS_NAME,
            "registrationlisting"
    );
    private static final Endpoint ENDPOINT_COVID_19_SEROLOGICAL_TESTING_EVALUATIONS = new Endpoint(
            ENDPOINT_COVID_19_SEROLOGICAL_TESTING_EVALUATIONS_NAME,
            "covid19serology"
    );
    private static final Endpoint ENDPOINT_UNIQUE_DEVICE_IDENTIFIER = new Endpoint(
            ENDPOINT_UNIQUE_DEVICE_IDENTIFIER_NAME,
            "udi"
    );
    private static final Endpoint ENDPOINT_NSDE = new Endpoint(
            ENDPOINT_NSDE_NAME,
            "nsde"
    );
    private static final Endpoint ENDPOINT_SUBSTANCE_DATA_REPORTS = new Endpoint(
            ENDPOINT_SUBSTANCE_DATA_REPORTS_NAME,
            "substance"
    );
    private static final Endpoint ENDPOINT_UNII = new Endpoint(
            ENDPOINT_UNII_NAME,
            "unii"
    );
    private static final Endpoint ENDPOINT_PROBLEM_REPORTS = new Endpoint(
            ENDPOINT_PROBLEM_REPORTS_NAME,
            "problem"
    );

    // Endpoint category names
    private static final String ENDPOINT_CATEGORY_ANIMAL_AND_VETERINARY_NAME = "Animal & Veterinary";
    private static final String ENDPOINT_CATEGORY_DRUG_NAME = "Drug";
    private static final String ENDPOINT_CATEGORY_DEVICE_NAME = "Device";
    private static final String ENDPOINT_CATEGORY_FOOD_NAME = "Food";
    private static final String ENDPOINT_CATEGORY_OTHER_NAME = "Other";
    private static final String ENDPOINT_CATEGORY_TOBACCO_NAME = "Tobacco";

    // Endpoint categories
    public static final Map<String, EndpointCategory> ENDPOINT_CATEGORIES = Map.of(
            ENDPOINT_CATEGORY_ANIMAL_AND_VETERINARY_NAME,
            new EndpointCategory(
                    ENDPOINT_CATEGORY_ANIMAL_AND_VETERINARY_NAME,
                    "animalandveterinary",
                    Map.of(
                            ENDPOINT_ADVERSE_EVENTS_NAME,
                            ENDPOINT_ADVERSE_EVENTS
                    )
            ),
            ENDPOINT_CATEGORY_DRUG_NAME,
            new EndpointCategory(
                    ENDPOINT_CATEGORY_DRUG_NAME,
                    "drug",
                    Map.of(
                            ENDPOINT_ADVERSE_EVENTS_NAME,
                            ENDPOINT_ADVERSE_EVENTS,
                            ENDPOINT_PRODUCT_LABELING_NAME,
                            ENDPOINT_PRODUCT_LABELING,
                            ENDPOINT_NDC_DIRECTORY_NAME,
                            ENDPOINT_NDC_DIRECTORY,
                            ENDPOINT_RECALL_ENFORCEMENT_REPORTS_NAME,
                            ENDPOINT_RECALL_ENFORCEMENT_REPORTS,
                            ENDPOINT_DRUGS_AT_FDA_NAME,
                            ENDPOINT_DRUGS_AT_FDA
                    )
            ),
            ENDPOINT_CATEGORY_DEVICE_NAME,
            new EndpointCategory(
                    ENDPOINT_CATEGORY_DEVICE_NAME,
                    "device",
                    Map.of(
                            ENDPOINT_510_K_NAME,
                            ENDPOINT_510_K,
                            ENDPOINT_CLASSIFICATION_NAME,
                            ENDPOINT_CLASSIFICATION,
                            ENDPOINT_RECALL_ENFORCEMENT_REPORTS_NAME,
                            ENDPOINT_RECALL_ENFORCEMENT_REPORTS,
                            ENDPOINT_ADVERSE_EVENTS_NAME,
                            ENDPOINT_ADVERSE_EVENTS,
                            ENDPOINT_PRE_MARKET_APPROVAL_NAME,
                            ENDPOINT_PRE_MARKET_APPROVAL,
                            ENDPOINT_RECALLS_NAME,
                            ENDPOINT_RECALLS,
                            ENDPOINT_REGISTRATIONS_AND_LISTINGS_NAME,
                            ENDPOINT_REGISTRATIONS_AND_LISTINGS,
                            ENDPOINT_COVID_19_SEROLOGICAL_TESTING_EVALUATIONS_NAME,
                            ENDPOINT_COVID_19_SEROLOGICAL_TESTING_EVALUATIONS,
                            ENDPOINT_UNIQUE_DEVICE_IDENTIFIER_NAME,
                            ENDPOINT_UNIQUE_DEVICE_IDENTIFIER
                    )
            ),
            ENDPOINT_CATEGORY_FOOD_NAME,
            new EndpointCategory(
                    ENDPOINT_CATEGORY_FOOD_NAME,
                    "food",
                    Map.of(
                            ENDPOINT_RECALL_ENFORCEMENT_REPORTS_NAME,
                            ENDPOINT_RECALL_ENFORCEMENT_REPORTS,
                            ENDPOINT_ADVERSE_EVENTS_NAME,
                            ENDPOINT_ADVERSE_EVENTS
                    )
            ),
            ENDPOINT_CATEGORY_OTHER_NAME,
            new EndpointCategory(
                    ENDPOINT_CATEGORY_OTHER_NAME,
                    "other",
                    Map.of(
                            ENDPOINT_NSDE_NAME,
                            ENDPOINT_NSDE,
                            ENDPOINT_SUBSTANCE_DATA_REPORTS_NAME,
                            ENDPOINT_SUBSTANCE_DATA_REPORTS,
                            ENDPOINT_UNII_NAME,
                            ENDPOINT_UNII
                    )
            ),
            ENDPOINT_CATEGORY_TOBACCO_NAME,
            new EndpointCategory(
                    ENDPOINT_CATEGORY_TOBACCO_NAME,
                    "tobacco",
                    Map.of(
                            ENDPOINT_PROBLEM_REPORTS_NAME,
                            ENDPOINT_PROBLEM_REPORTS
                    )
            )
    );
}
