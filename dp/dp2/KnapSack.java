package dp.dp2;

import java.util.Scanner;

public class KnapSack {

    public static int knapSack(int w, int v[], int wt[], int n){
        int[][] dp = new int[n + 1][ w + 1];

        for (int i = 1; i <= n; i++) {
            for (int cap = 1; cap <= w; cap++) {
                if (wt[i - 1] <= cap){
                    dp[i][cap] = Math.max(dp[i -1][cap],
                            v[i - 1] + dp[i - 1][cap - wt[i - 1]]);
                } else {
                    dp[i][cap] = dp[i - 1][cap];
                }
            }
        }
        return dp[n][w];
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int n = sc.nextInt();
        System.out.println("Enter the target");
        int w = sc.nextInt();

        int[] values = new int[n];
        int[] weights = new int[n];

        for (int i = 0; i < n; i++) {
            values[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            weights[i] = sc.nextInt();
        }

        System.out.println(knapSack(w, values, weights, n));
        sc.close();
    }
}
