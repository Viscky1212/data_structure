package sorting.may19;

import java.util.Arrays;
import java.util.Map;

public class LargestSumAfterKNegations {

    public int largestSumAfterKNegations(int[] nums, int k){
        Arrays.sort(nums);

        for (int i = 0; i < nums.length && k > 0; i++) {
            if (nums[i] < 0){
                nums[i] = -nums[i];
                k--;
            }
        }

        int sum = 0;
        int minAbs = Integer.MAX_VALUE;

        for (int num : nums){
            sum += num;
            minAbs = Math.min(minAbs,Math.abs(num));
        }

        if (k % 2 == 1){
            sum -= 2 * minAbs;
        }

        return sum;
    }


    public static void main(String[] args) {
        LargestSumAfterKNegations sol = new LargestSumAfterKNegations();
        int[] nums1 = {4, 2, 3};
        System.out.println(sol.largestSumAfterKNegations(nums1, 1));
        // Output: 5

        int[] nums2 = {3, -1, 0, 2};
        System.out.println(sol.largestSumAfterKNegations(nums2, 3));
        // Output: 6

        int[] nums3 = {2, -3, -1, 5, -4};
        System.out.println(sol.largestSumAfterKNegations(nums3, 2));
        // Output: 13
    }
}
