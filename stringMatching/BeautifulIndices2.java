package stringMatching;

import java.util.ArrayList;
import java.util.List;

public class BeautifulIndices2 {

    public List<Integer> beautifulIndices(String s, String a, String b, int k){
        List<Integer> aIndices = findOccurences(s,a);
        List<Integer> bIndices  = findOccurences(s,b);

        List<Integer> result = new ArrayList<>();
        int j = 0;

        for (int indexA : aIndices){
            while (j < bIndices.size() && bIndices.get(j) < indexA - k){
                j++;
            }
            if (j < bIndices.size() && Math.abs(bIndices.get(j) - indexA) <= k){
                result.add(indexA);
            }
        }
        return result;
    }

    private List<Integer> findOccurences(String text, String pattern){
        List<Integer> indices = new ArrayList<>();

        String combined = pattern + "#" + text;
        int[] lps = buildLPS(combined);
        int m = pattern.length();

        for (int i = m + 1; i < combined.length(); i++) {
            if (lps[i] == m){
                indices.add(i - 2 * m);
            }
        }
        return indices;
    }

    private int[] buildLPS(String str){
        int[] lps = new int[str.length()];
        int len = 0;

        for (int i = 1; i < str.length(); i++) {
            while (len > 0 && str.charAt(i) != str.charAt(len)){
                len = lps[len - 1];
            }

            if (str.charAt(i) == str.charAt(len)){
                len++;
                lps[i] = len;
            }
        }
        return lps;
    }

    public static void main(String[] args) {
        BeautifulIndices2 sol = new BeautifulIndices2();
        String s1 = "isawsquirrelnearmysquirrelhouseohmy";
        String a1 = "my";
        String b1 = "squirrel";
        int k1 = 15;
        System.out.println(sol.beautifulIndices(s1, a1, b1, k1)); // [16, 33]

        String s2 = "abcd";
        String a2 = "a";
        String b2 = "a";
        int k2 = 4;
        System.out.println(sol.beautifulIndices(s2, a2, b2, k2));
    }
}
