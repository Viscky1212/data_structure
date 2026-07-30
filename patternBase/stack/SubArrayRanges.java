package patternBase.stack;

import java.util.Stack;

public class SubArrayRanges {

    public  long subArrayRanges(int[] nums) {
        long sum = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int minVal = nums[i];
            int maxVal = nums[i];

            for (int j = i; j < n; j++) {
                minVal = Math.min(minVal, nums[j]);
                maxVal = Math.max(maxVal, nums[j]);
                sum += (maxVal - minVal);
            }
        }

        return sum;
    }
//
//    public long subArrayRanges(int[] nums) {
//        return sumMax(nums) - sumMin(nums);
//    }
//
//    private long sumMin(int[] nums) {
//
//        int n = nums.length;
//        int[] prev = new int[n];
//        int[] next = new int[n];
//
//        Stack<Integer> stack = new Stack<>();
//
//        // Previous Smaller
//        for (int i = 0; i < n; i++) {
//
//            while (!stack.isEmpty() &&
//                    nums[stack.peek()] >= nums[i]) {
//
//                stack.pop();
//            }
//
//            prev[i] = stack.isEmpty() ? -1 : stack.peek();
//
//            stack.push(i);
//        }
//
//        stack.clear();
//
//        // Next Smaller
//        for (int i = n - 1; i >= 0; i--) {
//
//            while (!stack.isEmpty() &&
//                    nums[stack.peek()] > nums[i]) {
//
//                stack.pop();
//            }
//
//            next[i] = stack.isEmpty() ? n : stack.peek();
//
//            stack.push(i);
//        }
//
//        long ans = 0;
//
//        for (int i = 0; i < n; i++) {
//
//            long left = i - prev[i];
//            long right = next[i] - i;
//
//            ans += (long) nums[i] * left * right;
//        }
//
//        return ans;
//    }
//
//    private long sumMax(int[] nums) {
//
//        int n = nums.length;
//        int[] prev = new int[n];
//        int[] next = new int[n];
//
//        Stack<Integer> stack = new Stack<>();
//
//        // Previous Greater
//        for (int i = 0; i < n; i++) {
//
//            while (!stack.isEmpty() &&
//                    nums[stack.peek()] <= nums[i]) {
//
//                stack.pop();
//            }
//
//            prev[i] = stack.isEmpty() ? -1 : stack.peek();
//
//            stack.push(i);
//        }
//
//        stack.clear();
//
//        // Next Greater
//        for (int i = n - 1; i >= 0; i--) {
//
//            while (!stack.isEmpty() &&
//                    nums[stack.peek()] < nums[i]) {
//
//                stack.pop();
//            }
//
//            next[i] = stack.isEmpty() ? n : stack.peek();
//
//            stack.push(i);
//        }
//
//        long ans = 0;
//
//        for (int i = 0; i < n; i++) {
//
//            long left = i - prev[i];
//            long right = next[i] - i;
//
//            ans += (long) nums[i] * left * right;
//        }
//
//        return ans;
//    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        SubArrayRanges solution = new SubArrayRanges();
        long result = solution.subArrayRanges(nums);
        System.out.println("Sum of Subarray Ranges: " + result); // Output: 4
    }
}
