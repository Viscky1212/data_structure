package string_algo_tries;

import java.util.ArrayList;
import java.util.List;

public class FindKfrequentWords {

    static class TrieNode{
        TrieNode[] children = new TrieNode[26];
        int freq = 0;
        boolean isEnd = false;
    }

    static void insert(TrieNode root, String word){
        TrieNode node = root;
        for (char c : word.toCharArray()){
            int i = c - 'a';
            if (node.children[i] == null) node.children[i] = new TrieNode();
            node = node.children[i];
        }
        node.isEnd = true;
        node.freq++;
    }

    static void dfs(TrieNode node, StringBuilder sb, List<int[]> freqIndex, List<String> words){
        if (node.isEnd){
            freqIndex.add(new int[]{node.freq,words.size()});
            words.add(sb.toString());
        }
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null){
                sb.append((char) ('a' + i));
                dfs(node.children[i],sb,freqIndex,words);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public static List<String> findKfrequentWords(String[] dict, int k){
        TrieNode root = new TrieNode();

        for (String w : dict){
            if (w != null && !w.isEmpty()) insert(root,w);
        }

        List<String> words = new ArrayList<>();
        List<int[]> freqIndex = new ArrayList<>();
        dfs(root,new StringBuilder(),freqIndex,words);

        freqIndex.sort((a,b) -> a[0] != b[0] ? b[0] - a[0] : a[1] - b[1]);

        List<String> res = new ArrayList<>();
        for (int i = 0; i < k && i < freqIndex.size(); i++) {
            res.add(words.get(freqIndex.get(i)[1]));
        }
        return res;
    }


    public static void main(String[] args) {
        String[] dict = {"code","coder","coding","codable","codec","codecs","coded","codeless",
                "codec","codecs","codependence","codex","codify","codependents","codes",
                "code","coder","codesign","codec","codeveloper","codrive","codec",
                "codecs","codiscovered"};
        System.out.println(findKfrequentWords(dict, 4)); // [codec, codecs, code, coder]
        System.out.println(findKfrequentWords(new String[]{"hello","world","hello"}, 1)); // [hello]
        System.out.println(findKfrequentWords(new String[]{"a","b","a","b","c"}, 2)); // [a, b]
    }
}
