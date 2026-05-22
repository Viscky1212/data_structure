package sorting.may20;

public class MinimumCost {

    public int minimumCost(int[] nums){
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < firstMin){
                secondMin = firstMin;
                firstMin = nums[i];
            } else if (nums[i] < secondMin) {
                secondMin = nums[i];
            }
        }
        return nums[0] + firstMin + secondMin;
    }

    public static void main(String[] args) {
        MinimumCost sol = new MinimumCost();

        int[] nums1 = {1, 2, 3, 12};
        System.out.println(sol.minimumCost(nums1));
        // Output: 6

        int[] nums2 = {5, 4, 3};
        System.out.println(sol.minimumCost(nums2));
        // Output: 12

        int[] nums3 = {10, 3, 1, 1};
        System.out.println(sol.minimumCost(nums3));
        // Output: 12
    }
}
