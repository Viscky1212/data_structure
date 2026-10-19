package patternBase.stack.octoberHashMap;

import java.util.*;

public class LongestPalindrome {
//    public int longestPalindrome(String s) {
//
//        int[] freq = new int[128];
//
//        for (char ch : s.toCharArray()) {
//            freq[ch]++;
//        }
//
//        int answer = 0;
//
//        for (int count : freq) {
//            answer += (count / 2) * 2;
//
//            if (count % 2 == 1 && answer % 2 == 0) {
//                answer++;
//            }
//        }
//
//        return answer;
//    }

    public int longestPalindrome(String s) {

        Map<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int answer = 0;
        boolean hasOdd = false;

        for (int count : map.values()) {

            answer += (count / 2) * 2;

            if (count % 2 == 1) {
                hasOdd = true;
            }
        }

        if (hasOdd) {
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        String input = "abccccdd";
        int result = longestPalindrome.longestPalindrome(input);
        System.out.println("Length of the longest palindrome that can be built: " + result); // Output: 7
    }
}
