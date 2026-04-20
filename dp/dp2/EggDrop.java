package dp.dp2;

import java.util.Scanner;

public class EggDrop {

    public int eggDrop(int n, int k){
     int[] dp = new int[n+ 1];
     int moves = 0;

     while (dp[n] < k){
         moves++;
         for (int e = n; e >= 1; e--) {
             dp[e] = dp[e] + dp[e - 1] + 1;
         }
     }
     return moves;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        EggDrop sol = new EggDrop();
        System.out.println(sol.eggDrop(n, k));

        sc.close();
    }
}
