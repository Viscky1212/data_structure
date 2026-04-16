package slidingwindow.april06;

public class MaximumLengthRepeatedSubarray {

    //Optimized DP Solution
    public int findLength(int[] nums1, int[] nums2){
        int n = nums1.length;
        int m = nums2.length;

        //DP table
        int[][] dp = new int[n + 1][m + 1];
        int maxLength =0;
        //Build DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (nums1[i - 1] == nums2[j - 1]){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                // update max
                    maxLength = Math.max(maxLength, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return maxLength;
    }

    //Space optimized DP(1D Array)
    public int findLengthOptimized(int[] nums1, int[] nums2){
        int n = nums1.length;
        int m = nums2.length;

        int[] dp = new int[m + 1];
        int maxLength = 0;
        for (int i = 1; i <= n; i++) {
            int prev = 0;  //dp[i -1] [j - 1]

            for (int j = 1; j <= m ; j++) {
                int temp = dp[j];

                if (nums1[i - 1] == nums2[j - 1]){
                    dp[j] = 1 + prev;
                    maxLength = Math.max(maxLength,dp[j]);
                } else {
                    dp[j] = 0;
                }
                prev = temp;
            }
        }
        return maxLength;
    }


    //Brite force (for understanding )
    public int bruteForce(int[] nums1, int[] nums2){
        int max = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {

                int k = 0;
                while (i + k < nums1.length && j + k < nums2.length
                && nums1[i + k] == nums2[j + k]){
                    k++;
                }
                max = Math.max(max, k);
            }
        }
        return max;

    }

    public static void main(String[] args) {
        MaximumLengthRepeatedSubarray sol = new MaximumLengthRepeatedSubarray();
        int[] nums1 = {1, 2, 3, 2, 1};
        int[] nums2 = {3, 2, 1, 4, 7};

        System.out.println("DP Result: " + sol.findLength(nums1, nums2));
        System.out.println("Optimized DP Result: " + sol.findLengthOptimized(nums1, nums2));
        System.out.println("Brute Force Result: " + sol.bruteForce(nums1, nums2));

        // Test Case 2
        int[] a = {0, 0, 0, 0, 0};
        int[] b = {0, 0, 0, 0, 0};

        System.out.println("Test Case 2: " + sol.findLength(a, b));
    }
}
