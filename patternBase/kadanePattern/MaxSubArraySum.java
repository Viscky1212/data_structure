package patternBase.kadanePattern;

public class MaxSubArraySum {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            System.out.println("Current Sum: " + currentSum + ", Max Sum: " + maxSum);
            maxSum = Math.max(maxSum, currentSum);
            System.out.println("Updated Max Sum: " + maxSum);
        }

        return maxSum;
    }
    public static void main(String[] args) {
        MaxSubArraySum sol = new MaxSubArraySum();
       int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
      System.out.println(sol.maxSubArray(nums1)); // Output: 6
//
//        int[] nums2 = {1};
//        System.out.println(sol.maxSubArray(nums2)); // Output: 1
//
//        int[] nums3 = {5, 4, -1, 7, 8};
//        System.out.println(sol.maxSubArray(nums3)); // Output: 23

    //    int[] nums4 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    //    System.out.println(sol.maxValue(nums4)); // Output: 6
    }
}
//    public int maxValue (int[] nums) {
//
//        int maxSum = nums[0];
//        int currentSum = nums[0];
//
//        for (int i = 1; i < nums.length; i++) {
//            currentSum = Math.max(nums[i], currentSum + nums[i]);
//            System.out.println("Current Sum: " + currentSum + ", Max Sum: " + maxSum);
//            maxSum = Math.max(maxSum, currentSum);
//            System.out.println("Updated Max Sum: " + maxSum);
//        }
//
//        return maxSum;
//    }