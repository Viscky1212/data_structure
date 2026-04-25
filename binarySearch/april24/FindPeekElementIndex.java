package binarySearch.april24;

public class FindPeekElementIndex {
    public int findPeakElement(int[] nums){
        int left = 0;
        int right = nums.length - 1;

        while (left < right){
            int mid = left + (right - left) / 2;

            if (nums[mid] < nums[mid + 1]){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        FindPeekElementIndex solution = new FindPeekElementIndex();
        int[] nums1 = {1, 2, 3, 1};
        System.out.println(solution.findPeakElement(nums1)); // 2

        int[] nums2 = {1, 2, 1, 3, 5, 6, 4};
        System.out.println(solution.findPeakElement(nums2)); // 5 or 1

    }
}
