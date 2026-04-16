package slidingwindow.april06;

public class ThreeSlice {

    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) return 0;

        int total = 0;
        int curr = 0;

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                curr += 1;
                total += curr;
            } else {
                curr = 0;
            }
        }
    return total;
    }

    public static void main(String[] args) {
        ThreeSlice sol = new ThreeSlice();
        int[] nums1 = {1,2,3,4};
        int[] nums2 = {1};
        int[] nums3 = {1,3,5,7,9};

        System.out.println("Output 1: " + sol.numberOfArithmeticSlices(nums1)); // 3
        System.out.println("Output 2: " + sol.numberOfArithmeticSlices(nums2)); // 0
        System.out.println("Output 3: " + sol.numberOfArithmeticSlices(nums3)); // 6
    }

}
