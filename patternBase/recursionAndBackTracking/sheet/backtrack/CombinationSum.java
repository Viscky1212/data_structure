package patternBase.recursionAndBackTracking.sheet.backtrack;

import java.util.*;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();

        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidate, int target, int index, List<Integer> current, List<List<Integer>> result){

        //Base case : target achived
        if(target == 0){
            result.add(new ArrayList<>(current));
            return;
        }

        //No valide combination
        if(target < 0){
            return;
        }

        //try candicate from two index
        for(int i = index; i < candidate.length; i++){

            //choose
            current.add(candidate[i]);

            //Explore
            //i, NOT i + 1
            //becouse we can reuse same number
            backtrack(candidate, target - candidate[i], i, current, result);

            //undo choise
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {

        CombinationSum combinationSum = new CombinationSum();
        int[] candidates = {2, 3, 6, 7}; // Change this array to test different inputs
        int target = 7; // Change this value to test different targets
        List<List<Integer>> result = combinationSum.combinationSum(candidates, target);
        System.out.println("Combination sums for target " + target + ": " + result);
    }
}
