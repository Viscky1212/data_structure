package patternBase.kadanePattern;

public class MinSubArraySum {

//    public static int findMinSubArraySum(int[] nums) {
//        int minSum = Integer.MAX_VALUE;
//     //   System.out.println("Initial minSum: " + minSum);
//        int currentSum = 0;
//   //     System.out.println("Initial currentSum: " + currentSum);
//
//        for (int num : nums) {
//            currentSum += num;
//    //        System.out.println("Adding " + num + " to currentSum: " + currentSum);
//            minSum = Math.min(minSum, currentSum);
//            System.out.println("Current Sum: " + currentSum + ", Min Sum: " + minSum);
//            if (currentSum > 0) {
//                currentSum = 0;
//            }
//        }
//
//        return minSum;
//    }

    public static int findMinSubArraySum(int[] nums) {
        int currentSum = nums[0];
        int minSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.min(nums[i], currentSum + nums[i]);
            System.out.println("Adding " + nums[i] + " to currentSum: " + currentSum);
            minSum = Math.min(minSum, currentSum);
            System.out.println("Current Sum: " + currentSum + ", Min Sum: " + minSum);
        }

        return minSum;
    }
    public static void main(String[] args) {
        int[] nums = {3, -4, 2, -3, -1, 7, -5};
        int minSum = findMinSubArraySum(nums);
        System.out.println("Minimum subarray sum is: " + minSum);
    }
}
