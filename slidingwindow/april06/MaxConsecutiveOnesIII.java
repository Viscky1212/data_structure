package slidingwindow.april06;

public class MaxConsecutiveOnesIII {

    //Optimal sliding window approach
    public static int longestOnes(int[] nums, int k){
        int left = 0;
        int zeroCount = 0;
        int maxLength = 0;

        for (int right = 0; right < nums.length; right++) {
            //count zeros
            if (nums[right] == 0){
                zeroCount++;
            }
            while (zeroCount > k){
                if (nums[left] == 0) zeroCount --;
            left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    //Brute force approach
    public static int bruteForce(int[] nums, int k){
        int maxLength = 0;

        for (int i = 0; i < nums.length; i++) {
            int zeroCount = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == 0) zeroCount++;

                if (zeroCount <= k){
                    maxLength = Math.max(maxLength, j - i + 1);
                } else {
                    break;
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,1,1,0,0,0,1,1,1,1,0};
        int k1 = 2;

        System.out.println("Optimal Result: " + longestOnes(nums1, k1));
        System.out.println("Brute Force Result: " + bruteForce(nums1, k1));

        int[] nums2 = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k2 = 3;

        System.out.println("Test Case 2: " + longestOnes(nums2, k2));
    }
}
