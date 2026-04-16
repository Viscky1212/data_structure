package slidingwindow.april08;

import java.util.Arrays;
import java.util.Scanner;

public class GetAverages {

    public static int[] getAverages(int[] nums, int k){
        int n = nums.length;
        int[] result = new int[n];

        //fill with -1 by default
        Arrays.fill(result, -1);

        //window size
        int windowSize = 2 * k + 1;

        //if window is larger than array -> return all -1
        if (windowSize > n){
            return result;
        }

        long windowSum = 0;

        //first window sum
        for (int i = 0; i < windowSize; i++) {
            windowSum += nums[i];
        }

        //set first valid average
        result[k] = (int) (windowSum / windowSize);

        //slide window
        for (int i = windowSize; i < n; i++) {
            windowSum += nums[i];  //add next
            windowSum -= nums[i - windowSize];  //remove old
        result[i - k] = (int)(windowSum / windowSize);
        }

        return result;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter array size:");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println("Enter k:");
        int k = sc.nextInt();

        int[] result = getAverages(nums, k);

        System.out.println("Result:");
        for (int val : result) {
            System.out.print(val + " ");
        }

        sc.close();
    }
}
