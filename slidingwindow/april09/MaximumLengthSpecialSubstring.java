package slidingwindow.april09;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximumLengthSpecialSubstring {
    public int maximumLength(String s) {

        Map<Character, List<Integer>> map = new HashMap<>();

        int n = s.length();
        int i = 0;

        // Step 1: Build segments
        while (i < n) {
            char ch = s.charAt(i);
            int j = i;

            while (j < n && s.charAt(j) == ch) {
                j++;
            }

            int len = j - i;
            map.computeIfAbsent(ch, k -> new ArrayList<>()).add(len);

            i = j;
        }

        int result = -1;

        // Step 2: Try all lengths
        for (char ch : map.keySet()) {

            List<Integer> lengths = map.get(ch);

            for (int L = 1; L <= n; L++) {

                int count = 0;

                for (int len : lengths) {
                    if (len >= L) {
                        count += (len - L + 1);
                    }
                }

                // ✅ FIX: Only update if valid
                if (count >= 3) {
                    result = Math.max(result, L);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        MaximumLengthSpecialSubstring sol = new MaximumLengthSpecialSubstring();

        System.out.println(sol.maximumLength("aaaa"));   // 2
        System.out.println(sol.maximumLength("abcdef")); // -1
        System.out.println(sol.maximumLength("abcaba")); // 1
    }
}
