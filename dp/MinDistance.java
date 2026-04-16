package dp;

public class MinDistance {

    public int minDistance(String S1, String S2){
        int n = S1.length();
        int m = S2.length();

        //DP Table
        int[][] dp = new int[n + 1][m + 1];

        //Base cases
        for (int i = 1; i <= n; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }

        //Fill DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (S1.charAt(i - 1) == S2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];  //no cost
                } else {
                    dp[i][j] = 1 + Math.min(
                            dp[i - 1][j],    //delete
                            Math.min(dp[i][j - 1], //insert
                                    dp[i - 1][j - 1] //replace
                            )
                    );
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        MinDistance sol = new MinDistance();

        System.out.println(sol.minDistance("horse", "ros")); // 3
        System.out.println(sol.minDistance("intention", "execution")); // 5
    }
}
