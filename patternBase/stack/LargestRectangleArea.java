package patternBase.stack;

import java.util.Stack;

public class LargestRectangleArea {
    public static int largestRectangleArea(int[] heights) {

        int n = heights.length;

        int[] prev = new int[n];
        int[] next = new int[n];

        Stack<Integer> stack = new Stack<>();

        // Previous Smaller
        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty()
                    && heights[stack.peek()] >= heights[i]) {

                stack.pop();
            }

            prev[i] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(i);
        }

        stack.clear();

        // Next Smaller
        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty()
                    && heights[stack.peek()] >= heights[i]) {

                stack.pop();
            }

            next[i] = stack.isEmpty() ? n : stack.peek();

            stack.push(i);
        }

        int maxArea = 0;

        for (int i = 0; i < n; i++) {

            int width = next[i] - prev[i] - 1;

            int area = heights[i] * width;

            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

//    public static int largestRectangleArea(int[] heights) {
//
//        Stack<Integer> stack = new Stack<>();
//        int maxArea = 0;
//        int n = heights.length;
//
//        for (int i = 0; i <= n; i++) {
//
//            int currHeight = (i == n) ? 0 : heights[i];
//
//            while (!stack.isEmpty() &&
//                    currHeight < heights[stack.peek()]) {
//
//                int height = heights[stack.pop()];
//
//                int width = stack.isEmpty()
//                        ? i
//                        : i - stack.peek() - 1;
//
//                maxArea = Math.max(maxArea, height * width);
//            }
//
//            stack.push(i);
//        }
//
//        return maxArea;
//    }

    public static void main(String[] args) {

        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(heights)); // Output: 10
    }
}
