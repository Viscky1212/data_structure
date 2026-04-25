package binarySearch.april24;

public class SingleElementInSortedArray {

    public int singleNonDuplicate(int[] nums){
        int left = 0, right = nums.length - 1;

        while (left < right){
            int mid = left + (right - left)/ 2;

            if (mid % 2 == 1) mid--;

            if (nums[mid] == nums[mid + 1]) left = mid + 2;
            else right = mid;
        }
        return nums[left];
    }

    public static void main(String[] args) {
        SingleElementInSortedArray solution = new SingleElementInSortedArray();
        int[] nums1 = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        System.out.println(solution.singleNonDuplicate(nums1)); // 2

        int[] nums2 = {3, 3, 7, 7, 10, 11, 11};
        System.out.println(solution.singleNonDuplicate(nums2)); // 10
    }
}
