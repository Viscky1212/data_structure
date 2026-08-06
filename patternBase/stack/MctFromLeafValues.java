package patternBase.stack;

import java.util.Stack;

public class MctFromLeafValues {
    public static int mctFromLeafValues(int[] arr) {

        Stack<Integer> stack = new Stack<>();

        // Sentinel
        stack.push(Integer.MAX_VALUE);

        int cost = 0;

        for (int num : arr) {

            while (stack.peek() <= num) {

                int mid = stack.pop();

                cost += mid * Math.min(stack.peek(), num);
            }

            stack.push(num);
        }

        // Remaining Elements
        while (stack.size() > 2) {

            cost += stack.pop() * stack.peek();
        }

        return cost;
    }

    public static void main(String[] args) {

        int[] arr = {6, 2, 4};
        System.out.println(mctFromLeafValues(arr));
    }
}
