package slidingwindow.april08;

import java.util.Scanner;

public class LongestSubarrayNum {

    public int longestSubarray(int[] nums){
        int left = 0;
        int zeroCount = 0;
        int maxLength = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0){
                zeroCount++;
            }
            //shrink window if more than 1 zero
            while (zeroCount > 1){
                if (nums[left] == 0){
                    zeroCount--;
                }
                left++;
            }
            // window size  -1 (delete one element)
            maxLength = Math.max(maxLength, right - left);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        LongestSubarrayNum sol = new LongestSubarrayNum();
        int result = sol.longestSubarray(nums);

        System.out.println(result);

        sc.close();
    }
}
