package patternBase.stack;

import java.util.Stack;

public class MinInsertions {

    public static int minInsertions(String s) {

        int open = 0;     // कितने '(' अभी बंद नहीं हुए
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {

                open++;
            }

            else {

                // क्या " )) " pair है?
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {

                    i++; // दूसरा ')' भी consume कर लो

                } else {

                    // Single ')' मिला
                    ans++;
                }

                // अब इस "))" से किसी '(' को बंद करो
                if (open > 0) {

                    open--;

                } else {

                    // '(' नहीं था
                    ans++;
                }
            }
        }

        // बचे हुए '(' के लिए हर एक को " )) " चाहिए
        ans += open * 2;

        return ans;
    }
    public static void main(String[] args) {

        String s = "())";
        String s1 = "))())(";
        System.out.println(minInsertions(s));
        System.out.println(minInsertions(s1));
    }
}
