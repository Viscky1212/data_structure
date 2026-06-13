package patternBase.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringsKTarget {
//    private static int longestSubstringKDistinct(String s, int k) {
//        int left = 0;
//        int maxLength = 0;
//        int[] charCount = new int[256];
//        int distinctCount = 0;
//
//        for (int right = 0; right < s.length(); right++) {
//            char rightChar = s.charAt(right);
//            if (charCount[rightChar] == 0) {
//                distinctCount++;
//            }
//            charCount[rightChar]++;
//
//            while (distinctCount > k) {
//                char leftChar = s.charAt(left);
//                charCount[leftChar]--;
//                if (charCount[leftChar] == 0) {
//                    distinctCount--;
//                }
//                left++;
//            }
//
//            maxLength = Math.max(maxLength, right - left + 1);
//        }
//
//        return maxLength;
//    }


//    public static int longestSubstringKDistinct(String s, int k){
//        int left = 0;
//        int maxLength = -1;
//
//        Map<Character, Integer> charCountMap = new HashMap<>();
//
//        for (int right = 0; right < s.length(); right++){
//            char ch = s.charAt(right);
//            charCountMap.put(ch,charCountMap.getOrDefault(ch,0)+1);
//
//            while (charCountMap.size() > k){
//                char leftChar = s.charAt(left);
//
//                charCountMap.put(leftChar,charCountMap.get(leftChar)-1);
//                if (charCountMap.get(leftChar) == 0){
//                    charCountMap.remove(leftChar);
//                }
//                left++;
//            }
//            maxLength = Math.max(maxLength, right - left + 1);
//        }
//        return maxLength;
//    }

    public static int longestSubstringKDistinct(String s, int k) {

        int left = 0;
        int maxLength = -1;

        int[] freq = new int[26];
        int distinctCount = 0;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            if (freq[ch - 'a'] == 0) {
                distinctCount++;
            }

            freq[ch - 'a']++;

            while (distinctCount > k) {

                char leftChar = s.charAt(left);

                freq[leftChar - 'a']--;

                if (freq[leftChar - 'a'] == 0) {
                    distinctCount--;
                }

                left++;
            }

            // IMPORTANT: exactly k distinct chars
            if (distinctCount == k) {
                maxLength = Math.max(
                        maxLength,
                        right - left + 1
                );
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s = "aabacbebebe";
        int k = 3;

        System.out.println(longestSubstringKDistinct(s, k));
    }
}
