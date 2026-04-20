package dp.dp2;

public class UniquePath {

    static final int MOD = 1000000007;

    public int uniquePaths(int m, int n){
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = (int)(((long) dp[i - 1][j] + dp[i][j - 1]) % MOD);
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        UniquePath sol = new UniquePath();
        int m = 3;
        int n = 7;

        int result = sol.uniquePaths(m, n);

        System.out.println("Unique paths: " + result);
    }
}
