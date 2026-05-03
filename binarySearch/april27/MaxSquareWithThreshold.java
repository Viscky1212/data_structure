package binarySearch.april27;

public class MaxSquareWithThreshold {

    public int maxSideLength(int[][] mat, int threshold) {

        int m = mat.length;
        int n = mat[0].length;

        // ✅ Use long to prevent overflow
        long[][] pre = new long[m + 1][n + 1];

        // Build prefix sum
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                pre[i][j] = mat[i - 1][j - 1]
                        + pre[i - 1][j]
                        + pre[i][j - 1]
                        - pre[i - 1][j - 1];
            }
        }

        int low = 1, high = Math.min(m, n);
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isValid(pre, mid, threshold, m, n)) {
                ans = mid;
                low = mid + 1; // try bigger
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    private boolean isValid(long[][] pre, int k, int threshold, int m, int n) {

        for (int i = k; i <= m; i++) {
            for (int j = k; j <= n; j++) {

                long sum = pre[i][j]
                        - pre[i - k][j]
                        - pre[i][j - k]
                        + pre[i - k][j - k];

                if (sum <= threshold) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {

        MaxSquareWithThreshold solution = new MaxSquareWithThreshold();
        // 🔹 Test Case 1
        int[][] mat1 = {
                {1, 1, 3, 2, 4, 3, 2},
                {1, 1, 3, 2, 4, 3, 2},
                {1, 1, 3, 2, 4, 3, 2}
        };
        int threshold1 = 4;

        int result1 = solution.maxSideLength(mat1, threshold1);
        System.out.println("Max square side length (Test 1): " + result1); // Expected: 2


        // 🔹 Test Case 2
        int[][] mat2 = {
                {2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2}
        };
        int threshold2 = 1;

        int result2 = solution.maxSideLength(mat2, threshold2);
        System.out.println("Max square side length (Test 2): " + result2); // Expected: 0


        // 🔹 Edge Case
        int[][] mat3 = {
                {5}
        };
        int threshold3 = 5;

        int result3 = solution.maxSideLength(mat3, threshold3);
        System.out.println("Max square side length (Test 3): " + result3); // Expected: 1
    }
}
