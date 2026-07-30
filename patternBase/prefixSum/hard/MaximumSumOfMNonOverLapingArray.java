package patternBase.prefixSum.hard;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.Arrays;

public class MaximumSumOfMNonOverLapingArray {
    private static final long NEG = Long.MIN_VALUE / 4;

    long[][] dp;
    long[] prefix;
    int[] nums;
    int n;
    int l, r;
    public int maxSumOfMNonOverlappingSubarrays(int[] nums, int m, int l, int r){
        this.nums = nums;
        this.n = nums.length;
        this.l = l;
        this.r = r;

        //prefix sum
        prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        //dp [index] [remaining]

        dp = new long[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Long.MIN_VALUE);
        }

        long ans = NEG;

        for (int take = 1; take < m; take++) {
            ans = Math.max(ans, solve(0, take));
        }
        return (int) ans;
    }

    private long solve(int index, int remaining) {
        if (remaining == 0) {
            return 0;
        }
        if (index >= n) {
            return NEG;
        }
        if (dp[index][remaining] != Long.MIN_VALUE) {
            return dp[index][remaining];
        }

        long ans = solve(index + 1, remaining);

        for (int len = l; len <= r; len++) {
            if (index + len <= n) {
                long sum = prefix[index + len] - prefix[index];
                ans = Math.max(ans, sum + solve(index + len, remaining - 1));
            }
        }

        dp[index][remaining] = ans;
        return ans;
    }
    public static void main(String[] args) {
        MaximumSumOfMNonOverLapingArray solver = new MaximumSumOfMNonOverLapingArray();

        int[] nums = {1, 2, 3, 4, 5, 6};
        int m = 2;
        int k = 2;
        int result = solver.maxSumOfMNonOverlappingSubarrays(nums, m, k, k);
        System.out.println("Maximum sum of " + m + " non-overlapping subarrays of length " + k + ": " + result);
    }
}
