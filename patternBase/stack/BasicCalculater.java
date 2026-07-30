package patternBase.stack;

import java.util.Stack;

public class BasicCalculater {

//    public static int calculate(String expression) {
//        // Implementation for basic calculator
//
//        Stack<Integer> values = new Stack<>();
//
//        int num = 0;
//        char sign = '+';
//
//        for (int i = 0; i < expression.length(); i++) {
//            char c = expression.charAt(i);
//            if (Character.isDigit(c)) {
//                num = num * 10 + (c - '0');
//            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
//                if (sign == '+') {
//                    values.push(num);
//                } else if (sign == '-') {
//                    values.push(-num);
//                } else if (sign == '*') {
//                    values.push(values.pop() * num);
//                } else if (sign == '/') {
//                    values.push(values.pop() / num);
//                }
//                num = 0;
//                sign = c;
//            }
//        }
//        if (sign == '+') {
//            values.push(num);
//        } else if (sign == '-') {
//            values.push(-num);
//        } else if (sign == '*') {
//            values.push(values.pop() * num);
//        } else if (sign == '/') {
//            values.push(values.pop() / num);
//        }
//        int result = 0;
//        while (!values.isEmpty()) {
//            result += values.pop();
//        }
//        return result;
//    }

    public static int calculate(String s) {

        Stack<Integer> stack = new Stack<>();

        int num = 0;
        char sign = '+';

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // Build the current number
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }

            // Process when we see an operator or reach the end
            if ((!Character.isDigit(ch) && ch != ' ') || i == s.length() - 1) {

                switch (sign) {

                    case '+':
                        stack.push(num);
                        break;

                    case '-':
                        stack.push(-num);
                        break;

                    case '*':
                        stack.push(stack.pop() * num);
                        break;

                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                }

                sign = ch;
                num = 0;
            }
        }

        int result = 0;

        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }

    public static void main(String[] args) {
        String expression = "3 + 5 * 2 - 8 / 4";
        int result = calculate(expression);
        System.out.println("Result: " + result);
    }
}
