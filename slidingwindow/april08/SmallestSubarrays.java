package slidingwindow.april08;

import java.util.Arrays;
import java.util.Scanner;

public class SmallestSubarrays {

    public static int[] smallestSubarrays(int[] nums){
        int n = nums.length;
        int[] result = new int[n];

        int[] lastSeen = new int[32];
        Arrays.fill(lastSeen, -1);

        //Traverse from right to left
        for (int i = n - 1; i >= 0 ; i--) {
            //update last seen for bits of nums[i]

            for (int bit = 0; bit < 32; bit++) {
                if ((nums[i] & (1 << bit)) != 0){
                    lastSeen[bit] = i;
                }
            }

            int farhest = i;

            //Find farhest index needed
            for (int bit = 0; bit < 32; bit++) {
                if (lastSeen[bit] != -1){
                    farhest = Math.max(farhest, lastSeen[bit]);
                }
            }
            result[i] = farhest - i + 1;
        }
        return  result;
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

        int[] result = smallestSubarrays(nums);

        System.out.println("Result:");
        for (int val : result) {
            System.out.print(val + " ");
        }

        sc.close();
    }
}
