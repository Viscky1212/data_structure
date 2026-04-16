package dp;

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2){
        int n = text1.length();
        int m = text2.length();

        //create dp table
        int[][] dp = new int[n + 1][m + 1];

        //Step 2 : Fill dp table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)){
                    //match case
                    dp[i][j] = 1 + dp[i -1][j - 1];
                } else {
                    //skip one character
                    dp[i][j] = Math.max(dp[i  - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        LongestCommonSubsequence sol = new LongestCommonSubsequence();
        System.out.println(sol.longestCommonSubsequence("abc", "abc"));        // 3
        System.out.println(sol.longestCommonSubsequence("abcdgh", "aedfhr"));  // 3
    }
}
