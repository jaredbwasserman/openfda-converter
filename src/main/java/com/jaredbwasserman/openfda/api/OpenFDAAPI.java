package com.jaredbwasserman.openfda.api;

import lombok.NonNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// See https://open.fda.gov/apis/
public class OpenFDAAPI {
    // Endpoint display names
    public static final String ENDPOINT_ADVERSE_EVENTS = "Adverse Events";
    public static final String ENDPOINT_PRODUCT_LABELING = "Product Labeling";
    public static final String ENDPOINT_NDC_DIRECTORY = "NDC Directory";
    public static final String ENDPOINT_RECALL_ENFORCEMENT_REPORTS = "Recall Enforcement Reports";
    public static final String ENDPOINT_DRUGS_AT_FDA = "Drugs@FDA";
    public static final String ENDPOINT_510_K = "510(k)";
    public static final String ENDPOINT_CLASSIFICATION = "Classification";
    public static final String ENDPOINT_PRE_MARKET_APPROVAL = "Pre-market Approval";
    public static final String ENDPOINT_RECALLS = "Recalls";
    public static final String ENDPOINT_REGISTRATIONS_AND_LISTINGS = "Registrations and Listings";
    public static final String ENDPOINT_COVID_19_SEROLOGICAL_TESTING_EVALUATIONS = "COVID-19 Serological Testing Evaluations";
    public static final String ENDPOINT_UNIQUE_DEVICE_IDENTIFIER = "Unique Device Identifier";
    public static final String ENDPOINT_NSDE = "NSDE";
    public static final String ENDPOINT_SUBSTANCE_DATA_REPORTS = "Substance Data Reports";
    public static final String ENDPOINT_UNII = "UNII";
    public static final String ENDPOINT_PROBLEM_REPORTS = "Problem Reports";

    // Endpoint names
    private static final FriendlyName ENDPOINT_ADVERSE_EVENTS_NAME = new FriendlyName(
            ENDPOINT_ADVERSE_EVENTS,
            "event"
    );
    private static final FriendlyName ENDPOINT_PRODUCT_LABELING_NAME = new FriendlyName(
            ENDPOINT_PRODUCT_LABELING,
            "label"
    );
    private static final FriendlyName ENDPOINT_NDC_DIRECTORY_NAME = new FriendlyName(
            ENDPOINT_NDC_DIRECTORY,
            "ndc"
    );
    private static final FriendlyName ENDPOINT_RECALL_ENFORCEMENT_REPORTS_NAME = new FriendlyName(
            ENDPOINT_RECALL_ENFORCEMENT_REPORTS,
            "enforcement"
    );
    private static final FriendlyName ENDPOINT_DRUGS_AT_FDA_NAME = new FriendlyName(
            ENDPOINT_DRUGS_AT_FDA,
            "drugsfda"
    );
    private static final FriendlyName ENDPOINT_510_K_NAME = new FriendlyName(
            ENDPOINT_510_K,
            "510k"
    );
    private static final FriendlyName ENDPOINT_CLASSIFICATION_NAME = new FriendlyName(
            ENDPOINT_CLASSIFICATION,
            "classification"
    );
    private static final FriendlyName ENDPOINT_PRE_MARKET_APPROVAL_NAME = new FriendlyName(
            ENDPOINT_PRE_MARKET_APPROVAL,
            "pma"
    );
    private static final FriendlyName ENDPOINT_RECALLS_NAME = new FriendlyName(
            ENDPOINT_RECALLS,
            "recall"
    );
    private static final FriendlyName ENDPOINT_REGISTRATIONS_AND_LISTINGS_NAME = new FriendlyName(
            ENDPOINT_REGISTRATIONS_AND_LISTINGS,
            "registrationlisting"
    );
    private static final FriendlyName ENDPOINT_COVID_19_SEROLOGICAL_TESTING_EVALUATIONS_NAME = new FriendlyName(
            ENDPOINT_COVID_19_SEROLOGICAL_TESTING_EVALUATIONS,
            "covid19serology"
    );
    private static final FriendlyName ENDPOINT_UNIQUE_DEVICE_IDENTIFIER_NAME = new FriendlyName(
            ENDPOINT_UNIQUE_DEVICE_IDENTIFIER,
            "udi"
    );
    private static final FriendlyName ENDPOINT_NSDE_NAME = new FriendlyName(
            ENDPOINT_NSDE,
            "nsde"
    );
    private static final FriendlyName ENDPOINT_SUBSTANCE_DATA_REPORTS_NAME = new FriendlyName(
            ENDPOINT_SUBSTANCE_DATA_REPORTS,
            "substance"
    );
    private static final FriendlyName ENDPOINT_UNII_NAME = new FriendlyName(
            ENDPOINT_UNII,
            "unii"
    );
    private static final FriendlyName ENDPOINT_PROBLEM_REPORTS_NAME = new FriendlyName(
            ENDPOINT_PROBLEM_REPORTS,
            "problem"
    );

