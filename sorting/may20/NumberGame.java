package sorting.may20;

import java.util.Arrays;

public class NumberGame {

    public int[] numberGame(int[] nums){
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i += 2) {
            int temp = nums[i];

            nums[i] = nums[i + 1];
            nums[i + 1] = temp;
        }
        return nums;
    }

    public static void main(String[] args) {
        NumberGame sol = new NumberGame();

        int[] nums1 = {5, 4, 2, 3};
        System.out.println(Arrays.toString(sol.numberGame(nums1)));
        // Output: [3, 2, 5, 4]

        int[] nums2 = {2, 5};
        System.out.println(Arrays.toString(sol.numberGame(nums2)));
        // Output: [5, 2]

    }
}
