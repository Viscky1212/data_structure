package patternBase.recursionAndBackTracking.sheet.backtrack;

import java.util.*;

public class Permutation {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        boolean[] used = new boolean[nums.length];

        backtrack(nums, used, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int[] nums, boolean[] used, List<Integer> current, List<List<Integer>> result){

        //Base case
        if(current.size() == nums.length){
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i = 0; i < nums.length; i++){

            //Already used
            if(used[i]){
                continue;
            }


            //choose
            used[i] = true;
            current.add(nums[i]);

            //Explore
            backtrack(nums, used, current, result);

            //Undo
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        Permutation permutation = new Permutation();
        int[] nums = {1, 2, 3}; // Change this array to test different inputs
        List<List<Integer>> result = permutation.permute(nums);
        System.out.println("Permutations of " + Arrays.toString(nums) + ": " + result);
    }
}
