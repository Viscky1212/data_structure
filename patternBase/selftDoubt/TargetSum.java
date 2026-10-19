package patternBase.selftDoubt;

import java.util.Arrays;

public class TargetSum {

    private static void hasTargetSum2(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    //want to return value of i and j
                    System.out.println("i: " + i + ", j: " + j);
                    // i want print the value of nums[i] and nums[j]
                    System.out.println("nums[i]: " + nums[i] + ", nums[j]: " + nums[j]);
                }
            }
        }
    }

    // by two pinters
    private static void hasTargetSumTwoPointers(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                System.out.println("i: " + left + ", j: " + right);
                System.out.println("nums[i]: " + nums[left] + ", nums[j]: " + nums[right]);
                break;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int target = 9;
        boolean result = hasTargetSum(nums, target);
        System.out.println("Result: " + result);

        hasTargetSum2(nums, target);

        System.out.println("Using two pointers:");
        hasTargetSumTwoPointers(nums, target);
    }

    private static boolean hasTargetSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return true;
                }
            }
        }
        return false;
    }


}
