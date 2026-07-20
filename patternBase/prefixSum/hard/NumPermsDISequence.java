package patternBase.prefixSum.hard;

public class NumPermsDISequence {

    public static int numPermsDISequence(String s) {
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            if (s.charAt(i - 1) == 'D') {
                for (int j = 0; j < i; j++) {
                    dp[i][j] = dp[i - 1][j + 1];
                }
            } else {
                for (int j = 0; j < i; j++) {
                    dp[i][j] = dp[i - 1][j];
                    if (j > 0) {
                        dp[i][j] += dp[i][j - 1];
                    }
                }
            }
        }

        int result = 0;
        for (int j = 0; j <= n; j++) {
            result += dp[n][j];
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "DID";
        int result = numPermsDISequence(s);
        System.out.println("Number of valid permutations: " + result);
    }
}
