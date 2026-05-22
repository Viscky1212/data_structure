package sorting.may20;

public class MaxProductDifference {
//sol : 4
    public int maxProductDifference(int[] nums){
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for(int num : nums){
            if (num > max1){
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max2 = num;
            }

            if (num < min1){
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }

        return (max1 * max2) - (min1 * min2);
    }

    public static void main(String[] args) {
        MaxProductDifference sol = new MaxProductDifference();
        int[] nums1 = {5, 6, 2, 7, 4};
        System.out.println(sol.maxProductDifference(nums1));
        // Output: 34

        int[] nums2 = {4, 2, 5, 9, 7, 4, 8};
        System.out.println(sol.maxProductDifference(nums2));
        // Output: 64
    }
}
