package dp;

public class NCR {

    private static final int MOD = 1_000_000_007;

    public int nCr(int n, int r){
        //Edge cases
        if (r > n) return 0;
        if (r == 0 || r == n) return 1;

        //DP table
        int[][] dp = new int[n + 1][r + 1];

        //Build Pascal Triangle
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, r); j++) {
                //Base cases
                if (j == 0 || j == i){
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = (dp[i -1][j - 1] + dp[i -1][j]) % MOD;
                }
            }
        }
        return  dp[n][r];
    }

    public static void main(String[] args) {
        NCR sol = new NCR();
        System.out.println(sol.nCr(3, 2)); // 3
        System.out.println(sol.nCr(3, 5)); // 0
    }
}
