package patternBase.stack;

import java.util.Stack;

public class MinRemoveToMakeValid {

    public static String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        boolean[] toRemove = new boolean[s.length()];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    toRemove[i] = true;
                }
            }
        }

        while (!stack.isEmpty()) {
            toRemove[stack.pop()] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!toRemove[i]) {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        String s = "lee(t(c)o)de)";
        System.out.println(minRemoveToMakeValid(s)); // Output: "lee(t(c)o)de"
    }
}
