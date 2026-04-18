package stringMatching;

import java.lang.reflect.Array;
import java.util.Arrays;

class  TrieNode{
    TrieNode[] children = new TrieNode[26];
}
public class MinValidStrings {

    public int minValidStrings(String[] words, String target){
        TrieNode root = buildTrie(words);
        int n = target.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            if (dp[i] == Integer.MAX_VALUE) continue;

            TrieNode node = root;

            for (int j = i; j < n; j++) {
                int idx = target.charAt(j) - 'a';
                if (node.children[idx] == null) break;;

                node = node.children[idx];

                dp[j + 1] = Math.min(dp[j + 1],dp[i] + 1);
            }
        }
        return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];

    }

    private TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();

        for (String word : words){
            TrieNode node = root;

            for (int i = 0; i < word.length(); i++) {
                int idx = word.charAt(i) - 'a';
                if (node.children[idx] == null){
                    node.children[idx] = new TrieNode();
                }
                node = node.children[idx];
            }
        }
        return root;
    }

    public static void main(String[] args) {
        MinValidStrings sol = new MinValidStrings();
        String[] words1 = {"abc", "aaaaa", "bcdef"};
        String target1 = "aabcdabc";
        System.out.println(sol.minValidStrings(words1, target1)); // 3

        String[] words2 = {"abababab", "ab"};
        String target2 = "ababaababa";
        System.out.println(sol.minValidStrings(words2, target2)); // 2

        String[] words3 = {"abcdef"};
        String target3 = "xyz";
        System.out.println(sol.minValidStrings(words3, target3)); // -1
    }
}
