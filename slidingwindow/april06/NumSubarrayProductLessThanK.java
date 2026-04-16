package slidingwindow.april06;

public class NumSubarrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k){
        if (k <= 1) return 0;

        int left = 0;
        int product = 1;
        int count = 0;

        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];

            while (product >= k){
                product /= nums[left];
                left++;
            }
            count += (right - left + 1);
        }
        return count;
    }

    public static void main(String[] args) {
NumSubarrayProductLessThanK sol = new NumSubarrayProductLessThanK();

        int[] nums1 = {10,5,2,6};
        int k1 = 100;

        int[] nums2 = {1,2,3};
        int k2 = 0;

        System.out.println("Output 1: " + sol.numSubarrayProductLessThanK(nums1, k1)); // 8
        System.out.println("Output 2: " + sol.numSubarrayProductLessThanK(nums2, k2)); // 0

    }
}
