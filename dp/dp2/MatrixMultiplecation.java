package dp.dp2;

public class MatrixMultiplecation {

    public int matrixMultiplication(int arr[], int N){
        int[][] dp = new int[N][N];

        for (int len = 2; len < N; len++) {
            for (int i = 1; i < N - len + 1; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + arr[i - 1] * arr[k] * arr[j];
                    dp[i][j] = Math.min(dp[i][j],cost);
                }
            }
        }
        return dp[1][N - 1];
    }

    public static void main(String[] args) {
        MatrixMultiplecation sol = new MatrixMultiplecation();
        int[] arr = {40, 20, 30, 10, 30};
        int N = arr.length;

        System.out.println(sol.matrixMultiplication(arr, N));
    }
}
