package patternBase.kadanePattern;

public class maxAbsoluteSum {

    public static int maxAbsoluteSum(int[] nums) {
        int maxSum = 0;
        int minSum = 0;
        int currentMax = 0;
        int currentMin = 0;

        for (int num : nums) {
            currentMax = Math.max(num, currentMax + num);
            maxSum = Math.max(maxSum, currentMax);

            currentMin = Math.min(num, currentMin + num);
            minSum = Math.min(minSum, currentMin);
        }

        return Math.max(maxSum, -minSum);
    }

    public static void main(String[] args) {
        int[] nums = {1, -3, 2, 3, -4};
        int result = maxAbsoluteSum(nums);
        System.out.println("Maximum absolute sum of any subarray: " + result); // Output: 5
    }
}
