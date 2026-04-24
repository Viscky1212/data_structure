package stringMatching;

public class DeleteString {
    public int deleteString(String s) {
        int n = s.length();
        int[][] lcp = new int[n + 1][n + 1];
        int[] dp = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    lcp[i][j] = 1 + lcp[i + 1][j + 1];
                }
            }
        }

        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {
            dp[i] = 1; // delete the whole remaining string
            for (int len = 1; i + 2 * len <= n; len++) {
                if (lcp[i][i + len] >= len) {
                    dp[i] = Math.max(dp[i], 1 + dp[i + len]);
                }
            }
        }

        return dp[0];
    }


    public static void main(String[] args) {
        DeleteString sol = new DeleteString();
        String s1 = "abcabcdabc";
        System.out.println("Input: " + s1);
        System.out.println("Output: " + sol.deleteString(s1)); // 2

        String s2 = "aaabaab";
        System.out.println("Input: " + s2);
        System.out.println("Output: " + sol.deleteString(s2)); // 4

        String s3 = "aaaaa";
        System.out.println("Input: " + s3);
        System.out.println("Output: " + sol.deleteString(s3)); // 5
    }
}
