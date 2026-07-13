package patternBase.slidingWindow;

public class MinimumSubArrayLen {

    public int minSubArrayLen(int target, int[] nums){
        int left = 0;
        int windowSum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            windowSum += nums[right];

            while (windowSum >= target){
                minLength = Math.min(minLength,right - left + 1);

                windowSum -= nums[left];
                left++;
            }
        }

        if (minLength == Integer.MAX_VALUE){
            return 0;
        }
        return minLength;
    }

    public static void main(String[] args) {
        MinimumSubArrayLen sol = new MinimumSubArrayLen();
        int[] nums1 = {2, 3, 1, 2, 4, 3};
        int target1 = 7;
        System.out.println(sol.minSubArrayLen(target1, nums1));
        // Output: 2

        int[] nums2 = {1, 4, 4};
        int target2 = 4;
        System.out.println(sol.minSubArrayLen(target2, nums2));
        // Output: 1

        int[] nums3 = {1, 1, 1, 1, 1, 1, 1, 1};
        int target3 = 11;
        System.out.println(sol.minSubArrayLen(target3, nums3));
        // Output: 0
    }
}
