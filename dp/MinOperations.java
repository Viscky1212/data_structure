package dp;

public class MinOperations {


    public int minOperations(String s, String t){
        int n = s.length();
        int m = t.length();

        //Step 1: create DP table
        int[][] dp = new int[n + 1][m + 1];

        //Step 2 : Build LCS table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                if (s.charAt(i - 1) == t.charAt(j - 1)){
                    //Character match -> extends LCS
                    dp[i][j] = 1 + dp[i - 1][j - 1];

                } else{
                    //Take max of skipping either char
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]);
                }
            }
        }
        int lcs = dp[n][m];

        //calculate operations
        int deletions = n - lcs;
        int insertions = m - lcs;

        return deletions + insertions;
    }
    public static void main(String[] args) {

        MinOperations sol = new MinOperations();
        String s = "abcd";
        String t = "anc";

        System.out.println("Minimum operations: " + sol.minOperations(s, t));
    }
}
