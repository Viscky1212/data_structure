package patternBase.TwoPointer;

import java.util.Arrays;

public class TripletsWithSmallerSum {

    public static int countTriplets(int[] nums, int target) {
        int count = 0;
        int n = nums.length;

        // Sort the array to use two-pointer technique
        Arrays.sort(nums);

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];

                if (currentSum < target) {
                    // All triplets with the current 'i' and 'left' will have a sum smaller than target
                    count += (right - left); // Count all valid triplets
                    left++; // Move left pointer to find more triplets
                } else {
                    right--; // Move right pointer to decrease sum
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 1, 3};
        int target = 2;

        int count = countTriplets(nums, target);
        System.out.println("Number of triplets with sum smaller than " + target + " = " + count);
    }
}
