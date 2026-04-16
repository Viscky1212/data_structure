package dp;

public class CclimbStairs {

    public static int climbStairs(int n){
        //edge case
        if (n <= 2) return n;

        //dp[i] = number of way to reach step i
        int prev2 = 1; //way to reach step1
        int prev1 = 2; //way to reach step2

        for (int i = 3; i <= n; i++) {
            int curr = prev1 + prev2;

            //shift value
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;

    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(climbStairs(n)); // Output: 5
    }
}
