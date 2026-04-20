package dp.dp2;

import java.util.HashSet;
import java.util.Set;

public class DistinctEchoSubstrings {

    public int distinctEchoSubstrings(String text){
        int n = text.length();
        Set<String> set = new HashSet<>();

        for (int len = 1; len <= n / 2 ; len++) {
            for (int i = 0; i + 2 * len <= n ; i++) {
                String first = text.substring(i, i + len);
                String second = text.substring(i + len, i + 2 * len);

                if (first.equals(second)) set.add(text.substring(i,i + 2 * len));
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        DistinctEchoSubstrings sol = new DistinctEchoSubstrings();
        String text = "abcabcabc";

        System.out.println(sol.distinctEchoSubstrings(text));
    }
}
