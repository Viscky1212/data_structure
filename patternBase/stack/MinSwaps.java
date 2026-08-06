package patternBase.stack;

import java.util.Stack;

public class MinSwaps {

//    public static int minSwaps(String s) {
//        int swaps = 0;
//        int balance = 0;
//
//        for (char c : s.toCharArray()) {
//            if (c == '[') {
//                balance++;
//            } else {
//                balance--;
//                if (balance < 0) {
//                    swaps++;
//                    balance = 0;
//                }
//            }
//        }
//
//        return swaps;
//    }

    //using stack
    public static int minSwaps(String s) {
        Stack<Character> stack = new Stack<>();
        int swaps = 0;

        for (char c : s.toCharArray()) {
            if (c == '[') {
                stack.push(c);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    swaps++;
                }
            }
        }
        return swaps;
    }

    public static void main(String[] args) {

        String s = "]]][[[";
        System.out.println(minSwaps(s));
    }
}
