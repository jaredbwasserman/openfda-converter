package com.jaredbwasserman.openfda.generate;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class EndpointDatasetKeysGeneratorTest {
    @Disabled
    @Test
    public void testEndpointDatasetKeysGenerator() {
        EndpointDatasetKeysGenerator.generateKeysForAllEndpoints(System.getenv("KEYS_GENERATOR_PATH"));
    }
}
