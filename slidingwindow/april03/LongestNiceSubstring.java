package slidingwindow.april03;

import java.util.HashSet;
import java.util.Set;

public class LongestNiceSubstring {

    public String longestNiceSubstring(String s){
        return helper(s);
    }

    private String helper(String s){
        //Base case
        if (s.length() < 2)return  "";

        //put all chars in set
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()){
            set.add(c);
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            //Check if both cases exist
            if (set.contains(Character.toLowerCase(c)) && set.contains(Character.toUpperCase(c))) continue;

            //split and recurse
            String left = helper(s.substring(0 , i));
            String right = helper(s.substring(i + 1));

            //return longer one
            return left.length() >= right.length() ? left : right;
        }

        //if whole string is nice
        return  s;

    }

    public static void main(String[] args) {
        LongestNiceSubstring sol = new LongestNiceSubstring();

        String s1 = "YazaAay";
        String s2 = "Bb";
        String s3 = "c";

        System.out.println("Result 1: " + sol.longestNiceSubstring(s1)); // aAa
        System.out.println("Result 2: " + sol.longestNiceSubstring(s2)); // Bb
        System.out.println("Result 3: " + sol.longestNiceSubstring(s3)); // ""
    }
}
