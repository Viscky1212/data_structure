package dynamicProgramming.april30;

public class DiviserGame {

//    public boolean divisorGame(int n){
//        return n % 2 == 0;
//    }

    public boolean divisorGame(int n){

        boolean[] dp = new boolean[n + 1];
        dp[0] = false;
        dp[1] = false;

        for (int i = 2; i <= n; i++) {
            for (int x = 1; x < i; x++) {
                if (i % x == 0 && !dp[i - x]){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        DiviserGame sol = new DiviserGame();

        int[] testCases = {1, 2, 3, 4, 5, 6, 10};

        for (int n : testCases) {
            System.out.println("n = " + n + " → Alice wins? " + sol.divisorGame(n));
        }
    }
}
