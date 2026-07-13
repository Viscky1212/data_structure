package patternBase.prefixSum;

import java.util.*;

public class SubArraySum {
    public static int subArraySum(int[] nums, int k) {
        int count = 0;
        int prefixSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // Initialize with sum 0 having one occurrence

        for (int num : nums) {
            prefixSum += num;
            if (map.containsKey(prefixSum - k)) {
                count += map.get(prefixSum - k);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int k = 3;
        int result = subArraySum(nums, k);
        System.out.println("Number of subarrays with sum " + k + ": " + result); // Output: 2

        int [] nums2 = {1, 1, 1};
        int k2 = 2;
        int result2 = subArraySum(nums2, k2);
        System.out.println("Number of subarrays with sum " + k2 + ": " + result2); // Output: 2
    }
}
