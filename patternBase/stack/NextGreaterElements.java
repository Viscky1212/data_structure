package patternBase.stack;

import java.util.Stack;

public class NextGreaterElements {

//    public static int[] nextGreaterElements(int[] nums) {
//        int n = nums.length;
//        int[] result = new int[n];
//        Stack<Integer> stack = new Stack<>();
//
//        for (int i = 2 * n - 1; i >= 0; i--) {
//            while (!stack.isEmpty() && stack.peek() <= nums[i % n]) {
//                stack.pop();
//            }
//            result[i % n] = stack.isEmpty() ? -1 : stack.peek();
//            stack.push(nums[i % n]);
//        }
//
//        return result;
//    }


    public static int[] nextGreaterElements(int[] nums) {

        int n = nums.length;

        int[] ans = new int[n];

        Stack<Integer> stack = new Stack<>();

        // Right से Left दो बार चलेंगे
        for (int i = 2 * n - 1; i >= 0; i--) {

            int index = i % n;

            // छोटे या बराबर elements हटा दो
            while (!stack.isEmpty()
                    && stack.peek() <= nums[index]) {

                stack.pop();
            }

            // केवल दूसरे half (असल indices) में answer भरें
            if (i < n) {

                if (stack.isEmpty()) {
                    ans[index] = -1;
                } else {
                    ans[index] = stack.peek();
                }
            }

            // Current value stack में डालो
            stack.push(nums[index]);
        }

        return ans;
    }
    public static void main(String[] args) {

        int[] nums = {4, 5, 2, 25};
        int[] result = nextGreaterElements(nums);

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
