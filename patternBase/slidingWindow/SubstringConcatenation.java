package patternBase.slidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringConcatenation {

    public static List<Integer> findSubstring(String s, String[] words){
        // Implementation of the sliding window algorithm to find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
        // This is a placeholder for the actual implementation.

        //Store final answer
        List<Integer> result = new ArrayList<>();

        //edge case
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        //length of each word
        int wordLength = words[0].length();

        //Total number of words
        int wordCount = words.length;

        //total length of valid substring
        int totalLength = wordLength * wordCount;

        /*
        build expected word frequency map
        example: words = ["foo", "bar"]
        expectedMap = { "foo": 1, "bar": 1 }
         */

        Map<String,Integer> expectedMap = new HashMap<>();
        for (String word : words) {
            expectedMap.put(word, expectedMap.getOrDefault(word, 0) + 1);
        }

        //Try every possible starting point in s
        for (int i = 0; i <= s.length() - totalLength; i++) {
            //Store words seen in current window
            Map<String,Integer> seen = new HashMap<>();

            int j = 0;
            //extract one words at a time from the current window
            while (j < wordCount) {

                /*
                calculate start index of the current word in the window
                example: i = 0, j = 1, wordLength = 3
                start = 0 + 1 * 3 = 3
                 */
                int wordStart = i + (j * wordLength);
                //extract the word from s
                String currentWord = s.substring(wordStart, wordStart + wordLength);

                //check if the word is in the expected map
                if (!expectedMap.containsKey(currentWord)) {
                    break; //current word is not in the expected words, break the loop
                }
                seen.put(currentWord, seen.getOrDefault(currentWord, 0) + 1);

                //check if the frequency of the current word exceeds the expected frequency
                if (seen.get(currentWord) > expectedMap.get(currentWord)) {
                    break; //current word frequency exceeds expected frequency, break the loop
                }
                j++;
            }

            //All words matched, add starting index to result
            if (j == wordCount) {
                result.add(i);
            }
        }
        return result; // Replace with actual return value after implementation
    }

    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        System.out.println(findSubstring(s, words)); // Output: [0, 9]
    }
}
