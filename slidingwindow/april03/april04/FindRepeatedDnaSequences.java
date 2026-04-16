package slidingwindow.april03.april04;

import java.util.*;

public class FindRepeatedDnaSequences {

    public List<String> findRepeatedDnaSequences(String s) {

        if (s.length() < 10) return new ArrayList<>();

        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 0);
        map.put('C', 1);
        map.put('G', 2);
        map.put('T', 3);

        Set<Integer> seen = new HashSet<>();
        Set<String> result = new HashSet<>();

        int hash = 0;

        for (int i = 0; i < s.length(); i++) {

            // Build rolling hash (20 bits)
            hash = ((hash << 2) | map.get(s.charAt(i))) & ((1 << 20) - 1);

            // Start checking after first 10 chars
            if (i >= 9) {
                if (!seen.add(hash)) {
                    // Directly add substring
                    result.add(s.substring(i - 9, i + 1));
                }
            }
        }

        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        FindRepeatedDnaSequences sol = new FindRepeatedDnaSequences();
        String s1 = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        String s2 = "AAAAAAAAAAAAA";

        System.out.println(sol.findRepeatedDnaSequences(s1));
        System.out.println(sol.findRepeatedDnaSequences(s2));
    }
}
