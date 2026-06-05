package patternBase.slidingWindow;

public class MaxSubarraySum {
    public int maxSubArray(int[] nums, int k) {
        int n = nums.length;

        if (n < k) {
            return 0;
           // throw new IllegalArgumentException("Window size k must be less than or equal to the array length.");
        }

        int maxSum = Integer.MIN_VALUE;
        int windowSum = 0;

        //Calculate the sum of the first window
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        maxSum = windowSum;

        //Slide the window across the array
        for (int i = k; i < n; i++) {
         //Add new element and remove the leftmost element of the previous window
            windowSum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }


        return maxSum;
    }

    public static void main(String[] args) {
        MaxSubarraySum sol = new MaxSubarraySum();

        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(sol.maxSubArray(nums1, 3));
        // Output: 6

        int[] nums2 = {1};
        System.out.println(sol.maxSubArray(nums2, 1));
        // Output: 1

        int[] nums3 = {5, 4, -1, 7, 8};
        System.out.println(sol.maxSubArray(nums3, 3));;
        // Output: 23
    }
}
