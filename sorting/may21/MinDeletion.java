package sorting.may21;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinDeletion {

    public int minDeletion(String s, int k){
        int[] freq = new int[26];

        for (char ch : s.toCharArray()){
            freq[ch - 'a']++;
        }

        List<Integer> frequencies = new ArrayList<>();

        for (int count : freq){
            if (count > 0){
                frequencies.add(count);
            }
        }

        if (frequencies.size() <= k){
            return 0;
        }

        Collections.sort(frequencies);

        int remove = frequencies.size() - k;
        int deletions = 0;

        for (int i = 0; i < remove; i++) {
            deletions += frequencies.get(i);
        }

        return deletions;
    }

    public static void main(String[] args) {
        MinDeletion sol = new MinDeletion();
        System.out.println(sol.minDeletion("abc", 2));
        // Output: 1

        System.out.println(sol.minDeletion("aabb", 2));
        // Output: 0

        System.out.println(sol.minDeletion("yyyzz", 1));
        // Output: 2

        System.out.println(sol.minDeletion("abcd", 1));
        // Output: 3

        System.out.println(sol.minDeletion("aaaa", 1));
        // Output: 0
    }
}
