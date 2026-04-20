package dp.dp2;

public class MinDeletions {

    public int minDeletions(int arr[], int n){
        int[] dp = new int[n];
        int lis = 1;

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
            lis = Math.max(lis,dp[i]);
        }
        return n - lis;
    }

    public static void main(String[] args) {
        MinDeletions sol = new MinDeletions();
        int[] arr = {5, 6, 1, 7, 4};
        int n = arr.length;

        int result = sol.minDeletions(arr, n);

        System.out.println("Minimum deletions needed: " + result);
    }
}
