package binarySearch.april28;

import java.util.Arrays;
import java.util.Map;

public class MinAbsoluteSumDiff {

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2){
        int MOD = 1_000_000_007;
        int n = nums1.length;

        //Step 1 : Sorted copy of nums
        int[] sorted = nums1.clone();
        Arrays.sort(sorted);

        long totalSum = 0;
        int maxGain = 0;

        for (int i = 0; i < n; i++) {
            int a = nums1[i];
            int b = nums2[i];

            int diff = Math.abs(a - b);
            totalSum += diff;

            //Binary search for closest value
            int idx = Arrays.binarySearch(sorted,b);

            if (idx < 0){
                idx = - idx - 1;
            }

            //check candidate at idx
            if (idx < n){
                int newDiff = Math.abs(sorted[idx] - b);
                maxGain = Math.max(maxGain,diff - newDiff);
            }

            //check candidate at idx -1

            if (idx > 0){
                int newDiff = Math.abs(sorted[idx - 1] - b);
                maxGain = Math.max(maxGain,diff - newDiff);
            }
        }
        return (int) ((totalSum - maxGain) %MOD);
    }

    public static void main(String[] args) {

        MinAbsoluteSumDiff sol = new MinAbsoluteSumDiff();

        int[] nums1 = {1,7,5};
        int[] nums2 = {2,3,5};

        System.out.println(sol.minAbsoluteSumDiff(nums1, nums2)); // 3
    }
}
