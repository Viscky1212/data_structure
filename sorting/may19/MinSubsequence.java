package sorting.may19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinSubsequence {

    public List<Integer> minSubsequence(int[] nums){
        Arrays.sort(nums);

        int totalSum = 0;

        for (int num : nums){
            totalSum += num;
        }

        List<Integer> result = new ArrayList<>();

        int selectedSum = 0;

        for (int i = nums.length - 1; i >= 0; i--) {
            selectedSum += nums[i];
            totalSum -= nums[i];

            result.add(nums[i]);

            if (selectedSum > totalSum){
                break;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        MinSubsequence sol = new MinSubsequence();
        int[] nums1 = {4, 3, 10, 9, 8};
        System.out.println(sol.minSubsequence(nums1));
        // Output: [10, 9]

        int[] nums2 = {4, 4, 7, 6, 7};
        System.out.println(sol.minSubsequence(nums2));
        // Output: [7, 7, 6]

        int[] nums3 = {6};
        System.out.println(sol.minSubsequence(nums3));
        // Output: [6]
    }
}
