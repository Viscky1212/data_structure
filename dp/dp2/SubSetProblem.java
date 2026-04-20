package dp.dp2;

public class SubSetProblem {

    public boolean isSubsetSum(int arr[], int sum){
        int n = arr.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int s = 1; s <= sum; s++) {
                dp[i][s] = dp[i - 1][s];

                if (arr[i - 1] <= s){
                    dp[i][s] = dp[i][s] || dp[i - 1][s - arr[i - 1]];
                }
            }
        }
        return dp[n][sum];
    }

    public static void main(String[] args) {
        SubSetProblem obj = new SubSetProblem();
        System.out.println(obj.isSubsetSum(new int[]{3, 34, 4, 12, 5, 2}, 9));   // true
        System.out.println(obj.isSubsetSum(new int[]{3, 34, 4, 12, 5, 2}, 30));  // false

    }
}
