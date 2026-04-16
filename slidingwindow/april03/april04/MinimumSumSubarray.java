package slidingwindow.april03.april04;

import java.util.*;

public class MinimumSumSubarray {

    public int minimumSumSubarray(List<Integer> nums, int l, int r){
        int n = nums.size();

        //Step 1 : Prefix sum
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums.get(i);
        }
        int minSum = Integer.MAX_VALUE;

        //Step 2 : Try all subarrays
        for (int i = 0; i < n; i++) {
            for (int len = 0; len < r; len++) {
                int j = i + len;
                if (j > n) break;;

                int sum = prefix[j] - prefix[i];

                if (sum > 0){
                    minSum = Math.min(minSum, sum);
                }
            }
        }

        return minSum == Integer.MAX_VALUE ? -1 : minSum;
    }

    public static void main(String[] args) {
        MinimumSumSubarray sol = new MinimumSumSubarray();
        List<Integer> nums1 = Arrays.asList(3, -2, 1, 4);
        int l1 = 2, r1 = 3;

        List<Integer> nums2 = Arrays.asList(-2, 2, -3, 1);
        int l2 = 2, r2 = 3;

        List<Integer> nums3 = Arrays.asList(1, 2, 3, 4);
        int l3 = 2, r3 = 4;

        System.out.println(sol.minimumSumSubarray(nums1, l1, r1)); // 1
        System.out.println(sol.minimumSumSubarray(nums2, l2, r2)); // -1
        System.out.println(sol.minimumSumSubarray(nums3, l3, r3)); // 3
    }
}
