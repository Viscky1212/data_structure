package two_pointer_problem.march31;
import java.util.*;

public class LastSubstring {

    public String lastSubstring(String s) {

        int n = s.length();
        int i = 0, j = 1, k = 0;

        while (j + k < n) {

            if (s.charAt(i + k) == s.charAt(j + k)) {
                k++;
            }
            else if (s.charAt(i + k) < s.charAt(j + k)) {
                i = i + k + 1;
                if (i <= j) i = j + 1;
                k = 0;
            }
            else {
                j = j + k + 1;
                k = 0;
            }
        }

        return s.substring(i);
    }

    public static void main(String[] args) {

        LastSubstring sol = new LastSubstring();

        String s1 = "abab";
        String s2 = "leetcode";
        String s3 = "aaaaa";

        System.out.println(sol.lastSubstring(s1)); // bab
        System.out.println(sol.lastSubstring(s2)); // tcode
        System.out.println(sol.lastSubstring(s3)); // aaaaa
    }
}