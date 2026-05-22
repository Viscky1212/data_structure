package sorting.may19;

import java.util.Arrays;
// sol : 1

public class LargestPerimeterTriangle {

    public int largestPerimeter(int[] nums){
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i--) {
            int a = nums[i - 2];
            int b = nums[i - 1];
            int c = nums[i];

            if (a + b > c){
                return a + b + c;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        LargestPerimeterTriangle sol = new LargestPerimeterTriangle();
        int[] nums1 = {2, 1, 2};
        System.out.println(sol.largestPerimeter(nums1));
        // Output: 5

        int[] nums2 = {1, 2, 1, 10};
        System.out.println(sol.largestPerimeter(nums2));
        // Output: 0

        int[] nums3 = {3, 6, 2, 3};
        System.out.println(sol.largestPerimeter(nums3));
        // Output: 8
    }


}
