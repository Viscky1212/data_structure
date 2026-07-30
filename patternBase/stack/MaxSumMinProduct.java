package patternBase.stack;

import java.util.Stack;

public class MaxSumMinProduct {

    public static int maxSumMinProduct(int[] arr) {
        int n = arr.length;
        long maxProduct = 0;
        long[] prefixSum = new long[n + 1];

        // Calculate prefix sum
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + arr[i];
        }

        // Use a stack to find the next smaller element on the left and right
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Find the next smaller element on the left
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        // Find the next smaller element on the right
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        // Calculate the maximum product
        for (int i = 0; i < n; i++) {
            long sum = prefixSum[right[i]] - prefixSum[left[i] + 1];
            maxProduct = Math.max(maxProduct, sum * arr[i]);
        }

        return (int) (maxProduct % 1000000007);
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 2};
        int maxSumMinProduct = maxSumMinProduct(arr);
        System.out.println("Maximum Sum Min Product: " + maxSumMinProduct);
    }
}
