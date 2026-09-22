package patternBase.recursionAndBackTracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static void generate(
            int open,
            int close,
            int n,
            StringBuilder current,
            List<String> result) {

        // Base case
        if (open == n && close == n) {
            result.add(current.toString());
            return;
        }

        // Choice 1: Add '('
        if (open < n) {

            current.append('(');

            generate(
                    open + 1,
                    close,
                    n,
                    current,
                    result
            );

            // Backtracking
            current.deleteCharAt(current.length() - 1);
        }

        // Choice 2: Add ')'
        if (close < open) {

            current.append(')');

            generate(
                    open,
                    close + 1,
                    n,
                    current,
                    result
            );

            // Backtracking
            current.deleteCharAt(current.length() - 1);
        }
    }

    public static void main(String[] args) {

        int n = 3;

        List<String> result = new ArrayList<>();

        generate(
                0,
                0,
                n,
                new StringBuilder(),
                result
        );

        System.out.println(result);
    }
}
