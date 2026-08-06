package patternBase.stack;

import java.util.Stack;

public class LongestValidParentheses {

    public static int longestValidParentheses(String s) {

        Stack<Integer> stack = new Stack<>();

        // Base index
        stack.push(-1);

        int max = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {

                stack.push(i);

            } else {

                stack.pop();

                if (stack.isEmpty()) {

                    // New base
                    stack.push(i);

                } else {

                    max = Math.max(max, i - stack.peek());
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {

        String s = "(()";
        System.out.println(longestValidParentheses(s)); // Output: 2

        String s1 = ")()())";
        System.out.println(longestValidParentheses(s1)); // Output: 4

        String s2 = "";
        System.out.println(longestValidParentheses(s2)); // Output: 0
    }
}
