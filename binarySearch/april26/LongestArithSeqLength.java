package binarySearch.april26;

import java.util.HashMap;
import java.util.Map;

public class LongestArithSeqLength {

    public int longestArithSeqLength(int[] nums){
        int n = nums.length;

        Map<Integer,Integer>[] dp = new HashMap[n];

        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
        }

        int maxLength = 2;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j];

                int prevLength = dp[j].getOrDefault(diff,1);

                int currLegth = prevLength + 1;

                dp[i].put(diff,currLegth);

                maxLength = Math.max(maxLength,currLegth);
            }
        }
        return maxLength;
    }


    public static void main(String[] args) {
        LongestArithSeqLength solution = new LongestArithSeqLength();
        // Test Case 1
        int[] nums1 = {3, 6, 9, 12};
        System.out.println("Output 1: " + solution.longestArithSeqLength(nums1));
        // Expected: 4

        // Test Case 2
        int[] nums2 = {9, 4, 7, 2, 10};
        System.out.println("Output 2: " + solution.longestArithSeqLength(nums2));
        // Expected: 3

        // Test Case 3
        int[] nums3 = {20, 1, 15, 3, 10, 5, 8};
        System.out.println("Output 3: " + solution.longestArithSeqLength(nums3));
        // Expected: 4

        // Edge Case: All same elements
        int[] nums4 = {5, 5, 5, 5, 5};
        System.out.println("Output 4: " + solution.longestArithSeqLength(nums4));
        // Expected: 5

    }
}
