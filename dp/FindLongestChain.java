package dp;

import java.util.Arrays;

public class FindLongestChain {

    public int findLongestChainDP(int[][] pairs){
        if (pairs == null || pairs.length == 0) return  0;

        int n = 0;

        Arrays.sort(pairs,(a,b) -> a[0] - b[0]);

        int[] dp = new int[n];
        Arrays.fill(dp,1);  //every pair is a chain of length 1
        int max = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                //(pair[j] -> (pair[i]) valid if pairs[j][1] < pairs[i][0])
                if (pairs[j][1] < pairs[i][0]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }

    public int findLongestChain(int[][] pairs){
        if (pairs == null || pairs.length == 0) return 0;

        //Sort by second element (end of pair) ascending
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int chainLen = 1;
        int lastEnd = pairs[0][1];

        for (int i = 1; i < pairs.length; i++) {
            //pairs[i] can follow last picked pair
            if (pairs[i][0] > lastEnd){
                chainLen++;
                lastEnd = pairs[i][1];
            }
        }

        return chainLen;
    }

    // ─────────────────────────────────────────────────────────────
    // Main — all test cases with dry runs
    // ─────────────────────────────────────────────────────────────
    public static void main(String[] args) {
        FindLongestChain sol = new FindLongestChain();

        // ── Example 1 ─────────────────────────────────────────────
        // Pairs: (5,24),(39,60),(15,28),(27,40),(50,90)
        // Chain: (5,24) → (27,40) → (50,90)  length = 3
        int[][] p1 = {{5,24},{39,60},{15,28},{27,40},{50,90}};
        int r1g = sol.findLongestChain(p1.clone());
        int r1d = sol.findLongestChainDP(p1.clone());
        System.out.println("=== Example 1 ===");
        System.out.println("Greedy: " + r1g + "  DP: " + r1d + "  expected: 3");
        System.out.println("PASS: " + (r1g == 3 && r1d == 3));
        System.out.println();

        // ── Example 2 ─────────────────────────────────────────────
        // Pairs: (5,10),(1,11)
        // Neither can follow the other (5<10, but 11 not < 5; 10 not < 1)
        // Max chain = 1
        int[][] p2 = {{5,10},{1,11}};
        int r2g = sol.findLongestChain(p2.clone());
        int r2d = sol.findLongestChainDP(p2.clone());
        System.out.println("=== Example 2 ===");
        System.out.println("Greedy: " + r2g + "  DP: " + r2d + "  expected: 1");
        System.out.println("PASS: " + (r2g == 1 && r2d == 1));
        System.out.println();

        // ── Edge: single pair ──────────────────────────────────────
        int[][] p3 = {{3, 7}};
        int r3 = sol.findLongestChain(p3.clone());
        System.out.println("=== Single pair ===");
        System.out.println("Greedy: " + r3 + "  expected: 1  PASS=" + (r3 == 1));
        System.out.println();

        // ── Edge: all pairs chain perfectly ───────────────────────
        // (1,2) → (3,4) → (5,6) → (7,8)  length = 4
        int[][] p4 = {{7,8},{1,2},{5,6},{3,4}};
        int r4g = sol.findLongestChain(p4.clone());
        int r4d = sol.findLongestChainDP(p4.clone());
        System.out.println("=== All chain perfectly ===");
        System.out.println("Greedy: " + r4g + "  DP: " + r4d + "  expected: 4");
        System.out.println("PASS: " + (r4g == 4 && r4d == 4));
        System.out.println();

        // ── Edge: no pair can follow any other ────────────────────
        // (1,10),(2,9),(3,8) — all overlapping
        int[][] p5 = {{1,10},{2,9},{3,8}};
        int r5g = sol.findLongestChain(p5.clone());
        int r5d = sol.findLongestChainDP(p5.clone());
        System.out.println("=== None chainable ===");
        System.out.println("Greedy: " + r5g + "  DP: " + r5d + "  expected: 1");
        System.out.println("PASS: " + (r5g == 1 && r5d == 1));
        System.out.println();

        // ── Edge: negative values ─────────────────────────────────
        // (-10,-5) → (-3,0) → (2,7)   length = 3
        int[][] p6 = {{-3,0},{2,7},{-10,-5}};
        int r6g = sol.findLongestChain(p6.clone());
        int r6d = sol.findLongestChainDP(p6.clone());
        System.out.println("=== Negative values ===");
        System.out.println("Greedy: " + r6g + "  DP: " + r6d + "  expected: 3");
        System.out.println("PASS: " + (r6g == 3 && r6d == 3));
        System.out.println();

        // ── Edge: touching (b == c) is NOT valid ──────────────────
        // (1,5),(5,10) — b=5 is NOT < c=5, so cannot chain
        int[][] p7 = {{1,5},{5,10}};
        int r7g = sol.findLongestChain(p7.clone());
        int r7d = sol.findLongestChainDP(p7.clone());
        System.out.println("=== Touching pairs (b==c, invalid chain) ===");
        System.out.println("Greedy: " + r7g + "  DP: " + r7d + "  expected: 1");
        System.out.println("PASS: " + (r7g == 1 && r7d == 1));
    }
}
