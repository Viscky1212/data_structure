package patternBase.prefixSum;

public class PivoteIndex {

//    public static int findPivotIndex(int[] nums) {
//        int totalSum = 0;
//        for (int num : nums) {
//            totalSum += num;
//        }
//
//        int leftSum = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (leftSum == totalSum - leftSum - nums[i]) {
//                return i;
//            }
//            leftSum += nums[i];
//        }
//
//        return -1; // No pivot index found
//    }

    public static int findPivotIndex(int[] nums) {
        int totalSum = 0;
        for (int num : nums){
            totalSum += num;
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int rightSum = totalSum - leftSum - nums[i];

            if (leftSum == rightSum){
                return i;
            }

            leftSum += nums[i];
        }
        return -1; // No pivot index found
    }

    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};
        int pivotIndex = findPivotIndex(nums);
        System.out.println("Pivot Index: " + pivotIndex); // Output: 3
    }
}
