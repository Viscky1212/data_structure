package slidingwindow.april08;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountGood {

    public  static  long countGood(int[] nums , int k){
        Map<Integer, Long> freq = new HashMap<>();

        long pairCount = 0;
        long result = 0;

        int left = 0;
        int n = nums.length;

        for (int right = 0; right < n; right++) {
            long f = freq.getOrDefault(nums[right], 0L);

            //Add new pair
            pairCount += f;
            freq.put(nums[right], f + 1);

            //Shrink window if condition satisfied
            while (pairCount >= k){
                result += (n - right);
                long leftFreq = freq.get(nums[left]);
                freq.put(nums[left], leftFreq - 1);

                //remove pairs contribute by left element
                pairCount -= (leftFreq - 1);
                left++;
            }
        }
       return result;
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

        long result = countGood(nums, k);

        System.out.println("Number of good subarrays: " + result);

        sc.close();
    }
}
