package dp.dp2;

public class MinFallingPathSum {

    public int minFallingPathSum(int n, int[][] matrix) {
        int[][] dp = new int[n][n];

        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int up = dp[i - 1][j];
                int leftDiagonal = (j > 0) ? dp[i - 1][j - 1] : Integer.MAX_VALUE;
                int rightDiagonal = (j < n - 1) ? dp[i - 1][j + 1] : Integer.MAX_VALUE;

                dp[i][j] = matrix[i][j] + Math.min(up, Math.min(leftDiagonal, rightDiagonal));
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            ans = Math.min(ans, dp[n - 1][j]);
        }

        return ans;
    }

    public static void main(String[] args) {
        MinFallingPathSum sol = new MinFallingPathSum();
        int[][] matrix = {
                {2, 1, 3},
                {6, 5, 4},
                {7, 8, 9}
        };

        int n = matrix.length;

        int result = sol.minFallingPathSum(n, matrix);

        System.out.println("Minimum falling path sum: " + result);
    }
}
