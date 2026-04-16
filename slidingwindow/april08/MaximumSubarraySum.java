package slidingwindow.april08;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MaximumSubarraySum {

    public static long maximumSubarraySum(int[] nums, int k){
        Map<Integer,Integer> freq = new HashMap<>();
        long maxSum = 0;
        long currentSum = 0;

        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            //add element to window
            freq.put(nums[right], freq.getOrDefault(nums[right],0) + 1);
            currentSum += nums[right];

            //maintain window size
            if (right - left + 1 > k){
                int leftVal = nums[left];
                freq.put(leftVal,freq.get(leftVal) - 1);

                if (freq.get(leftVal) == 0){
                    freq.remove(leftVal);
                }

                currentSum -= leftVal;
                left++;
            }

            //check valid window
            if (right - left + 1 == k && freq.size() == k){
                maxSum = Math.max(maxSum, currentSum);
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter array size:");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println("Enter k:");
        int k = sc.nextInt();

        long result = maximumSubarraySum(nums, k);

        System.out.println("Maximum sum of distinct subarray: " + result);

        sc.close();
    }
}
