package dp.dp2;

public class FindLength {

    public int findLength(int[] A, int[] B){
        int n = A.length;
        int m = B.length;
        int[][] dp = new int[n + 1][m + 1];
        int maxLen = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (A[i] == B[j]){
                    System.out.println("[A] : " + A[i]);
                    System.out.println("[B] : " + B[i]);
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                    System.out.println("hexographical view : "+dp[i][j]);
                    maxLen = Math.max(maxLen,dp[i][j]);
                    System.out.println("Maximum length :"+maxLen);

                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        FindLength sol = new FindLength();
        int[] A = {1, 2, 3, 2, 1};
        int[] B = {3, 2, 1, 4, 7};

        System.out.println(sol.findLength(A, B));
    }
}
