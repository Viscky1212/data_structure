package patternBase.stack;

import java.util.*;

public class RemoveKdigits {

    public static String removeKdigits(String num, int k) {

        Stack<Character> stack = new Stack<>();

        // हर digit process करो
        for (char ch : num.toCharArray()) {

            // यदि current digit छोटी है,
            // तो बड़ी digit हटा दो
            while (!stack.isEmpty()
                    && k > 0
                    && stack.peek() > ch) {

                stack.pop();
                k--;
            }

            stack.push(ch);
        }

        // यदि अभी भी digits हटानी बाकी हैं
        while (k > 0) {

            stack.pop();
            k--;
        }

        // Stack से String बनाओ
        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {

            sb.append(stack.pop());
        }

        // क्योंकि stack से उल्टा निकला
        sb.reverse();

        // Leading zeros हटाओ
        int index = 0;

        while (index < sb.length()
                && sb.charAt(index) == '0') {

            index++;
        }

        String ans = sb.substring(index);

        return ans.isEmpty() ? "0" : ans;
    }

    public static void main(String[] args) {

        String num = "1432219";
        int k = 3;
        String result = removeKdigits(num, k);
        System.out.println(result); // Output: "1219"
    }
}
