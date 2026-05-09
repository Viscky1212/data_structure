package hashtable.may03;

import java.util.ArrayList;
import java.util.List;

public class CommonChars {

    public List<String> commonChars(String[] words) {

        int[] freq = new int[26];

        // Step 1: initialize with first word
        for (char ch : words[0].toCharArray()) {
            freq[ch - 'a']++;
        }

        // Step 2: process remaining words
        for (int i = 1; i < words.length; i++) {

            int[] curr = new int[26];

            for (char ch : words[i].toCharArray()) {
                curr[ch - 'a']++;
            }

            for (int j = 0; j < 26; j++) {
                freq[j] = Math.min(freq[j], curr[j]);
            }
        }

        // Step 3: build result
        List<String> result = new ArrayList<>();

        for (int i = 0; i < 26; i++) {

            while (freq[i] > 0) {
                result.add(String.valueOf((char) (i + 'a')));
                freq[i]--;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        CommonChars sol = new CommonChars();

        String[] words1 = {"bella","label","roller"};
        System.out.println(sol.commonChars(words1));
        // [e, l, l]

        String[] words2 = {"cool","lock","cook"};
        System.out.println(sol.commonChars(words2));
        // [c, o]
    }
}
