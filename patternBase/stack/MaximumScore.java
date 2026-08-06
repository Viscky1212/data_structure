package patternBase.stack;

import java.util.Stack;

public class MaximumScore {

//    public static int maxScore(int[] nums, int k) {
//
//        int n = nums.length;
//
//        int[] prev = new int[n];
//        int[] next = new int[n];
//
//        Stack<Integer> stack = new Stack<>();
//
//        // Previous Smaller
//        for (int i = 0; i < n; i++) {
//
//            while (!stack.isEmpty()
//                    && nums[stack.peek()] >= nums[i]) {
//                stack.pop();
//            }
//
//            prev[i] = stack.isEmpty() ? -1 : stack.peek();
//            stack.push(i);
//        }
//
//        stack.clear();
//
//        // Next Smaller
//        for (int i = n - 1; i >= 0; i--) {
//
//            while (!stack.isEmpty()
//                    && nums[stack.peek()] >= nums[i]) {
//                stack.pop();
//            }
//
//            next[i] = stack.isEmpty() ? n : stack.peek();
//            stack.push(i);
//        }
//
//        int ans = 0;
//
//        for (int i = 0; i < n; i++) {
//
//            int left = prev[i] + 1;
//            int right = next[i] - 1;
//
//            if (left <= k && k <= right) {
//
//                int width = right - left + 1;
//
//                ans = Math.max(ans,
//                        nums[i] * width);
//            }
//        }
//
//        return ans;
//    }

    public static void main(String[] args) {

        int[] cardPoints = {1, 2, 3, 4, 5, 6, 1};
        int k = 3;
        System.out.println(maxScore(cardPoints, k)); // Output: 12
    }
//
    public static int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int totalSum = 0;

        for (int i = 0; i < n; i++) {
            totalSum += cardPoints[i];
        }

        if (k == n) {
            return totalSum;
        }

        int windowSize = n - k;
        int currentSum = 0;

        // Calculate the sum of the first window
        for (int i = 0; i < windowSize; i++) {
            currentSum += cardPoints[i];
        }

        int minWindowSum = currentSum;

        // Slide the window and find the minimum sum
        for (int i = windowSize; i < n; i++) {
            currentSum += cardPoints[i] - cardPoints[i - windowSize];
            minWindowSum = Math.min(minWindowSum, currentSum);
        }

        return totalSum - minWindowSum;
    }
}
