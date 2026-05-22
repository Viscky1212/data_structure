package sorting.may21;

import java.util.Arrays;

public class TransformArray {

    public int[] transformArray(int[] nums){
        int evenCount = 0;

        for (int num : nums){
            if (num % 2 == 0){
                evenCount++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = i < evenCount ? 0 : 1;
        }
        return nums;
    }


    public static void main(String[] args) {
        TransformArray sol = new TransformArray();
        int[] nums1 = {4, 3, 2, 1};
        System.out.println(Arrays.toString(sol.transformArray(nums1)));
        // Output: [0, 0, 1, 1]

        int[] nums2 = {1, 5, 1, 4, 2};
        System.out.println(Arrays.toString(sol.transformArray(nums2)));
        // Output: [0, 0, 1, 1, 1]

        int[] nums3 = {2, 4, 6};
        System.out.println(Arrays.toString(sol.transformArray(nums3)));
        // Output: [0, 0, 0]

        int[] nums4 = {1, 3, 5};
        System.out.println(Arrays.toString(sol.transformArray(nums4)));
        // Output: [1, 1, 1]
    }
}
