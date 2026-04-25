package binarySearch.april24;

public class RotatingSearch {

    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return true;
            }

            if (nums[left] == nums[mid]) {
                left++;
            } else if (nums[left] < nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        RotatingSearch solution = new RotatingSearch();
        int[] nums1 = {2, 5, 6, 0, 0, 1, 2};
        System.out.println(solution.search(nums1, 0)); // true

        int[] nums2 = {2, 5, 6, 0, 0, 1, 2};
        System.out.println(solution.search(nums2, 3)); // false
    }
}
