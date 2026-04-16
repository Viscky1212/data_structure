package slidingwindow.april03;

public class LongestAlternatingSubarray {

    public int longestAlternatingSubarray(int[] nums, int threshold){
        int n = nums.length;
        int maxLen  = 0;

        for (int i = 0; i < n; i++) {

            //Start only if even and within threshold
            if (nums[i] % 2 != 0  || nums[i] > threshold) continue;
            int len  = 1;

            for (int j = i + 1; j < n; j++) {
                //Break if threshold exceeded
                if (nums[j] > threshold) break;

                //check alternating parity
                if ((nums[j] % 2) == (nums[j - 1] % 2)) break;;

                len++;
            }
            maxLen = Math.max(maxLen,len);
        }
        return maxLen;
    }

    public static void main(String[] args) {

        LongestAlternatingSubarray sol = new LongestAlternatingSubarray();
        int[] nums1 = {3,2,5,4};
        int threshold1 = 5;

        int[] nums2 = {1,2};
        int threshold2 = 2;

        int[] nums3 = {2,3,4,5};
        int threshold3 = 4;

        System.out.println(sol.longestAlternatingSubarray(nums1, threshold1)); // 3
        System.out.println(sol.longestAlternatingSubarray(nums2, threshold2)); // 1
        System.out.println(sol.longestAlternatingSubarray(nums3, threshold3)); // 3
    }
}
