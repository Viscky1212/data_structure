package slidingwindow.april08;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MaximumUniqueSubarray {

    public int maximumUniqueSubarray(int[] nums){
        Set<Integer> set = new HashSet<>();
        int left = 0;
        int currentSum = 0;
        int maxSum = 0;

        for (int right = 0; right < nums.length; right++) {
            //if duplicate found -> shrink window
            while (set.contains(nums[right])){
                set.remove(nums[left]);
                currentSum -= nums[left];
                left++;
            }
            //add new element
            set.add(nums[right]);
            currentSum += nums[right];

        //update max sum
            maxSum = Math.max(maxSum,currentSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        MaximumUniqueSubarray sol = new MaximumUniqueSubarray();
        int result = sol.maximumUniqueSubarray(nums);

        System.out.println(result);

        sc.close();
    }
}
