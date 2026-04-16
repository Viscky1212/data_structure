package slidingwindow.april09;

import java.util.*;

public class MaxSubarrayLength {

    public int maxSubarrayLength(int[] nums, int k){
        Map<Integer, Integer> freq = new HashMap<>();

        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < nums.length; right++) {
            //add element
            freq.put(nums[right], freq.getOrDefault(nums[right],0) + 1);

            //if violation occurs
            while (freq.get(nums[right]) > k){
                freq.put(nums[left], freq.get(nums[left]) - 1);
                left++;
            }
         //update maxLen
         maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        MaxSubarrayLength sol = new MaxSubarrayLength();

        int[] nums1 = {1,2,3,1,2,3,1,2};
        System.out.println(sol.maxSubarrayLength(nums1, 2)); // 6

        int[] nums2 = {1,2,1,2,1,2,1,2};
        System.out.println(sol.maxSubarrayLength(nums2, 1)); // 2

        int[] nums3 = {5,5,5,5,5};
        System.out.println(sol.maxSubarrayLength(nums3, 4)); // 4
    }
}
