package dp.dp2;

import java.util.Scanner;

public class EggDrop {

    public int eggDrop(int n, int k){
     int[] dp = new int[n+ 1];
     int moves = 0;

     while (dp[n] < k){
         moves++;
         System.out.println("door : "+ k);
         System.out.println("Egg : "+ dp[n]);
         System.out.println("Moves Count : "+moves);
         for (int e = n; e >= 1; e--) {
             dp[e] = dp[e] + dp[e - 1] + 1;
             System.out.println("Egg drop per steps : "+dp[e]);
         }
     }
     return moves;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter total egg : ");
        int n = sc.nextInt();
        System.out.println("Enter total doors : ");
        int k = sc.nextInt();

        EggDrop sol = new EggDrop();
        System.out.println(sol.eggDrop(n, k));

        sc.close();
    }
}
