package patternBase.stack;

import java.util.Stack;

public class IsValid {

//    public static boolean isValid(String s) {
//        int n = s.length();
//        if (n % 2 == 1) {
//            return false;
//        }
//
//        char[] stack = new char[n];
//        int top = -1;
//
//        for (char c : s.toCharArray()) {
//            if (c == '(') {
//                stack[++top] = ')';
//            } else if (c == '{') {
//                stack[++top] = '}';
//            } else if (c == '[') {
//                stack[++top] = ']';
//            } else {
//                if (top == -1 || stack[top--] != c) {
//                    return false;
//                }
//            }
//        }
//
//        return top == -1;
//    }

    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            if (ch == 'c') {

                // "abc" पूरा होना चाहिए
                if (stack.size() < 2) {
                    return false;
                }

                char second = stack.pop(); // b होना चाहिए
                char first = stack.pop();  // a होना चाहिए

                if (first != 'a' || second != 'b') {
                    return false;
                }

            } else {

                // a या b को push करो
                stack.push(ch);
            }
        }

        return stack.isEmpty();
    }
    public static void main(String[] args) {
        String s = "())";
        System.out.println(isValid(s)); // Output: false

        String s1 = "()[]{}";
        System.out.println(isValid(s1)); // Output: true

        String s2 = "(]";
        System.out.println(isValid(s2)); // Output: false
    }
}
