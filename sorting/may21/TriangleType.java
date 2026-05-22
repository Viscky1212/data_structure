package sorting.may21;

import java.util.Arrays;

public class TriangleType {

    public String triangleType(int[] nums){
        Arrays.sort(nums);

        int a = nums[0];
        int b = nums[1];
        int c = nums[2];

        if (a + b <= c){
            return "none";
        }

        if (a == b && b == c){
            return "equilateral";
        }

        if (a == b || b == c || a == c){
            return "isosceles";
        }

        return "scalene";
    }

    public static void main(String[] args) {
        TriangleType sol = new TriangleType();
        int[] nums1 = {3, 3, 3};
        System.out.println(sol.triangleType(nums1));
        // Output: equilateral

        int[] nums2 = {3, 4, 5};
        System.out.println(sol.triangleType(nums2));
        // Output: scalene

        int[] nums3 = {1, 2, 3};
        System.out.println(sol.triangleType(nums3));
        // Output: none

        int[] nums4 = {3, 3, 5};
        System.out.println(sol.triangleType(nums4));
        // Output: isosceles

        int[] nums5 = {1, 1, 2};
        System.out.println(sol.triangleType(nums5));
        // Output: none
    }
}
