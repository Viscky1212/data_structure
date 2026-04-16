package two_pointer_problem.aprill01;

import java.util.Arrays;

public class RangeSum {

    public int rangeSum(int[] nums, int n, int left, int right) {
        // Total number of subarrays is n * (n + 1) / 2
        int[] subarraySums = new int[n * (n + 1) / 2];
        int index = 0;

        // 1. Generate all contiguous subarray sums
        for (int i = 0; i < n; i++) {
            int currentSum = 0;
            for (int j = i; j < n; j++) {
                currentSum += nums[j];
                subarraySums[index++] = currentSum;
            }
        }

        // 2. Sort the array of sums in non-decreasing order
        Arrays.sort(subarraySums);

        // 3. Sum the elements from index `left` to `right` (1-based to 0-based conversion)
        int mod = 1_000_000_007;
        long totalSum = 0; // Use long to prevent overflow during addition

        for (int i = left - 1; i < right; i++) {
            totalSum = (totalSum + subarraySums[i]) % mod;
        }

        return (int) totalSum;
    }

    public static void main(String[] args) {
        RangeSum sol = new RangeSum();
        // Example 1
        int[] nums1 = {1, 2, 3, 4};
        int n1 = 4, left1 = 1, right1 = 5;
        System.out.println("Example 1 Output: " + sol.rangeSum(nums1, n1, left1, right1));
        // Expected: 13 (Sums are 1, 2, 3, 3, 4... 1+2+3+3+4 = 13)

        // Example 2
        int[] nums2 = {1, 2, 3, 4};
        int n2 = 4, left2 = 3, right2 = 4;
        System.out.println("Example 2 Output: " + sol.rangeSum(nums2, n2, left2, right2));
        // Expected: 6 (Elements at index 3 and 4 are 3 and 3... 3+3 = 6)

        // Example 3
        int[] nums3 = {1, 2, 3, 4};
        int n3 = 4, left3 = 1, right3 = 10;
        System.out.println("Example 3 Output: " + sol.rangeSum(nums3, n3, left3, right3));
        // Expected: 50 (Sum of all subarray sums)
    }
}
