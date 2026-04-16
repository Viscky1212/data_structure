package slidingwindow.april09;

public class MaxProfit {


    public long maxProfit(int[] prices, int[] strategy, int k) {

        int n = prices.length;

        // Step 1: Base profit
        long baseProfit = 0;
        for (int i = 0; i < n; i++) {
            baseProfit += (long) strategy[i] * prices[i];
        }

        // Step 2: Build gain arrays
        long[] A = new long[n]; // first half
        long[] B = new long[n]; // second half

        for (int i = 0; i < n; i++) {
            A[i] = -(long) strategy[i] * prices[i];
            B[i] = (1L - strategy[i]) * prices[i];
        }

        // Step 3: Prefix sums
        long[] prefixA = new long[n + 1];
        long[] prefixB = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefixA[i + 1] = prefixA[i] + A[i];
            prefixB[i + 1] = prefixB[i] + B[i];
        }

        int half = k / 2;
        long maxGain = 0;

        // Step 4: Try all windows
        for (int i = 0; i + k <= n; i++) {

            int mid = i + half;
            int end = i + k;

            long gainFirst = prefixA[mid] - prefixA[i];
            long gainSecond = prefixB[end] - prefixB[mid];

            long totalGain = gainFirst + gainSecond;

            maxGain = Math.max(maxGain, totalGain);
        }

        // Step 5: Compare with no modification
        return Math.max(baseProfit, baseProfit + maxGain);
    }

    public static void main(String[] args) {
        MaxProfit sol = new MaxProfit();
        // Test Case 1
        int[] prices1 = {4, 2, 8};
        int[] strategy1 = {-1, 0, 1};
        int k1 = 2;

        System.out.println("Output 1: " +
                sol.maxProfit(prices1, strategy1, k1)); // Expected: 10


        // Test Case 2
        int[] prices2 = {5, 4, 3};
        int[] strategy2 = {1, 1, 0};
        int k2 = 2;

        System.out.println("Output 2: " +
                sol.maxProfit(prices2, strategy2, k2)); // Expected: 9


        // Test Case 3 (Edge Case)
        int[] prices3 = {10, 20, 30, 40};
        int[] strategy3 = {-1, -1, 1, 1};
        int k3 = 4;

        System.out.println("Output 3: " +
                sol.maxProfit(prices3, strategy3, k3));
    }
}
