package patternBase.recursionAndBackTracking;

import java.util.*;

public class PhoneLetterCombinations {

    static final Map<Character, String> phone = new HashMap<>();

    static {
        phone.put('2', "abc");
        phone.put('3', "def");
        phone.put('4', "ghi");
        phone.put('5', "jkl");
        phone.put('6', "mno");
        phone.put('7', "pqrs");
        phone.put('8', "tuv");
        phone.put('9', "wxyz");
    }

    public static void generate(
            String s,
            int index,
            StringBuilder diary,
            List<String> result) {

        // Base case
        if (index == s.length()) {
            result.add(diary.toString());
            return;
        }

        // Get all choices for current digit
        String choices = phone.get(s.charAt(index));

        // Try every possible choice
        for (int i = 0; i < choices.length(); i++) {

            // Choose
            diary.append(choices.charAt(i));

            // Explore
            generate(
                    s,
                    index + 1,
                    diary,
                    result
            );

            // Undo / Backtrack
            diary.deleteCharAt(diary.length() - 1);
        }
    }

    public static void main(String[] args) {

        String s = "23";

        List<String> result = new ArrayList<>();

        generate(
                s,
                0,
                new StringBuilder(),
                result
        );

        System.out.println(result);
    }
}