    // Endpoint category display names
    public static final String ENDPOINT_CATEGORY_ANIMAL_AND_VETERINARY = "Animal & Veterinary";
    public static final String ENDPOINT_CATEGORY_DRUG = "Drug";
    public static final String ENDPOINT_CATEGORY_DEVICE = "Device";
    public static final String ENDPOINT_CATEGORY_FOOD = "Food";
    public static final String ENDPOINT_CATEGORY_OTHER = "Other";
    public static final String ENDPOINT_CATEGORY_TOBACCO = "Tobacco";

    // Endpoint category names
    private static final FriendlyName ENDPOINT_CATEGORY_ANIMAL_AND_VETERINARY_NAME = new FriendlyName(
            ENDPOINT_CATEGORY_ANIMAL_AND_VETERINARY,
            "animalandveterinary"
    );
    private static final FriendlyName ENDPOINT_CATEGORY_DRUG_NAME = new FriendlyName(
            ENDPOINT_CATEGORY_DRUG,
            "drug"
    );
    private static final FriendlyName ENDPOINT_CATEGORY_DEVICE_NAME = new FriendlyName(
            ENDPOINT_CATEGORY_DEVICE,
            "device"
    );
    private static final FriendlyName ENDPOINT_CATEGORY_FOOD_NAME = new FriendlyName(
            ENDPOINT_CATEGORY_FOOD,
            "food"
    );
    private static final FriendlyName ENDPOINT_CATEGORY_OTHER_NAME = new FriendlyName(
            ENDPOINT_CATEGORY_OTHER,
            "other"
    );
    private static final FriendlyName ENDPOINT_CATEGORY_TOBACCO_NAME = new FriendlyName(
            ENDPOINT_CATEGORY_TOBACCO,
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

    private static final String FILE_MANIFEST_URL_STRING = "https://api.fda.gov/download.json";

    private static Map<String, EndpointCategory> endpointCategories = null;
    private static Map<FriendlyName, Map<String, Endpoint>> endpoints = null;

    @NonNull
    private static Map<String, EndpointCategory> getEndpointCategories() {
        if (null == endpointCategories) {
            endpointCategories = new HashMap<>();
            for (final FriendlyName endpointCategoryFriendlyName : ENDPOINT_CATEGORY_ENDPOINTS.keySet()) {
                endpointCategories.put(
                        endpointCategoryFriendlyName.displayName(),
                        new EndpointCategory(
                                endpointCategoryFriendlyName
                        )
                );
            }
        }
        return endpointCategories;
    }

    @NonNull
    private static Map<String, Endpoint> getEndpoints(@NonNull EndpointCategory endpointCategory) {
        if (null == endpoints) {
            endpoints = new HashMap<>();
        }

        if (null == endpoints.get(endpointCategory.friendlyName())) {
            endpoints.put(endpointCategory.friendlyName(), new HashMap<>());
            final List<FriendlyName> endpointFriendlyNames = ENDPOINT_CATEGORY_ENDPOINTS.get(endpointCategory.friendlyName());
            for (final FriendlyName endpointFriendlyName : endpointFriendlyNames) {
                endpoints.get(endpointCategory.friendlyName()).put(
                        endpointFriendlyName.displayName(),
                        new Endpoint(
                                endpointFriendlyName,
                                endpointCategory
                        ));
            }
        }
        return endpoints.get(endpointCategory.friendlyName());
    }

    @NonNull
    public static Endpoint getEndpoint(@NonNull String endpointCategoryDisplayName, @NonNull String endpointDisplayName) {
        return getEndpoints(getEndpointCategories().get(endpointCategoryDisplayName)).get(endpointDisplayName);
    }

    @NonNull
    public static String getFileManifestUrlString() {
        return FILE_MANIFEST_URL_STRING;
    }
}
