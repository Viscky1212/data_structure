package two_pointer_problem.march31;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinOperations {

    public int[] minOperations(int[] nums){
// pre compute binary palindrome
        List<Integer> palindrome = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            if (isBinaryPalindrome(i)){
                palindrome.add(i);
            }
        }
        int[] result = new int[nums.length];

        //Step 2 : For each number
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            int minOps = Integer.MAX_VALUE;

            for (int p : palindrome){
                minOps = Math.min(minOps, Math.abs(num - p));
            }
            result[i] = minOps;
        }
        return result;
    }

    public boolean isBinaryPalindrome(int num){
        String bin = Integer.toBinaryString(num);
        int l = 0, r = bin.length() - 1;

        while (l < r){
            if (bin.charAt(l++) != bin.charAt(r--)){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        MinOperations sol = new MinOperations();
        int[] nums1 = {1,2,4};
        int[] nums2 = {6,7,12};

        System.out.println("Output 1: " + Arrays.toString(sol.minOperations(nums1)));
        // [0,1,1]

        System.out.println("Output 2: " + Arrays.toString(sol.minOperations(nums2)));
        // [1,0,3]
    }
}
