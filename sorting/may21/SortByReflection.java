package sorting.may21;

import java.util.Arrays;

public class SortByReflection {

    public int[] sortByReflection(int[] nums){
        Integer[] boxed = new Integer[nums.length];

        for (int i = 0; i < nums.length; i++) {
            boxed[i] = nums[i];
        }

        Arrays.sort(boxed,(a,b) ->{
            int reflectionA = getReflection(a);
            int reflectionB = getReflection(b);

            if (reflectionA != reflectionB){
                return Integer.compare(reflectionA, reflectionB);
            }
            return Integer.compare(a,b);
        });

        for (int i = 0; i < nums.length; i++) {
            nums[i] = boxed[i];
        }
        return nums;
    }

    private int getReflection(int num){
        int reflected = 0;

        while (num > 0){
            int lastBit = num & 1;
            reflected = (reflected << 1) | lastBit;
            num >>= 1;
        }
        return reflected;
    }

    public static void main(String[] args) {
        SortByReflection sol = new SortByReflection();
        int[] nums1 = {4, 5, 4};
        System.out.println(Arrays.toString(sol.sortByReflection(nums1)));
        // Output: [4, 4, 5]

        int[] nums2 = {3, 6, 5, 8};
        System.out.println(Arrays.toString(sol.sortByReflection(nums2)));
        // Output: [8, 3, 6, 5]

        int[] nums3 = {2, 1};
        System.out.println(Arrays.toString(sol.sortByReflection(nums3)));
        // Output: [1, 2]
        // Reflection: 1 -> 1, 2 -> 1, tie by original value

        int[] nums4 = {7, 3};
        System.out.println(Arrays.toString(sol.sortByReflection(nums4)));
        // Output: [3, 7]
    }
}
