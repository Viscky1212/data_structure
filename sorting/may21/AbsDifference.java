package sorting.may21;

import java.util.Arrays;

public class AbsDifference {

    public int absDifference(int[] nums, int k){
        Arrays.sort(nums);

        int n = nums.length;
        int smallestSum = 0;
        int largestSum = 0;

        for (int i = 0; i < k; i++) {
            smallestSum += nums[i];
            largestSum += nums[n - 1 - i];
        }
        return Math.abs(largestSum - smallestSum);
    }

    public static void main(String[] args) {
        AbsDifference sol = new AbsDifference();
        int[] nums1 = {5, 2, 2, 4};
        System.out.println(sol.absDifference(nums1, 2));
        // Output: 5

        int[] nums2 = {100};
        System.out.println(sol.absDifference(nums2, 1));
        // Output: 0

        int[] nums3 = {1, 2, 3};
        System.out.println(sol.absDifference(nums3, 3));
        // Output: 0

        int[] nums4 = {1, 100};
        System.out.println(sol.absDifference(nums4, 1));
        // Output: 99

        int[] nums5 = {5, 5, 5};
        System.out.println(sol.absDifference(nums5, 2));
        // Output: 0
    }
}
