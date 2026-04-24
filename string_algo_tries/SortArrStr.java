package string_algo_tries;

import java.util.ArrayList;

public class SortArrStr {

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    static TrieNode root;

   static public void insert(String word){
        TrieNode node = root;
        for (char c : word.toCharArray()){
            int i = c - 'a';
            if (node.children[i] == null) node.children[i] = new TrieNode();
            node = node.children[i];
        }
        node.isEnd = true;
    }

    static public void dfs(TrieNode node, StringBuilder sb, ArrayList<String> res){
        if (node.isEnd) res.add(sb.toString());
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null){
                sb.append((char) ('a' + i));
                dfs(node.children[i],sb,res);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public static ArrayList<String> sortArrStr(String[] arrStr, int n) {
        root = new TrieNode();
        for (String s : arrStr) {
            if (s != null && !s.isEmpty()) insert(s);
        }
        ArrayList<String> result = new ArrayList<>();
        dfs(root, new StringBuilder(), result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(sortArrStr(new String[]{"codable", "code", "coder", "coding"}, 4));
        // [codable, code, coder, coding]
        System.out.println(sortArrStr(new String[]{"hello", "world"}, 2));
        // [hello, world]
        System.out.println(sortArrStr(new String[]{"banana", "apple", "cherry", "apricot"}, 4));
        // [apple, apricot, banana, cherry]
    }
}
