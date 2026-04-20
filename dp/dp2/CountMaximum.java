package dp.dp2;

public class CountMaximum {

    public static long countMaximum(int arr[], int n){
        long[][] dp = new long[n][n];

        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {
                long x = (i + 2 <= j) ? dp[i + 2][j] : 0;
                long y = (i + 1 <= j - 1) ? dp[i + 1][j - 1] : 0;
                long z = (i <= j - 2) ? dp[i][j - 2] : 0;

                dp[i][j] = Math.max(
                        arr[i] + Math.min(x,y),
                        arr[j] + Math.min(y,z)
                );
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 7, 10};
        int n = arr.length;

        System.out.println(countMaximum(arr, n));
    }
}
