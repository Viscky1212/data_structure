package two_pointer_problem.aprill01;

import java.util.Arrays;

public class NumSubseq {

    public int numSubseq(int[] nums, int target){
        int n = nums.length;
        int mod = 1_000_000_007;

        Arrays.sort(nums);

        int[] pow = new int[n];
        pow[0] = 1;
        for (int i = 1; i < n; i++) {
            pow[i] = (pow[i - 1] * 2) % mod;
        }

        int left = 0, right = n - 1;
        int count = 0;

        while (left <= right){
            if (nums[left] + nums[right] <= target){
                count = (count + pow[right -left]) % mod;
                left++;
            } else {
                right--;
            }
        }
        return count;
    }

//    public int numSubseq(int[] nums, int target){
//        int n = nums.length;
//        int mod = 1_000_000_007;
//
//        //Sort the array
//        Arrays.sort(nums);
//        int[] pow = new int[n];
//        pow[0] = 1;
//
//        for (int i = 1; i < n; i++) {
//            pow[i] = (pow[i - 1] * 2) % mod;
//        }
//
//        int left = 0, right = n - 1;
//        int count = 0;
//
//        //Two pinter Approach
//        while (left < right){
//            if (nums[left] + nums[right] <= target){
//                count = (count + pow[right - left]) % mod;
//                left++;
//            } else {
//                right--;
//            }
//        }
//        return count;
//    }

    public static void main(String[] args) {

        NumSubseq sol = new NumSubseq();
        // Example 1
        int[] nums1 = {3, 5, 6, 7};
        int target1 = 9;
        System.out.println("Example 1: " + sol.numSubseq(nums1, target1)); // Output: 4

        // Example 2
        int[] nums2 = {3, 3, 6, 8};
        int target2 = 10;
        System.out.println("Example 2: " + sol.numSubseq(nums2, target2)); // Output: 6

        // Example 3
        int[] nums3 = {2, 3, 3, 4, 6, 7};
        int target3 = 12;
        System.out.println("Example 3: " + sol.numSubseq(nums3, target3)); // Output: 61
    }
}
