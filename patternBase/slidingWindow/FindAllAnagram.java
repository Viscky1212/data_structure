package patternBase.slidingWindow;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class FindAllAnagram {

    public static List<Integer> findAnagrams(String s, String p){
        List<Integer> result = new Stack<>();
        if (p.length() > s.length()){
            return result;
        }
        int[] pFreq = new int[26];
        int[] windowFreq = new int[26];

        for (char ch : p.toCharArray()){
            pFreq[ch - 'a']++;
        }
        int windowSize = p.length();

        for (int i = 0; i < windowSize; i++) {
            windowFreq[s.charAt(i) - 'a']++;
        }

        if (Arrays.equals(pFreq,windowFreq)){
            result.add(0);
        }

        for (int right = windowSize; right < s.length(); right++) {
            windowFreq[s.charAt(right) - 'a']++;
            windowFreq[s.charAt(right - windowSize) - 'a']--;
            if (Arrays.equals(pFreq, windowFreq)) {
                result.add(right - windowSize + 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";

        System.out.println(findAnagrams(s, p));
    }
}
