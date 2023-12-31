package com.jaredbwasserman.openfda.util;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PermutationUtil {
    @NonNull
    public static List<List<Integer>> getPermutedIndices(@NonNull List<Integer> listSizes) {
        // First, compute the total number of permutations, which is the Cartesian product
        final long totalPermutations = listSizes.stream().reduce(1, (a, b) -> a * b);

        // Next, figure out the indices for each permutation
        final List<List<Integer>> permutedIndices = new ArrayList<>();
        for (int permutationIndex = 0; permutationIndex < totalPermutations; ++permutationIndex) {
            final List<Integer> currentPermutation = new ArrayList<>();

            int currentPermutationIndex = permutationIndex;
            for (int listSizesIndex = listSizes.size() - 1; listSizesIndex >= 0; --listSizesIndex) {
                final int currentListSize = listSizes.get(listSizesIndex);
                currentPermutation.add(currentPermutationIndex % currentListSize);
                currentPermutationIndex = currentPermutationIndex / currentListSize;
            }

            Collections.reverse(currentPermutation);
            permutedIndices.add(currentPermutation);
        }

        return permutedIndices;
    }
}
