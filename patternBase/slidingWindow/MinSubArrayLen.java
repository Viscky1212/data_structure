package patternBase.slidingWindow;

public class MinSubArrayLen {
    private int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            System.out.println("Right: " + right + ", Sum: " + sum);

            while (sum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                System.out.println("minLength: " + minLength);
                sum -= nums[left];
                System.out.println("Left: " + left + ", Sum: " + sum);
                left++;
                System.out.println("Left after increment: " + left);
            }
        }

        System.out.println("Final minLength: " + minLength);

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        MinSubArrayLen sol = new MinSubArrayLen();
        int[] nums1 = {2, 3, 1, 2, 4, 3};
        int target1 = 7;
        System.out.println(sol.minSubArrayLen(target1, nums1));
        // Output: 2
//
//        int[] nums2 = {1, 4, 4};
//        int target2 = 4;
//        System.out.println(sol.minSubArrayLen(target2, nums2));
        // Output: 1

//        int[] nums3 = {1, 1, 1, 1, 1, 1, 1, 1};
//        int target3 = 11;
//        System.out.println(sol.minSubArrayLen(target3, nums3));
        // Output: 0
    }
}
