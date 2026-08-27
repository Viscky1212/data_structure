package patternBase.binarySearch;

public class FindKRotation {

    public static int findKRotation(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                // The minimum is in the right half
                left = mid + 1;
            } else {
                // The minimum is in the left half
                right = mid;
            }
        }

        return left; // or right, both are the same at this point
    }



    public static void main(String[] args) {
        int[] nums = {15, 18, 2, 3, 6, 12};
        int rotations = findKRotation(nums);
        System.out.println("The array is rotated " + rotations + " times.");
    }
}
