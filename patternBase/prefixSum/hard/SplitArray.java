package patternBase.prefixSum.hard;

public class SplitArray {
//solution 1: DP
    public static int splitArray(int[] nums, int k) {

        int n = nums.length;

        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++)
            prefix[i + 1] = prefix[i] + nums[i];

        int[][] dp = new int[n + 1][k + 1];

        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= k; j++)
                dp[i][j] = Integer.MAX_VALUE;

        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= Math.min(i, k); j++) {

                for (int p = 0; p < i; p++) {

                    if (dp[p][j - 1] == Integer.MAX_VALUE)
                        continue;

                    int lastPart = prefix[i] - prefix[p];

                    dp[i][j] = Math.min(
                            dp[i][j],
                            Math.max(dp[p][j - 1], lastPart));
                }
            }
        }

        return dp[n][k];
    }



//    public static int splitArray(int[] nums, int m) {
//        int left = 0, right = 0;
//        for (int num : nums) {
//            left = Math.max(left, num);
//            right += num;
//        }
//
//        while (left < right) {
//            int mid = left + (right - left) / 2;
//            if (canSplit(nums, m, mid)) {
//                right = mid;
//            } else {
//                left = mid + 1;
//            }
//        }
//        return left;
//    }
//
//    private static boolean canSplit(int[] nums, int m, int maxSum) {
//        int count = 1, currentSum = 0;
//        for (int num : nums) {
//            if (currentSum + num > maxSum) {
//                count++;
//                currentSum = num;
//                if (count > m) {
//                    return false;
//                }
//            } else {
//                currentSum += num;
//            }
//        }
//        return true;
//    }

    public static void main(String[] args) {
        int[] nums = {7, 2, 5, 10, 8};
        int m = 2;
        int result = splitArray(nums, m);
        System.out.println("The minimum largest sum is: " + result);
    }
}
