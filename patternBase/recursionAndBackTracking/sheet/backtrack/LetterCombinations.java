package patternBase.recursionAndBackTracking.sheet.backtrack;

import java.util.*;

public class LetterCombinations {
    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        if(digits == null || digits.length() == 0){
            return result;
        }

        String[] map = {
                "", "", "abc", "def", "ghi",
                "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        backtrack(digits, 0, new StringBuilder(), map, result);

        return result;
    }

    private void backtrack(String digits, int index, StringBuilder current, String[] map, List<String> result){

        //Base case
        if(index == digits.length()){
            result.add(current.toString());
            return;
        }

        //Get Letters for current digits
        String letters = map[digits.charAt(index) - '0'];

        for(char ch : letters.toCharArray()){

            //choose
            current.append(ch);

            //Explore next digits
            backtrack(digits, index + 1, current, map, result);

            //Undo choice
            current.deleteCharAt(current.length() - 1);
        }
    }

    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        String digits = "23"; // Change this value to test different digit combinations
        List<String> result = letterCombinations.letterCombinations(digits);
        System.out.println("Letter combinations for digits " + digits + ": " + result);
    }
}
