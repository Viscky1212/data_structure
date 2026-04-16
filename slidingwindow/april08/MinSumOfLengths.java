package slidingwindow.april08;

import java.util.Arrays;
import java.util.Scanner;

public class MinSumOfLengths {
    public int minSumOfLengths(int[] arr, int target) {

        int n = arr.length;

        // dp[i] = min length of subarray ending at or before i
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);

        int left = 0;
        int sum = 0;

        int minLen = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {

            sum += arr[right];

            // shrink window
            while (sum > target) {
                sum -= arr[left++];
            }

            // valid subarray found
            if (sum == target) {

                int currLen = right - left + 1;

                // combine with previous best
                if (left > 0 && dp[left - 1] != Integer.MAX_VALUE) {
                    result = Math.min(result, currLen + dp[left - 1]);
                }

                // update min length so far
                minLen = Math.min(minLen, currLen);
            }

            dp[right] = minLen;
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your number : ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter you target value : ");
        int target = sc.nextInt();

        MinSumOfLengths sol = new MinSumOfLengths();
        int result = sol.minSumOfLengths(arr, target);

        System.out.println("Result : "+result);

        sc.close();
    }
}
