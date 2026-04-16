package dp;

public class FindMaxSum {

    public static int findMaxSum(int nums[], int n){
        //edge case
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        int prev2 = 0;  //dp[i - 2]
        int prev1= nums[0];  //dp[i - 1]

        for (int i = 1; i < n; i++) {
            int take = nums[i] + prev2; //rob current
            int skip = prev1;

            int curr = Math.max(take,skip);

            //shift window
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,1};
        System.out.println(findMaxSum(nums1, nums1.length)); // 4

        int[] nums2 = {2,7,9,3,1};
        System.out.println(findMaxSum(nums2, nums2.length)); // 12
    }
}
