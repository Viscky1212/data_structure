package slidingwindow.april10.recursion;

public class IsMatch {

    public boolean isMatch(String s, String p){
        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m + 1][n + 1];

        //Base Case
        dp[0][0] = true;

        //Handle pattern like a*, a*b*, a*b*c*

        for (int j = 2; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }


        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);

                //case 1 : direct match or '.'
                if (pc == sc || pc == '.'){
                    dp[i][j] = dp[i - 1][j - 1];
                }

                else if (pc == '*') {

                    // Zero occurrence
                    dp[i][j] = dp[i][j - 2];

                    char prev = p.charAt(j - 2);

                    // One or more occurrence
                    if (prev == sc || prev == '.') {
                        dp[i][j] |= dp[i - 1][j];
                    }
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        IsMatch sol = new IsMatch();

        System.out.println(sol.isMatch("aa", "a"));     // false
        System.out.println(sol.isMatch("aa", "a*"));    // true
        System.out.println(sol.isMatch("ab", ".*"));    // true
        System.out.println(sol.isMatch("aab", "c*a*b"));// true
    }
}
