package patternBase.slidingWindow;

import java.util.Arrays;

public class PermutationInString {

    public static boolean checkInclusion(String s1, String s2){
        int[] s1Freq = new int[26];
        int[] windowFreq = new int[26];

        for (char ch : s1.toCharArray()){
            s1Freq[ch - 'a']++;
        }
        int windowSize = s1.length();
        for (int i = 0; i < s2.length(); i++) {
            windowFreq[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(s1Freq, windowFreq)) {
            return true;
        }

        for (int right = windowSize; right < s2.length(); right++){
            windowFreq[s2.charAt(right) - 'a']++;
            windowFreq[s2.charAt(right - windowSize) - 'a']--;

            if (Arrays.equals(s1Freq, windowFreq)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";

        System.out.println(checkInclusion(s1, s2)); // Output: true
    }
}
