package binarySearch.april24;

public class FindMinRotation {
    public int findMin(int[] nums){
        int left = 0;
        int right = nums.length - 1;

        while (left < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]){
                left = mid + 1;
            }
            else {
                right = mid;
            }

        }
        return nums[left];
    }

    public static void main(String[] args) {
        FindMinRotation solution = new FindMinRotation();
        int[] nums1 = {3, 4, 5, 1, 2};
        System.out.println(solution.findMin(nums1)); // 1

        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(solution.findMin(nums2)); // 0

        int[] nums3 = {11, 13, 15, 17};
        System.out.println(solution.findMin(nums3)); // 11
    }
}
