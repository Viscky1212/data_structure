package slidingwindow.april08;

import java.util.Scanner;

public class GetSubarrayBeauty {

    public static int[] getSubarrayBeauty(int[] nums, int k , int x){
        int n = nums.length;
        int[] result = new int[n - k + 1];

        //frequency array for range [-50 to 50]
        int[] freq =new int[101];  //index = num + 50
        int left  = 0;

        for (int rigth = 0; rigth < n; rigth++) {
            //add element
            freq[nums[rigth] + 50]++;

            //maintain window size
            if (rigth - left + 1 > k){
                freq[nums[left] + 50]--;
                left++;
            }

            //preocess window
            if (rigth - left + 1 == k){
                int count = 0;
                int beauty = 0;

                //check negative omly (-50 to -1)
                for (int i = 0; i < 50; i++) {
                    count += freq[i];

                    if (count >= x){
                        beauty = i - 50;
                        break;
                    }
                }
                result[left] = beauty;
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

        System.out.println("Enter x:");
        int x = sc.nextInt();

        int[] result = getSubarrayBeauty(nums, k, x);

        System.out.println("Result:");
        for (int val : result) {
            System.out.print(val + " ");
        }

        sc.close();
    }
}
