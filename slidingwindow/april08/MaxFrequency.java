package slidingwindow.april08;

import java.util.Arrays;
import java.util.Scanner;

public class MaxFrequency {

    public int maxFrequency(int[] nums , int k){
        Arrays.sort(nums);

        long sum = 0;
        int left = 0;
        int maxFreq = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            //check of operation exceed k
            while ((long) nums[right] * (right - left + 1) - sum > k){
                sum -= nums[left];
                left++;
            }
            maxFreq = Math.max(maxFreq, right - left + 1);
        }
        return maxFreq;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number :  ");
        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println("Enter the target value : ");
        int k = sc.nextInt();

        MaxFrequency sol = new MaxFrequency();
        int result = sol.maxFrequency(nums, k);

        System.out.println("Result : "+result);

        sc.close();
    }
}
