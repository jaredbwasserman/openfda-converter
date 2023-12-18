package com.jaredbwasserman.openfda.endpoint;

import java.util.List;

public class Endpoints {
    private static final List<EndpointCategory> ENDPOINTS = List.of(
            new EndpointCategory(
                    "Animal & Veterinary",
                    "animalandveterinary",
                    List.of(
                            new Endpoint(
                                    "Adverse Events",
                                    "event"
                            )
                    )
            ),
            new EndpointCategory(
                    "Drug",
                    "drug",
                    List.of(
                            new Endpoint(
                                    "Adverse Events",
                                    "event"
                            ),
                            new Endpoint(
                                    "Product Labeling",
                                    "label"
                            ),
                            new Endpoint(
                                    "NDC Directory",
                                    "ndc"
                            ),
                            new Endpoint(
                                    "Recall Enforcement Reports",
                                    "enforcement"
                            ),
                            new Endpoint(
                                    "Drugs@FDA",
                                    "drugsfda"
                            )
                    )
            ),
            new EndpointCategory(
                    "Device",
                    "device",
                    List.of(
                            new Endpoint(
                                    "510(k)",
                                    "510k"
                            ),
                            new Endpoint(
                                    "Classification",
                                    "classification"
                            ),
                            new Endpoint(
                                    "Recall Enforcement Reports",
                                    "enforcement"
                            ),
                            new Endpoint(
                                    "Adverse Events",
                                    "event"
                            ),
                            new Endpoint(
                                    "Pre-market Approval",
                                    "pma"
                            ),
                            new Endpoint(
                                    "Recalls",
                                    "recall"
                            ),
                            new Endpoint(
                                    "Registrations and Listings",
                                    "registrationlisting"
                            ),
                            new Endpoint(
                                    "COVID-19 Serological Testing Evaluations",
                                    "covid19serology"
                            ),
                            new Endpoint(
                                    "Unique Device Identifier",
                                    "udi"
                            )
                    )
            ),
            new EndpointCategory(
                    "Food",
                    "food",
                    List.of(
                            new Endpoint(
                                    "Recall Enforcement Reports",
                                    "enforcement"
                            ),
                            new Endpoint(
                                    "Adverse Events",
                                    "event"
                            )
                    )
            ),
            new EndpointCategory(
                    "Other",
                    "other",
                    List.of(
                            new Endpoint(
                                    "NSDE",
                                    "nsde"
                            ),
                            new Endpoint(
                                    "Substance Data Reports",
                                    "substance"
                            ),
                            new Endpoint(
                                    "UNII",
                                    "unii"
                            )
                    )
            ),
            new EndpointCategory(
                    "Tobacco",
                    "tobacco",
                    List.of(
                            new Endpoint(
                                    "Problem Reports",
                                    "problem"
                            )
                    )
            )
    );
}
