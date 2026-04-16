package dp;

public class NumberOfWays {

    public static Long numberOfWays(int N){
        //MOD value
        long MOD = 1000000007;

        //Base case
        if(N == 1) return 1L;
        if (N == 2) return 2L;

        long prev2 = 1; //dp[1]
        long prev1 = 2; //dp[2]

        for (int i = 3; i <= N; i++) {
            long curr = (prev1 + prev2) % MOD;

            //shift window
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

    public static void main(String[] args) {

        int n = 4;
        System.out.println(numberOfWays(n)); // Output: 5
    }
}
