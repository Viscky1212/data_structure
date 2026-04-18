package stringMatching;

public class ShortestPalindrome {

    public String  shortestPalindrome(String s){
        String rev = new StringBuilder(s).reverse().toString();
        String combine = s + "#" + rev;

        int[] lps = buildLPS(combine);
        int longestPalPrefix = lps[combine.length() - 1];

        String suffix = s.substring(longestPalPrefix);
        String prefixToAdd = new StringBuilder(suffix).reverse().toString();
        return prefixToAdd + s;
    }

    private int[] buildLPS(String str){
        int[] lps = new int[str.length()];
        int len = 0;
        int i = 1;

        while (i < str.length()){
            if (str.charAt(i) == str.charAt(len)){
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
        ShortestPalindrome sol = new ShortestPalindrome();

        String s1 = "aacecaaa";
        System.out.println(sol.shortestPalindrome(s1)); // aaacecaaa

        String s2 = "abcd";
        System.out.println(sol.shortestPalindrome(s2)); // dcbabcd
    }
}
