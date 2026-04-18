package stringMatching;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BeautifulIndices {

    public List<Integer> beautifulIndices(String s, String a, String b, int k){
        List<Integer> aIndices = findOcc(s,a);
        List<Integer> bIndices = findOcc(s,b);
        List<Integer> res = new ArrayList<>();


        int j = 0;

        for (int i : aIndices){
            while (j < bIndices.size() && bIndices.get(j) < i - k){
                j++;
            }

            if (j < bIndices.size() && Math.abs(bIndices.get(j) - i) <= k){
                res.add(i);
            }
        }
        return res;
    }

    private List<Integer> findOcc(String s, String pattern){
        List<Integer> indices = new ArrayList<>();

        for (int i = 0; i <=  s.length() - pattern.length(); i++) {
            if (s.substring(i, i + pattern.length()).equals(pattern)) {
                indices.add(i);
            }
        }
        return indices;
    }

    public static void main(String[] args) {
        BeautifulIndices sol = new BeautifulIndices();
        String s1 = "isawsquirrelnearmysquirrelhouseohmy";
        String a1 = "my";
        String b1 = "squirrel";
        int k1 = 15;
        System.out.println(sol.beautifulIndices(s1, a1, b1, k1)); // [16, 33]

        String s2 = "abcd";
        String a2 = "a";
        String b2 = "a";
        int k2 = 4;
        System.out.println(sol.beautifulIndices(s2, a2, b2, k2)); // [0]
    }
}
