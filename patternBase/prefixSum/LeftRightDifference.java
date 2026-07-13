package patternBase.prefixSum;

import java.util.Arrays;

public class LeftRightDifference {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;
        for (int i = 0; i < n; i++) {
            int rightSum = totalSum - leftSum - nums[i];
            result[i] = Math.abs(leftSum - rightSum);
            leftSum += nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        LeftRightDifference sol = new LeftRightDifference();
        int[] nums = {10, 4, 8, 3};
        int[] result = sol.leftRightDifference(nums);
        System.out.print("Left-Right Difference Array: " + Arrays.toString(result));
        System.out.println();
        for (int diff : result) {
            System.out.print(diff + " ");
        }
        System.out.println();
    }
}
