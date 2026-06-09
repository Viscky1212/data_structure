package patternBase.TwoPointer;

public class NumSubarrayProductLessThanK {

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0; // No products can be less than or equal to 1
        }

        int count = 0;
        int product = 1;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];

            while (product >= k) {
                product /= nums[left];
                left++;
            }

            count += (right - left + 1); // Count subarrays ending at 'right'
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 6};
        int k = 100;

        int result = numSubarrayProductLessThanK(nums, k);
        System.out.println("Number of subarrays with product less than " + k + " = " + result);
    }
}
