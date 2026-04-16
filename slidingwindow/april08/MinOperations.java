package slidingwindow.april08;

import java.util.Map;
import java.util.Scanner;

public class MinOperations {

    public int minOperations(int[] nums, int x) {

        int totalSum = 0;
        for (int num : nums) totalSum += num;

        int target = totalSum - x;

        // Edge case
        if (target < 0) return -1;
        if (target == 0) return nums.length;

        int left = 0;
        int currSum = 0;
        int maxLen = -1;

        for (int right = 0; right < nums.length; right++) {

            currSum += nums[right];

            while (currSum > target) {
                currSum -= nums[left++];
            }

            if (currSum == target) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }

        return maxLen == -1 ? -1 : nums.length - maxLen;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter you numbers : ");
        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println("Enter your target value : ");
        int x = sc.nextInt();

        MinOperations sol = new MinOperations();
        int result = sol.minOperations(nums , x);
        System.out.println(result);
        sc.close();

    }
}
