package string_algo_tries;

public class LongestCommonPrefix {

    static class TrieNode{
        TrieNode[] children = new TrieNode[26];
        int freq = 0;
    }

    public String longestCommonPrefix(String arr[], int n){
        TrieNode root = new TrieNode();

        //insert for all
        for (String word : arr){
            TrieNode node = root;

            for (char c : word.toCharArray()){
                int i = c - 'a';
                if (node.children[i] == null) node.children[i] = new TrieNode();
                node = node.children[i];
                node.freq++;
            }
        }

        //Walk Trie - keep going while exactly n words pass through (all words share this char)
        StringBuilder prefix = new StringBuilder();
        TrieNode node = root;

        for (char c : arr[0].toCharArray()){
            int i = c - 'a';
            if (node.children[i] != null && node.children[i].freq == n){
                prefix.append(c);
                node = node.children[i];
            } else {
                break;
            }
        }

        return prefix.length() == 0 ? "-1" : prefix.toString();

    }

    public static void main(String[] args) {
        LongestCommonPrefix sol = new LongestCommonPrefix();
        System.out.println(sol.longestCommonPrefix(new String[]{"codable","code","coder","coding"}, 4)); // cod
        System.out.println(sol.longestCommonPrefix(new String[]{"hello","world"}, 2));                  // -1
        System.out.println(sol.longestCommonPrefix(new String[]{"flower","flow","flight"}, 3));         // fl
        System.out.println(sol.longestCommonPrefix(new String[]{"abc","abc","abc"}, 3));                // abc
    }
}
