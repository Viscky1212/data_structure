package patternBase.slidingWindow;

public class LongestOnes {

    public static int longestOnes(int[] nums, int k) {
        int left = 0;
        int maxLength = 0;
        int zeroCount = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeroCount++;
            }

            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k1 = 2;
        System.out.println(longestOnes(nums1, k1)); // Output: 6

        int[] nums2 = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0};
        int k2 = 3;
        System.out.println(longestOnes(nums2, k2)); // Output: 10
    }
}
