package patternBase.TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSumDemo {
    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;

//        System.out.println("Original Array = ");
//        for (int num : nums) {
//            System.out.print(num + " ");
//        }
//        System.out.println();
//
//        System.out.println("Target = " + target);
//
//        System.out.println("Quadruplets that sum to target:");
//        fourSum(nums, target);

        List<List<Integer>> result = fourSum(nums, target);
        System.out.println("Quadruplets that sum to " + target + ":");
        for (List<Integer> quadruplet : result) {
            System.out.println(quadruplet);
        }
        System.out.println(result);

    }
//
//    private static void fourSum(int[] nums, int target) {
//        int n = nums.length;
//        Arrays.sort(nums); // Sort the array to use two-pointer technique
//
//        for (int i = 0; i < n - 3; i++) {
//            if (i > 0 && nums[i] == nums[i - 1]) continue; // Skip duplicates
//
//            for (int j = i + 1; j < n - 2; j++) {
//                if (j > i + 1 && nums[j] == nums[j - 1]) continue; // Skip duplicates
//
//                int left = j + 1;
//                int right = n - 1;
//
//                while (left < right) {
//                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
//
//                    if (sum == target) {
//                        System.out.println("[" + nums[i] + ", " + nums[j] + ", " + nums[left] + ", " + nums[right] + "]");
//                        left++;
//                        right--;
//
//                        // Skip duplicates
//                        while (left < right && nums[left] == nums[left - 1]) left++;
//                        while (left < right && nums[right] == nums[right + 1]) right--;
//                    } else if (sum < target) {
//                        left++;
//                    } else {
//                        right--;
//                    }
//                }
//            }
//        }
//    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;

                        while (left < right && nums[left] == nums[left - 1]) left++;
                        while (left < right && nums[right] == nums[right + 1]) right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return result;
    }



}
