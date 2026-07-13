package patternBase.prefixSum;

public class MinStartValue {
    public static int minStartValue(int[] nums) {
        int minSum = 0;
        int currentSum = 0;

        for (int num : nums) {
            currentSum += num;
            minSum = Math.min(minSum, currentSum);
        }

        return 1 - minSum; // Minimum start value to keep the sum >= 1
    }

    public static void main(String[] args) {
        int[] nums = {-3, 2, -3, 4, 2};
        int minStartValue = minStartValue(nums);
        System.out.println("Minimum start value: " + minStartValue); // Output: 5
    }
}
