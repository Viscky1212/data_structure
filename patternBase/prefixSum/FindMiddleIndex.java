package patternBase.prefixSum;

public class FindMiddleIndex {
    public static int findMiddleIndex(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == totalSum - leftSum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }

        return -1; // No middle index found
    }
    public static void main(String[] args) {
        int[] nums = {2, 3, -1, 8, 4};
        int middleIndex = findMiddleIndex(nums);
        System.out.println("Middle index: " + middleIndex); // Output: 3
    }
}
