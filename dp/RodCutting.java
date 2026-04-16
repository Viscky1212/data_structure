package dp;

public class RodCutting {
    public static int cutRod(int price[], int n){
        int[] dp = new int[n + 1];

        for (int i = 0; i < n; i++) {
            for (int len = i + 1; len <= n ; len++) {
                dp[len] = Math.max(dp[len],price[i] + dp[len - (i + 1)]);
            }
        }
        return dp[n];
    }



    public static void main(String[] args) {
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
        int n = 8;

        System.out.println(cutRod(price, n)); // 22
    }
}
