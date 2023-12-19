package com.jaredbwasserman.openfda;

import com.jaredbwasserman.openfda.api.EndpointCategory;
import com.jaredbwasserman.openfda.api.OpenFDAAPI;

import java.util.Map;

public class App {
    public static void main(String[] args) {
        // TODO: Fix me
        final Map<String, EndpointCategory> endpointCategories = OpenFDAAPI.getEndpointCategories();
        for (final Map.Entry<String, EndpointCategory> endpointCategoryEntry : endpointCategories.entrySet()) {
            System.out.println(endpointCategoryEntry.getKey());
            System.out.println("\t" + OpenFDAAPI.getEndpoints(endpointCategoryEntry.getValue()));
        }
    }
}
