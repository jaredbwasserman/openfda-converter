package com.jaredbwasserman.openfda.generate;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class EndpointDatasetFieldsGeneratorTest {
    @Disabled
    @Test
    public void testGenerateFieldsForAllEndpoints() {
        EndpointDatasetFieldsGenerator.generateFieldsForAllEndpoints(System.getenv("FIELDS_GENERATOR_OUTPUT_PATH"));
    }
}
