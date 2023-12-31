package com.jaredbwasserman.openfda.api;

import com.jaredbwasserman.openfda.model.generated.AnimalandveterinaryEvent;
import com.jaredbwasserman.openfda.model.generated.Device510k;
import com.jaredbwasserman.openfda.model.generated.DeviceClassification;
import com.jaredbwasserman.openfda.model.generated.DeviceCovid19serology;
import com.jaredbwasserman.openfda.model.generated.DeviceEvent;
import com.jaredbwasserman.openfda.model.generated.DevicePma;
import com.jaredbwasserman.openfda.model.generated.DeviceRecall;
import com.jaredbwasserman.openfda.model.generated.DeviceRegistrationlisting;
import com.jaredbwasserman.openfda.model.generated.DeviceUdi;
import com.jaredbwasserman.openfda.model.generated.DrugDrugsfda;
import com.jaredbwasserman.openfda.model.generated.DrugEnforcement;
import com.jaredbwasserman.openfda.model.generated.DrugEvent;
import com.jaredbwasserman.openfda.model.generated.DrugLabel;
import com.jaredbwasserman.openfda.model.generated.DrugNdc;
import com.jaredbwasserman.openfda.model.generated.FoodEnforcement;
import com.jaredbwasserman.openfda.model.generated.FoodEvent;
import com.jaredbwasserman.openfda.model.generated.OtherNsde;
import com.jaredbwasserman.openfda.model.generated.OtherSubstance;
import com.jaredbwasserman.openfda.model.generated.OtherUnii;
import com.jaredbwasserman.openfda.model.generated.TobaccoProblem;
import lombok.NonNull;

import java.util.List;

// See https://open.fda.gov/apis/
public class OpenFDAAPI {
    // Endpoint names
    private static final FriendlyName ENDPOINT_ADVERSE_EVENTS_NAME = new FriendlyName(
            "Adverse Events",
            "event"
    );
    private static final FriendlyName ENDPOINT_PRODUCT_LABELING_NAME = new FriendlyName(
            "Product Labeling",
            "label"
    );
    private static final FriendlyName ENDPOINT_NDC_DIRECTORY_NAME = new FriendlyName(
            "NDC Directory",
            "ndc"
    );
    private static final FriendlyName ENDPOINT_RECALL_ENFORCEMENT_REPORTS_NAME = new FriendlyName(
            "Recall Enforcement Reports",
            "enforcement"
    );
    private static final FriendlyName ENDPOINT_DRUGS_AT_FDA_NAME = new FriendlyName(
            "Drugs@FDA",
            "drugsfda"
    );
    private static final FriendlyName ENDPOINT_510K_NAME = new FriendlyName(
            "510(k)",
            "510k"
    );
    private static final FriendlyName ENDPOINT_CLASSIFICATION_NAME = new FriendlyName(
            "Classification",
            "classification"
    );
    private static final FriendlyName ENDPOINT_PRE_MARKET_APPROVAL_NAME = new FriendlyName(
            "Pre-market Approval",
            "pma"
    );
    private static final FriendlyName ENDPOINT_RECALLS_NAME = new FriendlyName(
            "Recalls",
            "recall"
    );
    private static final FriendlyName ENDPOINT_REGISTRATIONS_AND_LISTINGS_NAME = new FriendlyName(
            "Registrations and Listings",
            "registrationlisting"
    );
    private static final FriendlyName ENDPOINT_COVID_19_SEROLOGICAL_TESTING_EVALUATIONS_NAME = new FriendlyName(
            "COVID-19 Serological Testing Evaluations",
            "covid19serology"
    );
    private static final FriendlyName ENDPOINT_UNIQUE_DEVICE_IDENTIFIER_NAME = new FriendlyName(
            "Unique Device Identifier",
            "udi"
    );
    private static final FriendlyName ENDPOINT_NSDE_NAME = new FriendlyName(
            "NSDE",
            "nsde"
    );
    private static final FriendlyName ENDPOINT_SUBSTANCE_DATA_REPORTS_NAME = new FriendlyName(
            "Substance Data Reports",
            "substance"
    );
    private static final FriendlyName ENDPOINT_UNII_NAME = new FriendlyName(
            "UNII",
            "unii"
    );
    private static final FriendlyName ENDPOINT_PROBLEM_REPORTS_NAME = new FriendlyName(
            "Problem Reports",
            "problem"
    );

    // Endpoint category names
    private static final FriendlyName ENDPOINT_CATEGORY_ANIMAL_AND_VETERINARY_NAME = new FriendlyName(
            "Animal & Veterinary",
            "animalandveterinary"
    );
    private static final FriendlyName ENDPOINT_CATEGORY_DRUG_NAME = new FriendlyName(
            "Drug",
            "drug"
    );
    private static final FriendlyName ENDPOINT_CATEGORY_DEVICE_NAME = new FriendlyName(
            "Device",
            "device"
    );
    private static final FriendlyName ENDPOINT_CATEGORY_FOOD_NAME = new FriendlyName(
            "Food",
            "food"
    );
    private static final FriendlyName ENDPOINT_CATEGORY_OTHER_NAME = new FriendlyName(
            "Other",
            "other"
    );
    private static final FriendlyName ENDPOINT_CATEGORY_TOBACCO_NAME = new FriendlyName(
            "Tobacco",
            "tobacco"
    );

