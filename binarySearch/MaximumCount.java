package binarySearch;

public class MaximumCount {

    public int maximumCount(int[] nums){
        int positive = 0;
        int negative = 0;

        for (int num : nums){
            if (num > 0){
                positive++;
            }
            else if (num < 0) {
                negative++;
            }
        }
        return Math.max(positive, negative);
    }

    public static void main(String[] args) {
        MaximumCount solution = new MaximumCount();
        int[] nums1 = {-2, -1, -1, 1, 2, 3};
        System.out.println(solution.maximumCount(nums1)); // 3

        int[] nums2 = {-3, -2, -1, 0, 0, 1, 2};
        System.out.println(solution.maximumCount(nums2)); // 3

        int[] nums3 = {5, 20, 66, 1314};
        System.out.println(solution.maximumCount(nums3)); // 4
    }
}
