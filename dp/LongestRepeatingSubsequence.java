package dp;

public class LongestRepeatingSubsequence {

    public int longestRepeatingSubsequence(String str){
        int n = str.length();

        //Step 1 : DP table
        int[][] dp= new int[n + 1][n + 1];

        //Step 2 : Build LCS with conditions i !== j
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                //match but indices must be different
                if (str.charAt(i - 1) == str.charAt(j - 1) && i != j){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[n][n];
    }


        // Main method for testing
        public static void main(String[] args) {
            LongestRepeatingSubsequence sol = new LongestRepeatingSubsequence();

            String str1 = "axxzxy";
            System.out.println("LRS Length: " + sol.longestRepeatingSubsequence(str1));

            String str2 = "axxxy";
            System.out.println("LRS Length: " + sol.longestRepeatingSubsequence(str2));

    }
}
