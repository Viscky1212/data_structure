package patternBase.stack;

import java.util.Stack;

public class CheckValidParantheses {

    public static boolean checkValidParantheses(String s) {
        int low = 0;
        int high = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                low++;
                high++;
            } else if (ch == ')') {
                low--;
                high--;
            } else { // ch == '*'
                low--;
                high++;
            }

            if (high < 0) {
                return false;
            }

            low = Math.max(low, 0);
        }

        return low == 0;
    }

    public static void main(String[] args) {

        String s = "(*))";
        System.out.println(checkValidParantheses(s)); // Output: true
    }
}
