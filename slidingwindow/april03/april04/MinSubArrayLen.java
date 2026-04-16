package slidingwindow.april03.april04;

import java.util.Map;

public class MinSubArrayLen {

    public int minSubArrayLen(int target, int[] nums){
        int left = 0;
        int sum = 0;
        int minLeft = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {

            sum += nums[right];

            //shrink window when condition satisfied
            while (sum >= target){
                minLeft = Math.min(minLeft,right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return minLeft == Integer.MAX_VALUE ? 0 : minLeft;
    }

    public static void main(String[] args) {
        MinSubArrayLen sol = new MinSubArrayLen();
        int[] nums1 = {2,3,1,2,4,3};
        int target1 = 7;

        int[] nums2 = {1,4,4};
        int target2 = 4;

        int[] nums3 = {1,1,1,1,1,1,1,1};
        int target3 = 11;

        System.out.println(sol.minSubArrayLen(target1, nums1)); // 2
        System.out.println(sol.minSubArrayLen(target2, nums2)); // 1
        System.out.println(sol.minSubArrayLen(target3, nums3)); // 0
    }
}
