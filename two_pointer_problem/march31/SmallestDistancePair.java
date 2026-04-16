package two_pointer_problem.march31;

import java.util.Arrays;

public class SmallestDistancePair {

    public int smallestDistancePair(int[] nums, int k){
        Arrays.sort(nums);

        int low = 0;
        int high = nums[nums.length - 1] - nums[0];

        while (low < high){
            int mid  = low + (high - low) / 2;
            if (countPairs(nums, mid) >= k){
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public int countPairs(int[] nums, int mid){
        int count = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            while (nums[right] - nums[left] > mid){
                left++;
            }

            count += right - left;
        }
        return count;
    }

    public static void main(String[] args) {
        SmallestDistancePair sol = new SmallestDistancePair();
        int[] nums1 = {1,3,1};
        int k1 = 1;

        int[] nums2 = {1,1,1};
        int k2 = 2;

        int[] nums3 = {1,6,1};
        int k3 = 3;

        System.out.println("Output 1: " + sol.smallestDistancePair(nums1, k1)); // 0
        System.out.println("Output 2: " + sol.smallestDistancePair(nums2, k2)); // 0
        System.out.println("Output 3: " + sol.smallestDistancePair(nums3, k3)); // 5
    }

}
