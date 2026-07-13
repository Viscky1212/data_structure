package patternBase.slidingWindow;


//Hard level question most important question
// 76. Minimum Window Substring
// Given two strings s and t, return the minimum window in s which will contain all the characters in t. If there is no such window in s that covers all characters in t, return the empty string "".
public class MinimumWindowSubstring {
    public static String minWindow(String s, String t){
        int[] freq = new int[256];

        for (char ch : t.toCharArray()){
            freq[ch]++;
        }

        int required = t.length();
        int left = 0;
        int minLength = Integer.MAX_VALUE;
        int startIndex = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            if (freq[currentChar] > 0){
                required--;
            }

            freq[currentChar]--;

            while (required == 0){
                if (right - left + 1 < minLength){
                    minLength = right - left + 1;
                    startIndex = left;
                }

                char leftChar = s.charAt(left);
                freq[leftChar]++;

                if (freq[leftChar] > 0){
                    required++;
                }
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLength);
    }
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(minWindow(s, t)); // Output: "BANC"
    }
}
