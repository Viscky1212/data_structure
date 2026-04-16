package slidingwindow.april08;

import java.util.Scanner;

public class LongestNiceSubarray {


    public static int longestNiceSubarray(int[] nums) {

        int left = 0;
        int bitMask = 0;
        int maxLen = 0;

        for (int right = 0; right < nums.length; right++) {

            // FIX: Proper shrinking until no overlap
            while ((bitMask & nums[right]) != 0) {
                bitMask ^= nums[left]; // remove safely
                left++;
            }

            bitMask |= nums[right];

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {

        int[] nums = {
                744437702,379056602,145555074,392756761,560864007,
                934981918,113312475,1090,16384,33,
                217313281,117883195,978927664
        };

        int result = longestNiceSubarray(nums);
        System.out.println("Longest nice subarray length: " + result);
    }
}
