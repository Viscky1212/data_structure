package patternBase.recursionAndBackTracking;

import java.util.*;

public class CombinationSum {

    public static List<List<Integer>> combinationSum(
            int[] candidates,
            int target) {

        List<List<Integer>> result = new ArrayList<>();

        backtrack(
                candidates,
                target,
                0,
                new ArrayList<>(),
                result
        );

        return result;
    }

    private static void backtrack(
            int[] candidates,
            int target,
            int index,
            List<Integer> current,
            List<List<Integer>> result) {

        // Base case: exact target achieved
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        // No more elements
        if (index == candidates.length) {
            return;
        }

        // Try every possible choice from current index
        for (int i = index; i < candidates.length; i++) {

            // If value is bigger than remaining target,
            // it cannot be selected.
            if (candidates[i] > target) {
                continue;
            }

            // Choose
            current.add(candidates[i]);

            // Explore
            // Pass i, NOT i + 1
            // because the same number can be reused.
            backtrack(
                    candidates,
                    target - candidates[i],
                    i,
                    current,
                    result
            );

            // Undo / Backtrack
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {

        int[] candidates = {2, 3, 6, 7};
        int target = 7;

        System.out.println(
                combinationSum(candidates, target)
        );
    }
}