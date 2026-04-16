package slidingwindow.april08;

import java.util.Scanner;

public class MinSwaps {

    public static int minSwaps(int[] nums){
        int n = nums.length;

        //step 1 : count total ones
        int totalOnes = 0;
        for (int num : nums){
            totalOnes += num;
        }

        //Edge case
        if (totalOnes == 0 || totalOnes == n) return 0;

        //Step 2 : create extended array
        int[] extended = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            extended[i] = nums[i % n];
        }

        //step 3 : sliding window
        int windowOnes = 0;
        int maxOnes = 0;
        for (int i = 0; i < 2 * n; i++) {
            windowOnes += extended[i];

            //maintain  window size
            if (i >= totalOnes){
                windowOnes -= extended[i - totalOnes];
            }

            //update max ones
            maxOnes = Math.max(maxOnes,windowOnes);
        }
        //step 4 : calculate result
        return totalOnes - maxOnes;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter array size:");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter binary array:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int result = minSwaps(nums);

        System.out.println("Minimum swaps required: " + result);

        sc.close();
    }
}
