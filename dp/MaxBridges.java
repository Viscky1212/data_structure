package dp;

import java.util.Arrays;

//class Bridge {
//    int north;
//    int south;
//
//    Bridge(int n, int s) {
//        this.north = n;
//        this.south = s;
//    }
//}


public class MaxBridges {


    /**
     * Maximum Non-Overlapping Bridges
     *
     * Core insight: Sort pairs by north bank coordinate.
     * Two bridges are non-crossing iff their south coordinates
     * are also in strictly increasing order.
     * Problem reduces to LIS on south coordinates after sorting.
     *
     * Time:  O(n^2) — sort O(n log n) + LIS O(n^2)
     * Space: O(n)   — dp array
     */
    public int maxBridges(int[][] pairs) {
        if (pairs == null || pairs.length == 0) return 0;

        int n = pairs.length;

        // Step 1: Sort by north bank coordinate (pairs[i][0])
        // If north coordinates are equal, sort by south coordinate ascending
        // to avoid using two bridges with same north anchor
        Arrays.sort(pairs, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

        // Step 2: LIS on south bank coordinates (pairs[i][1])
        // dp[i] = max bridges ending at pair i (inclusive)
        int[] dp = new int[n];
        Arrays.fill(dp, 1); // every bridge is a valid chain of length 1

        int maxBridges = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // Bridge j can come before bridge i without crossing:
                // north[j] < north[i]  — guaranteed by sort
                // south[j] < south[i]  — strictly increasing, no overlap
                if (pairs[j][1] < pairs[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxBridges = Math.max(maxBridges, dp[i]);
        }

        return maxBridges;
    }


    public static void main(String[] args) {
        MaxBridges sol = new MaxBridges();

        int[][] pairs = {
                {6, 2},
                {4, 3},
                {2, 6},
                {1, 5}
        };

        System.out.println(sol.maxBridges(pairs)); // 2
    }
}
