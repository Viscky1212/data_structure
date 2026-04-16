package slidingwindow.april09;

public class CountSubarraysMaxK {

    public long countSubarrays(int[] nums, int k){
        int n = nums.length;

        //Step 1 : Find max element
        int maxVal = 0;
        for (int num : nums){
            maxVal = Math.max(maxVal, num);
        }
        long  count = 0;
        int left = 0;
        int maxCount = 0;

        for (int right = 0; right < n; right++) {
            //count max element
            if (nums[right] == maxVal){
                maxCount++;
            }

            //when condition satisfied
            while (maxCount >= k){
                //All subarray from legt to right are valid
                count += (n - right);

                //shrink window
                if (nums[left] == maxVal){
                    maxCount--;
                }
                left++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountSubarraysMaxK sol = new CountSubarraysMaxK();

        int[] nums1 = {1,3,2,3,3};
        System.out.println(sol.countSubarrays(nums1, 2)); // 6

        int[] nums2 = {1,4,2,1};
        System.out.println(sol.countSubarrays(nums2, 3)); // 0
    }
}
