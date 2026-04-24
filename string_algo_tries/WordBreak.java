package string_algo_tries;

import java.util.*;

public class WordBreak {

    static class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }


    public boolean wordBreak(String s, List<String> wordDict){

        TrieNode root = new TrieNode();

        for (String w : wordDict){
            TrieNode node = root;
            for (char c : w.toCharArray()){
                int i = c - 'a';
                if (node.children[i] == null) node.children[i] = new TrieNode();
                node = node.children[i];
            }
            node.isEnd = true;
        }

        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 0; i < n; i++) {
            if (!dp[i]) continue;
            TrieNode node = root;

            for (int j = i; j < n; j++) {
                int idx = s.charAt(j) - 'a';
                if (node.children[idx] == null) break;
                node = node.children[idx];
                if (node.isEnd) dp[j + 1] = true;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        WordBreak sol = new WordBreak();
        System.out.println(sol.wordBreak("leetcode", Arrays.asList("leet", "code")));          // true

        sol = new WordBreak();
        System.out.println(sol.wordBreak("applepenapple", Arrays.asList("apple", "pen")));     // true

        sol = new WordBreak();
        System.out.println(sol.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat"))); // false
    }
}
