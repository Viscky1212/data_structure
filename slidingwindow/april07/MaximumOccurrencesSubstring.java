package slidingwindow.april07;

import java.util.HashMap;
import java.util.Map;

public class MaximumOccurrencesSubstring {

    public static int maxFreq(String s, int maxLetters, int minSize, int maxSize){
        Map<String, Integer> map = new HashMap<>();

        int[] freq = new int[26];
        int unique = 0;
        int left = 0;
        int maxCount = 0;

        for (int right = 0; right < s.length(); right++) {
            //add character
            char ch = s.charAt(right);
            freq[ch - 'a']++;

            if (freq[ch - 'a'] == 1)unique++;

            //Maintain window size = minSize

            if (right - left + 1 > minSize ){
                char leftChar = s.charAt(left);
                freq[leftChar - 'a']--;

                if (freq[leftChar - 'a'] == 0) unique--;
                left++;
            }

            //when window size == minSize
            if (right - left + 1 == minSize){
                if (unique <= maxLetters){
                    String sub = s.substring(left, right + 1);
                    map.put(sub, map.getOrDefault(sub, 0) + 1);

                    maxCount = Math.max(maxCount, map.get(sub));
                }
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        String s1 = "aababcaab";
        int maxLetters1 = 2, minSize1 = 3, maxSize1 = 4;

        System.out.println("Result: " + maxFreq(s1, maxLetters1, minSize1, maxSize1));

        String s2 = "aaaa";
        System.out.println("Test Case 2: " + maxFreq(s2, 1, 3, 3));
    }
}
