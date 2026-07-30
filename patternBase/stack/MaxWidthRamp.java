package patternBase.stack;

import java.util.Stack;

public class MaxWidthRamp {

    public  static int maxWidthRamp(int[] nums) {

        int n = nums.length;

        Stack<Integer> stack = new Stack<>();

        // Build decreasing stack of indices
        for (int i = 0; i < n; i++) {

            if (stack.isEmpty() || nums[i] < nums[stack.peek()]) {
                stack.push(i);
            }
        }

        int maxWidth = 0;

        // Traverse from right
        for (int j = n - 1; j >= 0; j--) {

            while (!stack.isEmpty()
                    && nums[stack.peek()] <= nums[j]) {

                maxWidth = Math.max(maxWidth,
                        j - stack.pop());
            }
        }

        return maxWidth;
    }

//    public static int maxWidthRamp(int[] arr) {
//        int n = arr.length;
//        int maxWidth = 0;
//
//        for (int i = 0; i < n; i++) {
//            for (int j = n - 1; j > i; j--) {
//                if (arr[i] <= arr[j]) {
//                    maxWidth = Math.max(maxWidth, j - i);
//                    break; // No need to check further for this i
//                }
//            }
//        }
//
//        return maxWidth;
//    }

    public static void main(String[] args) {

        int[] arr = {6, 0, 8, 2, 1, 5};

        int maxWidth = maxWidthRamp(arr);

        System.out.println("Maximum Width Ramp: " + maxWidth);
    }
}
