package com.jaredbwasserman.openfda.model.generated;

import lombok.NonNull;

import java.util.List;

public class DrugEvent {
    @NonNull
    public static List<String> getFields() {
        return List.of(
                "authoritynumb",
                "companynumb",
                "duplicate",
                "fulfillexpeditecriteria",
                "occurcountry",
                "patient.drug",
                "patient.patientagegroup",
                "patient.patientdeath.patientdeathdate",
                "patient.patientdeath.patientdeathdateformat",
                "patient.patientonsetage",
                "patient.patientonsetageunit",
                "patient.patientsex",
                "patient.patientweight",
                "patient.reaction",
                "patient.summary.narrativeincludeclinical",
                "primarysource.literaturereference",
                "primarysource.qualification",
                "primarysource.reportercountry",
                "primarysourcecountry",
                "receiptdate",
                "receiptdateformat",
                "receivedate",
                "receivedateformat",
                "receiver.receiverorganization",
                "receiver.receivertype",
                "reportduplicate.duplicatenumb",
                "reportduplicate.duplicatesource",
                "reporttype",
                "safetyreportid",
                "safetyreportversion",
                "sender.senderorganization",
                "sender.sendertype",
                "serious",
                "seriousnesscongenitalanomali",
                "seriousnessdeath",
                "seriousnessdisabling",
                "seriousnesshospitalization",
                "seriousnesslifethreatening",
                "seriousnessother",
                "transmissiondate",
                "transmissiondateformat"
        );
    }
}
