package slidingwindow.april09;

import java.util.*;

public class MaximumLengthSpecialSubstringII {

    public int maximumLength(String s) {

        Map<Character, List<Integer>> map = new HashMap<>();

        int n = s.length();
        int i = 0;

        // Build segments
        while (i < n) {
            char ch = s.charAt(i);
            int j = i;

            while (j < n && s.charAt(j) == ch) j++;

            int len = j - i;
            map.computeIfAbsent(ch, k -> new ArrayList<>()).add(len);

            i = j;
        }

        int result = -1;

        // Process each character
        for (List<Integer> list : map.values()) {

            // Sort descending
            list.sort(Collections.reverseOrder());

            int size = list.size();

            // Case 1: single segment
            if (size >= 1) {
                int L1 = list.get(0);
                if (L1 >= 3) {
                    result = Math.max(result, L1 - 2);
                }
            }

            // Case 2: two segments
            if (size >= 2) {
                int L1 = list.get(0);
                int L2 = list.get(1);

                int candidate = Math.min(L1 - 1, L2);
                if (candidate > 0) {   // 🔥 FIX
                    result = Math.max(result, candidate);
                }
            }

            // Case 3: three segments
            if (size >= 3) {
                int L3 = list.get(2);
                if (L3 > 0) {
                    result = Math.max(result, L3);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        MaximumLengthSpecialSubstringII sol = new MaximumLengthSpecialSubstringII();

        System.out.println(sol.maximumLength("aaaa"));   // 2
        System.out.println(sol.maximumLength("abcdef")); // -1
        System.out.println(sol.maximumLength("abcaba")); // 1
        System.out.println(sol.maximumLength("jicja"));  // -1 ✅
    }
}