package dp.dp2;

public class MaxSquare {

    public static int maxSquare(int n, int m, int mat[][]){
        int[][] dp = new int[n][m];
        int mazSize = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0){
                    dp[i][j] = mat[i][j];
                } else if (mat[i][j] == 1) {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j],Math.min(dp[i][j - 1],dp[i - 1][j - 1]));
                } else {
                    dp[i][j] = 0;
                }
                mazSize = Math.max(mazSize,dp[i][j]);
            }
        }
        return mazSize;
    }

    public static void main(String[] args) {
        MaxSquare sol = new MaxSquare();
        int[][] mat = {
                {0}
        };

        int n = mat.length;
        int m = mat[0].length;

        int result = maxSquare(n, m, mat);

        System.out.println("Largest square size: " + result);
    }
}
