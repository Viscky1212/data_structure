package binarySearch.april26;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NumberOfMatchingSubSequence {

    public int numMatchingSubseq(String s, String[] words) {

        //Step  1: create bucket for each character
        List<Queue<String>> buckets = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            buckets.add(new LinkedList<>());
        }

        //Step 2 : put words in bucket based on first char 
        for (String word : words) {
            buckets.get(word.charAt(0) - 'a').offer(word);
        }

        int count = 0;
        //Process String s

        // Step 3: Process string s
        for (char c : s.toCharArray()) {

            Queue<String> queue = buckets.get(c - 'a');
            int size = queue.size();

            // Process only current elements
            for (int i = 0; i < size; i++) {

                String word = queue.poll();

                if (word.length() == 1) {
                    count++; // matched
                } else {
                    // move to next bucket
                    String remaining = word.substring(1);
                    buckets.get(remaining.charAt(0) - 'a').offer(remaining);
                }
            }
        }
    return count;
}



    public static void main(String[] args) {
        NumberOfMatchingSubSequence sol = new NumberOfMatchingSubSequence();
        String s1 = "abcde";
        String[] words1 = {"a", "bb", "acd", "ace"};
        System.out.println(sol.numMatchingSubseq(s1, words1)); // Expected: 3

        String s2 = "dsahjpjauf";
        String[] words2 = {"ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax"};
        System.out.println(sol.numMatchingSubseq(s2, words2)); // Expected: 2
    }
}
