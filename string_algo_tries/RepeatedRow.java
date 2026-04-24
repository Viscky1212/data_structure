package string_algo_tries;

import java.util.ArrayList;

public class RepeatedRow {

    static  class TrieNode{
        TrieNode[] children = new TrieNode[2];
        boolean isEnd = false;
    }

    static boolean insert(TrieNode root, int[] row){
        TrieNode  node = root;
        for (int bit  : row){
            if (node.children[bit] == null) node.children[bit] = new TrieNode();
            node = node.children[bit];
        }
        if (node.isEnd) return true;
        node.isEnd = true;
        return false;
    }

    public static ArrayList<Integer> repeatedRows(int matrix[][], int m,int n){
        TrieNode root = new TrieNode();
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            if (insert(root, matrix[i])) res.add(i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(repeatedRows(new int[][]{{1,0},{1,0}}, 2, 2));
        // [1]

        System.out.println(repeatedRows(new int[][]{{1,0,0},{1,0,0},{0,0,0},{0,0,0}}, 4, 3));
        // [1, 3]

        System.out.println(repeatedRows(new int[][]{{0,0},{0,1},{1,0},{0,0},{1,0}}, 5, 2));
        // [3, 4]
    }
}
