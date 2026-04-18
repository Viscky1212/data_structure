package stringMatching;

import java.util.ArrayList;
import java.util.List;

public class CountCells {

    public int countCells(char[][] grid, String pattern){

        int m = grid.length;
        int n = grid[0].length;
        int total = m * n;

        char[] horizontal = new char[total];
        char[] vertical = new char[total];

        int idx = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                horizontal[idx++] = grid[i][j];
            }
        }

        idx = 0;

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                vertical[idx++] = grid[i][j];
            }
        }

        boolean[] horizontalCovered = markCovered(horizontal,pattern.toCharArray());
        boolean[] verticalCovered = markCovered(vertical,pattern.toCharArray());

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int hIndex = i * n + j;
                int  vIndex = j * m + i;

                if (horizontalCovered[hIndex] && verticalCovered[vIndex])count++;
            }
        }
        return count;
    }

    private boolean[] markCovered(char[] text, char[] pattern){
        int n = text.length;
        int m = pattern.length;
        boolean[] covered = new boolean[n];

        if (m > n) return covered;

        List<Integer> matches = kmpSearch(text,pattern);

        int[] diff = new int[ n + 1];
        for (int start : matches) {
            diff[start]++;
            if (start + m < diff.length) {
                diff[start + m]--;
            }
        }

        int running = 0;
        for (int i = 0; i < n; i++) {
            running += diff[i];
            covered[i] = running > 0;
        }
        return covered;


    }


    private List<Integer> kmpSearch(char[] text, char[] pattern){
        List<Integer> matches = new ArrayList<>();
        int[] lps = buildLPS(pattern);
        int i = 0;
        int j = 0;

        while (i < text.length){
            if (text[i] == pattern[j]){
                i++;
                j++;

                if (j == pattern.length){
                    matches.add(i - j);
                    j = lps[j - 1];
                }
            } else {
                if (j != 0){
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return matches;
    }

    private int[] buildLPS(char[] pattern){
        int[] lps = new int[pattern.length];
        int len = 0;
        int i = 1;

        while (i < pattern.length){
            if (pattern[i] == pattern[len]){
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0){
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    public static void main(String[] args) {
        CountCells sol = new CountCells();
        char[][] grid1 = {
                {'a', 'a', 'c', 'c'},
                {'b', 'b', 'b', 'c'},
                {'a', 'a', 'b', 'a'},
                {'c', 'a', 'a', 'c'},
                {'a', 'a', 'b', 'a'}
        };
        System.out.println(sol.countCells(grid1, "abaca")); // 1

        char[][] grid2 = {
                {'c', 'a', 'a', 'a'},
                {'a', 'a', 'b', 'a'},
                {'b', 'b', 'a', 'a'},
                {'a', 'a', 'b', 'a'}
        };
        System.out.println(sol.countCells(grid2, "aba")); // 4

        char[][] grid3 = {
                {'a'}
        };
        System.out.println(sol.countCells(grid3, "a")); // 1
    }
}
