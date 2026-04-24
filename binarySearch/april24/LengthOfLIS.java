package binarySearch.april24;

public class LengthOfLIS {

    public int lengthOfLIS(int[] nums){
        int n = nums.length;
        int[] dp = new int[n];
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen,dp[i]);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LengthOfLIS solution = new LengthOfLIS();

        int[] nums1 = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(solution.lengthOfLIS(nums1)); // 4

        int[] nums2 = {0, 1, 0, 3, 2, 3};
        System.out.println(solution.lengthOfLIS(nums2)); // 4

        int[] nums3 = {7, 7, 7, 7, 7, 7, 7};
        System.out.println(solution.lengthOfLIS(nums3)); // 1
    }
}
