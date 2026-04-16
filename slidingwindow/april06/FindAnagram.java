package slidingwindow.april06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAnagram {

    public List<Integer> findAnagrams(String s , String p){
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) return  res;

        int[] pFreq = new int[26];
        int[] windowFreq =  new int[26];

        //Build p frequency
        for (char c : p.toCharArray()) pFreq[c - 'a']++;

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            windowFreq[s.charAt(right) - 'a']++;

            //MainTain window size
            if (right - left + 1 > p.length()){
                windowFreq[s.charAt(left) - 'a']--;
                left++;
            }

            //check match
            if (Arrays.equals(pFreq,windowFreq)) res.add(left);
        }
        return res;
    }

    public static void main(String[] args) {
        FindAnagram sol = new FindAnagram();

        String s1 = "cbaebabacd";
        String p1 = "abc";

        String s2 = "abab";
        String p2 = "ab";

        System.out.println("Output 1: " + sol.findAnagrams(s1, p1)); // [0,6]
        System.out.println("Output 2: " + sol.findAnagrams(s2, p2)); // [0,1,2]
    }
}
