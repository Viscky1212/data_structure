package slidingwindow.april09;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxFrequency {

    public int maxFrequency(int[] nums, int k, int numOperations) {

        Arrays.sort(nums);
        int n = nums.length;

        int left = 0;
        int result = 1;

        for (int right = 0; right < n; right++) {

            // shrink window: ensure nums[right] - nums[left] ≤ k
            while (nums[right] - nums[left] > k) {
                left++;
            }

            int total = right - left + 1;

            // count how many already equal to nums[right]
            int same = 0;
            int target = nums[right];

            for (int i = left; i <= right; i++) {
                if (nums[i] == target) same++;
            }

            int possible = same + Math.min(numOperations, total - same);

            result = Math.max(result, possible);
        }

        return result;
    }


    public static void main(String[] args) {
        MaxFrequency sol = new MaxFrequency();

        int[] nums1 = {1,4,5};
        System.out.println(sol.maxFrequency(nums1, 1, 2)); // ✅ 2

        int[] nums2 = {5,11,20,20};
        System.out.println(sol.maxFrequency(nums2, 5, 1)); // ✅ 2
    }
}
