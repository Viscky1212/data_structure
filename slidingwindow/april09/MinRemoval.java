package slidingwindow.april09;

import java.util.Arrays;

public class MinRemoval {

    public int minRemoval(int[] nums, int k){
        Arrays.sort(nums);
        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < nums.length; right++) {
            //shrink window if invalid
            while ((long) nums[right] > (long) nums[left] * k) left++;

            //valid window size
            maxLen = Math.max(maxLen, right - left + 1);
        }
        //minimum removal
        return nums.length - maxLen;
    }

    public static void main(String[] args) {
        MinRemoval sol = new MinRemoval();

        int[] nums1 = {2,1,5};
        System.out.println(sol.minRemoval(nums1, 2)); // ✅ 1

        int[] nums2 = {1,6,2,9};
        System.out.println(sol.minRemoval(nums2, 3)); // ✅ 2

        int[] nums3 = {4,6};
        System.out.println(sol.minRemoval(nums3, 2)); // ✅ 0
    }
}
