package stringMatching;

public class LongestPrefix {

    public String longestPrefix(String s){
        int n = s.length();
        int[] lps = new int[n];

        int len = 0;
        int i = 1;

        while (i < n){
            if (s.charAt(i) == s.charAt(len)){
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
        return s.substring(0,lps[n - 1]);
    }

    public static void main(String[] args) {
        LongestPrefix sol = new LongestPrefix();
        String s1 = "level";
        System.out.println("Input: " + s1);
        System.out.println("Output: " + sol.longestPrefix(s1)); // l

        String s2 = "ababab";
        System.out.println("Input: " + s2);
        System.out.println("Output: " + sol.longestPrefix(s2)); // abab
    }
}
