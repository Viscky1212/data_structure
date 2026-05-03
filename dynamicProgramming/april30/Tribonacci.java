package dynamicProgramming.april30;

public class Tribonacci {

//    public int tribonacci(int n){
//        if (n == 0) return 0;
//        if (n == 1 || n == 2) return 1;
//
//        int a = 0, b = 1, c = 1;
//        for (int i = 3; i <= n; i++) {
//            int d = a + b + c;
//            a = b;
//            b = c;
//            c = d;
//        }
//        return c;
//    }

    //DP version
    public int tribonacci(int n){
        if (n == 0) return 0;
        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1;
        if (n >= 2) dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i  - 2] + dp[i - 3];
        }
        return dp[n];
    }

    public static void main(String[] args) {

        Tribonacci sol = new Tribonacci();

        System.out.println(sol.tribonacci(4));   // 4
        System.out.println(sol.tribonacci(25));  // 1389537
        System.out.println(sol.tribonacci(0));   // 0
        System.out.println(sol.tribonacci(1));   // 1
    }
}