    // Endpoint categories
    private static final List<EndpointCategory> ENDPOINT_CATEGORIES = List.of(
            new EndpointCategory(
                    ENDPOINT_CATEGORY_ANIMAL_AND_VETERINARY_NAME,
                    List.of(
                            new Endpoint(
                                    ENDPOINT_ADVERSE_EVENTS_NAME,
                                    ENDPOINT_CATEGORY_ANIMAL_AND_VETERINARY_NAME,
                                    ENDPOINT_CATEGORY_ANIMAL_AND_VETERINARY_NAME.internalName() + ENDPOINT_ADVERSE_EVENTS_NAME.internalName(),
                                    AnimalandveterinaryEvent.getFields()
                            )
                    )
            ),
            new EndpointCategory(
                    ENDPOINT_CATEGORY_DRUG_NAME,
                    List.of(
                            new Endpoint(
                                    ENDPOINT_ADVERSE_EVENTS_NAME,
                                    ENDPOINT_CATEGORY_DRUG_NAME,
                                    ENDPOINT_CATEGORY_DRUG_NAME.internalName() + ENDPOINT_ADVERSE_EVENTS_NAME.internalName(),
                                    DrugEvent.getFields()
                            ),
                            new Endpoint(
                                    ENDPOINT_PRODUCT_LABELING_NAME,
                                    ENDPOINT_CATEGORY_DRUG_NAME,
                                    ENDPOINT_CATEGORY_DRUG_NAME.internalName() + ENDPOINT_PRODUCT_LABELING_NAME.internalName(),
                                    DrugLabel.getFields()
                            ),
                            new Endpoint(
                                    ENDPOINT_NDC_DIRECTORY_NAME,
                                    ENDPOINT_CATEGORY_DRUG_NAME,
                                    ENDPOINT_CATEGORY_DRUG_NAME.internalName() + ENDPOINT_NDC_DIRECTORY_NAME.internalName(),
                                    DrugNdc.getFields()
                            ),
                            new Endpoint(
                                    ENDPOINT_RECALL_ENFORCEMENT_REPORTS_NAME,
                                    ENDPOINT_CATEGORY_DRUG_NAME,
                                    ENDPOINT_CATEGORY_DRUG_NAME.internalName() + ENDPOINT_RECALL_ENFORCEMENT_REPORTS_NAME.internalName(),
                                    DrugEnforcement.getFields()
                            ),
                            new Endpoint(
                                    ENDPOINT_DRUGS_AT_FDA_NAME,
                                    ENDPOINT_CATEGORY_DRUG_NAME,
                                    ENDPOINT_DRUGS_AT_FDA_NAME.internalName(),
                                    DrugDrugsfda.getFields()
                            )
                    )
            ),
            new EndpointCategory(
                    ENDPOINT_CATEGORY_DEVICE_NAME,
                    List.of(
                            new Endpoint(
                                    ENDPOINT_510K_NAME,
                                    ENDPOINT_CATEGORY_DEVICE_NAME,
                                    ENDPOINT_CATEGORY_DEVICE_NAME.internalName() + "clearance",
                                    Device510k.getFields()
                            ),
                            new Endpoint(
                                    ENDPOINT_CLASSIFICATION_NAME,
                                    ENDPOINT_CATEGORY_DEVICE_NAME,
                                    ENDPOINT_CATEGORY_DEVICE_NAME.internalName() + "class",
                                    DeviceClassification.getFields()
                            ),
                            new Endpoint(
                                    ENDPOINT_RECALL_ENFORCEMENT_REPORTS_NAME,
                                    ENDPOINT_CATEGORY_DEVICE_NAME,
                                    ENDPOINT_CATEGORY_DEVICE_NAME.internalName() + ENDPOINT_RECALL_ENFORCEMENT_REPORTS_NAME.internalName(),
                                    DeviceRecall.getFields()
                            ),
                            new Endpoint(
                                    ENDPOINT_ADVERSE_EVENTS_NAME,
                                    ENDPOINT_CATEGORY_DEVICE_NAME,
                                    ENDPOINT_CATEGORY_DEVICE_NAME.internalName() + ENDPOINT_ADVERSE_EVENTS_NAME.internalName(),
                                    DeviceEvent.getFields()
                            ),
                            new Endpoint(
                                    ENDPOINT_PRE_MARKET_APPROVAL_NAME,
                                    ENDPOINT_CATEGORY_DEVICE_NAME,
                                    ENDPOINT_CATEGORY_DEVICE_NAME.internalName() + ENDPOINT_PRE_MARKET_APPROVAL_NAME.internalName(),
                                    DevicePma.getFields()
                            ),
                            new Endpoint(
                                    ENDPOINT_RECALLS_NAME,
                                    ENDPOINT_CATEGORY_DEVICE_NAME,
                                    ENDPOINT_CATEGORY_DEVICE_NAME.internalName() + ENDPOINT_RECALLS_NAME.internalName(),
                                    DeviceRecall.getFields()
                            ),
                            new Endpoint(
                                    ENDPOINT_REGISTRATIONS_AND_LISTINGS_NAME,
                                    ENDPOINT_CATEGORY_DEVICE_NAME,
                                    ENDPOINT_CATEGORY_DEVICE_NAME.internalName() + "reglist",
                                    DeviceRegistrationlisting.getFields()
                            ),
                            new Endpoint(
                                    ENDPOINT_COVID_19_SEROLOGICAL_TESTING_EVALUATIONS_NAME,
                                    ENDPOINT_CATEGORY_DEVICE_NAME,
                                    ENDPOINT_CATEGORY_DEVICE_NAME.internalName() + ENDPOINT_COVID_19_SEROLOGICAL_TESTING_EVALUATIONS_NAME.internalName(),
                                    DeviceCovid19serology.getFields()
                            ),
                            new Endpoint(
                                    ENDPOINT_UNIQUE_DEVICE_IDENTIFIER_NAME,
                                    ENDPOINT_CATEGORY_DEVICE_NAME,
                                    ENDPOINT_CATEGORY_DEVICE_NAME.internalName() + ENDPOINT_UNIQUE_DEVICE_IDENTIFIER_NAME.internalName(),
                                    DeviceUdi.getFields()
                            )
                    )
            ),
            new EndpointCategory(
                    ENDPOINT_CATEGORY_FOOD_NAME,
                    List.of(
                            new Endpoint(
                                    ENDPOINT_RECALL_ENFORCEMENT_REPORTS_NAME,
                                    ENDPOINT_CATEGORY_FOOD_NAME,
                                    ENDPOINT_CATEGORY_FOOD_NAME.internalName() + ENDPOINT_RECALL_ENFORCEMENT_REPORTS_NAME.internalName(),
                                    FoodEnforcement.getFields()
                            ),
                            new Endpoint(
                                    ENDPOINT_ADVERSE_EVENTS_NAME,
                                    ENDPOINT_CATEGORY_FOOD_NAME,
                                    ENDPOINT_CATEGORY_FOOD_NAME.internalName() + ENDPOINT_ADVERSE_EVENTS_NAME.internalName(),
                                    FoodEvent.getFields()
                            )
                    )
            ),
            new EndpointCategory(
                    ENDPOINT_CATEGORY_OTHER_NAME,
                    List.of(
                            new Endpoint(
                                    ENDPOINT_NSDE_NAME,
                                    ENDPOINT_CATEGORY_OTHER_NAME,
                                    ENDPOINT_CATEGORY_OTHER_NAME.internalName() + ENDPOINT_NSDE_NAME.internalName(),
                                    OtherNsde.getFields()
                            ),
                            new Endpoint(
                                    ENDPOINT_SUBSTANCE_DATA_REPORTS_NAME,
                                    ENDPOINT_CATEGORY_OTHER_NAME,
                                    ENDPOINT_CATEGORY_OTHER_NAME.internalName() + ENDPOINT_SUBSTANCE_DATA_REPORTS_NAME.internalName(),
                                    OtherSubstance.getFields()
                            ),
                            new Endpoint(
                                    ENDPOINT_UNII_NAME,
                                    ENDPOINT_CATEGORY_OTHER_NAME,
                                    ENDPOINT_CATEGORY_OTHER_NAME.internalName() + ENDPOINT_UNII_NAME.internalName(),
                                    OtherUnii.getFields()
                            )
                    )
            ),
            new EndpointCategory(
                    ENDPOINT_CATEGORY_TOBACCO_NAME,
                    List.of(
                            new Endpoint(
                                    ENDPOINT_PROBLEM_REPORTS_NAME,
                                    ENDPOINT_CATEGORY_TOBACCO_NAME,
                                    ENDPOINT_CATEGORY_TOBACCO_NAME.internalName() + ENDPOINT_PROBLEM_REPORTS_NAME.internalName(),
                                    TobaccoProblem.getFields()
                            )
                    )
            )
    );

    private static final String FILE_MANIFEST_URL_STRING = "https://api.fda.gov/download.json";
    private static final String FIELDS_YAML_URL_STRING_TEMPLATE = "https://open.fda.gov/fields/%s.yaml";

    @NonNull
    public static List<EndpointCategory> getEndpointCategories() {
        return ENDPOINT_CATEGORIES;
    }

    @NonNull
    public static String getFileManifestUrlString() {
        return FILE_MANIFEST_URL_STRING;
    }

    @NonNull
    public static String getFieldsYamlUrlString(String endpointDatasetName) {
        return String.format(FIELDS_YAML_URL_STRING_TEMPLATE, endpointDatasetName);
    }
}
