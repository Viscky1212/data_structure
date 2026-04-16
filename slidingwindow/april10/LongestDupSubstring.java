package slidingwindow.april10;

import java.util.*;

public class LongestDupSubstring {

    public String longestDupSubstring(String s){
        int n = s.length();

        int left = 0, right = n;

        String result = "";

        while (left <= right){
            int mid = left + (right - left)/ 2;
            String dup = search(s, mid);
            if (dup != null){
                result = dup;
                left = mid + 1; //try longer
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    public String search(String s, int len){
        long mod = (1L << 31) - 1;
        long base = 256;

        long hash = 0;
        long power = 1;

        // base^(len-1)
        for (int i = 0; i < len; i++) {
            power = (power * base) % mod;
        }

        Set<Long> seen = new HashSet<>();

        // initial hash
        for (int i = 0; i < len; i++) {
            hash = (hash * base + s.charAt(i)) % mod;
        }

        seen.add(hash);

        for (int i = len; i < s.length(); i++) {

            // remove left char
            hash = (hash * base - s.charAt(i - len) * power % mod + mod) % mod;

            // add new char
            hash = (hash + s.charAt(i)) % mod;

            if (seen.contains(hash)) {
                return s.substring(i - len + 1, i + 1);
            }

            seen.add(hash);
        }

        return null;

    }

    public static void main(String[] args) {
        LongestDupSubstring sol = new LongestDupSubstring();

        String s1 = "banana";
        System.out.println(sol.longestDupSubstring(s1)); // "ana"

        String s2 = "abcd";
        System.out.println(sol.longestDupSubstring(s2)); // ""
    }
}
