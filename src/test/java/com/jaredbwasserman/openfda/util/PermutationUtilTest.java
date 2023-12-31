package com.jaredbwasserman.openfda.util;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PermutationUtilTest {
    @Test
    public void testGetPermutedIndices() {
        final Map<List<Integer>, List<List<Integer>>> inputOutput = Map.of(
                List.of(5),
                List.of(
                        List.of(0),
                        List.of(1),
                        List.of(2),
                        List.of(3),
                        List.of(4)
                ),
                List.of(4, 3),
                List.of(
                        List.of(0, 0),
                        List.of(0, 1),
                        List.of(0, 2),
                        List.of(1, 0),
                        List.of(1, 1),
                        List.of(1, 2),
                        List.of(2, 0),
                        List.of(2, 1),
                        List.of(2, 2),
                        List.of(3, 0),
                        List.of(3, 1),
                        List.of(3, 2)
                ),
                List.of(0),
                List.of()
        );

        for (final Map.Entry<List<Integer>, List<List<Integer>>> inputOutputEntry : inputOutput.entrySet()) {
            final List<List<Integer>> actualOutput = PermutationUtil.getPermutedIndices(inputOutputEntry.getKey());
            assertEquals(inputOutputEntry.getValue(), actualOutput);
        }
    }
}
