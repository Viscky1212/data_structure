package patternBase.TwoPointer;

import java.util.Arrays;

public class SortedSquereArray {

    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};

        System.out.println("Original Array = ");
        System.out.println(Arrays.toString(nums));
//        for (int num : nums) {
//            System.out.print(num + " ");
//        }
        System.out.println();


        int[] result = sortedSquares(nums);

        System.out.print("Squared and Sorted Array = ");
        System.out.println(Arrays.toString(result));
//        for (int num : result) {
//            System.out.print(num + " ");
//        }
    }

    private static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0;
        int right = n - 1;
        int index = n - 1;

        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            if (leftSquare > rightSquare) {
                result[index] = leftSquare;
                left++;
            } else {
                result[index] = rightSquare;
                right--;
            }
            index--;
        }

        return result;
    }
}
