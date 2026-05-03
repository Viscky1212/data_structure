package binarySearch.april27;

public class SmallestDivisor {

    public int smallestDivisor(int[] nums, int threshold){
        int low = 1;
        int high = 0;

        for (int num : nums){
            high = Math.max(high,num);
        }

        while (low <= high){
            int mid = low + (high - low) / 2;

            if (isvalid(nums, threshold, mid)){
                high = mid - 1;  //try for smaller divisor
            } else {
                low = mid + 1;  //increas divisor
            }
        }
        return low;  //smallest valid divisor
    }

    public boolean isvalid(int[] nums, int threshold, int divisor){
        int sum = 0;
        for (int num : nums){

            //ceil division without Math.ceil
            sum += (num + divisor - 1) / divisor;

            //early exit optimization
            if (sum > threshold) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        SmallestDivisor sol = new SmallestDivisor();
        int[] nums1 = {1, 2, 5, 9};
        int threshold1 = 6;
        System.out.println(sol.smallestDivisor(nums1, threshold1)); // Expected: 5

        int[] nums2 = {44, 22, 33, 11, 1};
        int threshold2 = 5;
        System.out.println(sol.smallestDivisor(nums2, threshold2)); // Expected: 44
    }
}
