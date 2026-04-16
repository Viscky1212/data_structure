package slidingwindow.april09;

import java.util.Arrays;

public class MaximumBeauty {

    public int maximumBeauty(int[] nums, int k){
        //Step 1 : Sort the array
        Arrays.sort(nums);

        int left = 0;
        int maxBeauty = 0;

        //Step 2 : sliding window
        for (int right = 0; right < nums.length; right++) {
            //shrink window if condition break
            while (nums[right] - nums[left] > 2 * k){
                left++;
            }

            //update maximum window size
            maxBeauty = Math.max(maxBeauty, right - left + 1);
        }
        return maxBeauty;
    }

    public static void main(String[] args) {
        MaximumBeauty sol = new MaximumBeauty();

        int[] nums1 = {4, 6, 1, 2};
        int k1 = 2;
        System.out.println(sol.maximumBeauty(nums1, k1)); // Output: 3

        int[] nums2 = {1, 1, 1, 1};
        int k2 = 10;
        System.out.println(sol.maximumBeauty(nums2, k2)); // Output: 4
    }
}
