package patternBase.recursionAndBackTracking.sheet.backtrack;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }
    private void backtrack(List<String> result, StringBuilder current, int open, int close, int max) {
        if (current.length() == max * 2) {
            result.add(current.toString());
            return;
        }

        if (open < max) {
            current.append("(");
            backtrack(result, current, open + 1, close, max);
            current.deleteCharAt(current.length() - 1); // backtrack
        }

        if (close < open) {
            current.append(")");
            backtrack(result, current, open, close + 1, max);
            current.deleteCharAt(current.length() - 1); // backtrack
        }
    }
    public static void main(String[] args) {
        GenerateParenthesis generator = new GenerateParenthesis();
        int n = 3; // Change this value to generate different numbers of parentheses
        List<String> result = generator.generateParenthesis(n);
        System.out.println("Generated parentheses: " + result);
    }
}
