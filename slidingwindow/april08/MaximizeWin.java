package slidingwindow.april08;

import java.util.Scanner;

public class MaximizeWin {

    public static int maximizeWin(int[] prizePositions, int k){
        int n = prizePositions.length;
        int[] best = new int[n];
        int left  = 0;
        int result = 0;

        for (int right = 0; right < n; right++) {
            //maintain window
            while (prizePositions[right] - prizePositions[left] > k){
                left++;
            }

            int windowSize = right - left + 1;

            //combine with previous best
            int previousBest = (left > 0 ) ? best[left - 1] : 0;

            result = Math.max(result, windowSize + previousBest);

            //Update best
            best[right] = Math.max(
                    (right > 0 ? best[right - 1] : 0 ), windowSize);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter array size:");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter prize positions:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter k:");
        int k = sc.nextInt();

        int result = maximizeWin(arr, k);

        System.out.println("Maximum prizes collected: " + result);

        sc.close();
    }
}
