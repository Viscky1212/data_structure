package patternBase.prefixSum;

import java.util.Arrays;

public class PrefixSumDemo {
//    public static int[] computePrefixSum(int[] nums) {
//        int n = nums.length;
//        int[] prefixSum = new int[n + 1]; // prefixSum[0] = 0
//        for (int i = 0; i < n; i++) {
//            prefixSum[i + 1] = prefixSum[i] + nums[i];
//        }
//        return prefixSum;
//    }
//
//    public static void main(String[] args) {
//        int[] nums = {2, 4, 1, 7, 3};
//        int[] prefixSum = computePrefixSum(nums);
//        System.out.print("Prefix Sum Array: ");
//        for (int sum : prefixSum) {
//            System.out.print(sum + " ");
//        }
//        System.out.println();
//    }


    public static void main(String[] args) {
        int[] nums = {2, 4, 1, 7, 3};
        int n = nums.length;
        int[] prefixSum = new int[n]; // prefixSum[0] = 0
        prefixSum[0] = nums[0]; // Initialize the first element of prefixSum with the first element of nums
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        System.out.println("Prefix Sum Array: " + Arrays.toString(prefixSum));
        System.out.println(Arrays.binarySearch(prefixSum, 7));
       int l = 1, r = 3; // Example range [l, r]
        int rangeSum = (l == 0) ? prefixSum[r] : prefixSum[r] - prefixSum[l - 1]; // Calculate the sum of elements from index l to r
        System.out.println("Sum of elements from index " + l + " to " + r + " is: " + rangeSum);
//        int rangeSum = prefixSum[r] - prefixSum[l - 1]; // Calculate the sum of elements from index l to r
//        System.out.println("Sum of elements from index " + l + " to " + r + " is: " + rangeSum);

    }
}
