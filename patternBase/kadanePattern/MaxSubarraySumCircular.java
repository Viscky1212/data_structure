package patternBase.kadanePattern;

public class MaxSubarraySumCircular {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;

        // for normal maximum subarray sum
        int currMax = nums[0];
        int maxSum = nums[0];

        // for minimum subarray sum
        int currMin = nums[0];
        int minSum = nums[0];

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            totalSum += num;

            if (i > 0) {
                // Kadane for maximum sum
                currMax = Math.max(num, currMax + num);
                maxSum = Math.max(maxSum, currMax);

                // Kadane for minimum sum
                currMin = Math.min(num, currMin + num);
                minSum = Math.min(minSum, currMin);
            }
        }

        // all numbers negative case
        if (maxSum < 0) {
            return maxSum;
        }

        // circular max = total sum - minimum subarray sum
        return Math.max(maxSum, totalSum - minSum);
    }

}
