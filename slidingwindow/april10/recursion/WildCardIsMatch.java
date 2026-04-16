package slidingwindow.april10.recursion;

public class WildCardIsMatch{

    public boolean isMatch(String s, String p){
        int i = 0, j = 0;
        int starIdx = -1, match = 0;

        while (i < s.length()){
            //case 1 : match or '?'
            if (j < p.length() && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '?')){
                i++;
                j++;
            }
            //case 2 : '*'

            else if (j < p.length() && p.charAt(j) == '*') {
                starIdx = j;
                match = i;
                j++;
            }
            //case 3 : mismatch -> backtrack
            else if (starIdx != -1) {
                j = starIdx + 1;
                match++;
                i = match;
            }
            //case 4 : no match
            else {
                return false;
            }
        }
        //check remaining pattern
        while (j < p.length() && p.charAt(j) == '*'){
            j++;
        }
        return j == p.length();
    }


    public static void main(String[] args) {
        WildCardIsMatch sol = new WildCardIsMatch();

        System.out.println(sol.isMatch("aa", "a"));     // false
        System.out.println(sol.isMatch("aa", "*"));     // true
        System.out.println(sol.isMatch("cb", "?a"));    // false
        System.out.println(sol.isMatch("adceb", "*a*b"));// true
        System.out.println(sol.isMatch("acdcb", "a*c?b"));// false
    }
}
