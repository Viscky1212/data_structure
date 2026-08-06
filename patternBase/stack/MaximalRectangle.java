package patternBase.stack;

import java.util.Stack;

public class MaximalRectangle {

//    public static int maximalRectangle(char[][] matrix) {
//        if (matrix.length == 0) {
//            return 0;
//        }
//
//        int maxArea = 0;
//        int[] heights = new int[matrix[0].length];
//
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                heights[j] = matrix[i][j] == '1' ? heights[j] + 1 : 0;
//            }
//            maxArea = Math.max(maxArea, largestRectangleArea(heights));
//        }
//
//        return maxArea;
//    }
//
//    private static int largestRectangleArea(int[] heights) {
//        int n = heights.length;
//        int[] prev = new int[n];
//        int[] next = new int[n];
//
//        Stack<Integer> stack = new Stack<>();
//
//        // Previous Smaller
//        for (int i = 0; i < n; i++) {
//            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
//                stack.pop();
//            }
//            prev[i] = stack.isEmpty() ? -1 : stack.peek();
//            stack.push(i);
//        }
//
//        stack.clear();
//
//        // Next Smaller
//        for (int i = n - 1; i >= 0; i--) {
//            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
//                stack.pop();
//            }
//            next[i] = stack.isEmpty() ? n : stack.peek();
//            stack.push(i);
//        }
//
//        int maxArea = 0;
//
//        for (int i = 0; i < n; i++) {
//            int width = next[i] - prev[i] - 1;
//            int area = heights[i] * width;
//            maxArea = Math.max(maxArea, area);
//        }
//
//        return maxArea;
//    }


        public static int maximalRectangle(char[][] matrix) {

            if (matrix == null || matrix.length == 0)
                return 0;

            int rows = matrix.length;
            int cols = matrix[0].length;

            int[] height = new int[cols];

            int maxArea = 0;

            for (int i = 0; i < rows; i++) {

                // Build histogram
                for (int j = 0; j < cols; j++) {

                    if (matrix[i][j] == '1')
                        height[j]++;
                    else
                        height[j] = 0;
                }

                maxArea = Math.max(maxArea,
                        largestRectangle(height));
            }

            return maxArea;
        }

        private static int largestRectangle(int[] heights) {

            Stack<Integer> stack = new Stack<>();

            int maxArea = 0;
            int n = heights.length;

            for (int i = 0; i <= n; i++) {

                int currHeight = (i == n) ? 0 : heights[i];

                while (!stack.isEmpty() &&
                        currHeight < heights[stack.peek()]) {

                    int height = heights[stack.pop()];

                    int width = stack.isEmpty()
                            ? i
                            : i - stack.peek() - 1;

                    maxArea = Math.max(maxArea,
                            height * width);
                }

                stack.push(i);
            }

            return maxArea;
        }


        public static void main(String[] args) {

        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };

        int maxArea = maximalRectangle(matrix);
        System.out.println("Maximal Rectangle Area: " + maxArea); // Output: 6
    }
}
