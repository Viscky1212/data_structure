package stringMatching;

public class FindGoodStrings {

    private static final int MOD = 1_000_000_007;

    private int n;
    private String s1;
    private String s2;
    private String evil;
    private int m;
    private int[] lps;
    private int[][][][] dp;

    public int findGoodStrings(int n, String s1, String s2, String evil) {
        this.n = n;
        this.s1 = s1;
        this.s2 = s2;
        this.evil = evil;
        this.m = evil.length();

        buildLPS();

        dp = new int[n + 1][m + 1][2][2];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k < 2; k++) {
                    for (int l = 0; l < 2; l++) {
                        dp[i][j][k][l] = -1;
                    }
                }
            }
        }

        return dfs(0, 0, 1, 1);
    }

    private int dfs(int index, int matched, int tightLow, int tightHigh) {
        if (matched == m) {
            return 0;
        }

        if (index == n) {
            return 1;
        }

        if (dp[index][matched][tightLow][tightHigh] != -1) {
            return dp[index][matched][tightLow][tightHigh];
        }

        char from = tightLow == 1 ? s1.charAt(index) : 'a';
        char to = tightHigh == 1 ? s2.charAt(index) : 'z';

        long ways = 0;

        for (char ch = from; ch <= to; ch++) {
            int nextMatched = getNextMatched(matched, ch);
            int nextTightLow = (tightLow == 1 && ch == s1.charAt(index)) ? 1 : 0;
            int nextTightHigh = (tightHigh == 1 && ch == s2.charAt(index)) ? 1 : 0;

            ways += dfs(index + 1, nextMatched, nextTightLow, nextTightHigh);
            ways %= MOD;
        }

        dp[index][matched][tightLow][tightHigh] = (int) ways;
        return dp[index][matched][tightLow][tightHigh];
    }

    private int getNextMatched(int matched, char ch) {
        while (matched > 0 && evil.charAt(matched) != ch) {
            matched = lps[matched - 1];
        }

        if (evil.charAt(matched) == ch) {
            matched++;
        }

        return matched;
    }

    private void buildLPS() {
        lps = new int[m];
        int len = 0;
        int i = 1;

        while (i < m) {
            if (evil.charAt(i) == evil.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }

    public static void main(String[] args) {
        FindGoodStrings sol = new FindGoodStrings();

        int n1 = 2;
        String s1_1 = "aa";
        String s2_1 = "da";
        String evil1 = "b";
        System.out.println(sol.findGoodStrings(n1, s1_1, s2_1, evil1)); // 51

        int n2 = 8;
        String s1_2 = "leetcode";
        String s2_2 = "leetgoes";
        String evil2 = "leet";
        System.out.println(sol.findGoodStrings(n2, s1_2, s2_2, evil2)); // 0

        int n3 = 2;
        String s1_3 = "gx";
        String s2_3 = "gz";
        String evil3 = "x";
        System.out.println(sol.findGoodStrings(n3, s1_3, s2_3, evil3)); // 2
    }
}
