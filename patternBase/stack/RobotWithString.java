package patternBase.stack;

import java.util.Stack;

public class RobotWithString {
    public static   String robotWithString(String s) {

        int n = s.length();

        char[] min = new char[n];

        min[n - 1] = s.charAt(n - 1);

        // Suffix Minimum
        for (int i = n - 2; i >= 0; i--) {

            min[i] = (char) Math.min(s.charAt(i), min[i + 1]);
        }

        Stack<Character> stack = new Stack<>();

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < n; i++) {

            stack.push(s.charAt(i));

            while (!stack.isEmpty()) {

                char future = (i == n - 1) ? '{' : min[i + 1];

                if (stack.peek() <= future) {

                    ans.append(stack.pop());

                } else {

                    break;
                }
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) {

        String s = "cdcd";
        System.out.println(robotWithString(s));
    }
}
