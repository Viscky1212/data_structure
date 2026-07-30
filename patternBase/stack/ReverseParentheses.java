package patternBase.stack;

import java.util.Stack;

public class ReverseParentheses {

//    public static String reverseParentheses(String s) {
//        StringBuilder sb = new StringBuilder();
//        int openCount = 0;
//        int closeCount = 0;
//
//        for (char c : s.toCharArray()) {
//            if (c == '(') {
//                openCount++;
//            } else if (c == ')') {
//                closeCount++;
//            } else {
//                sb.append(c);
//            }
//        }
//
//        if (openCount != closeCount) {
//            throw new IllegalArgumentException("Unbalanced parentheses in the input string.");
//        }
//
//        return sb.reverse().toString();
//    }

    public static String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray()){

            if(ch != ')'){

                stack.push(ch);

            } else {
                StringBuilder temp = new StringBuilder();

                while(stack.peek() != '('){
                    temp.append(stack.pop());
                }

                //remove '('

                stack.pop();

                //push reversed substring back
                for(char c : temp.toString().toCharArray()){
                    stack.push(c);
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
    public static void main(String[] args) {

        String s = "(abcd)";
        System.out.println(reverseParentheses(s)); // Output: "dcba"
    }
}
