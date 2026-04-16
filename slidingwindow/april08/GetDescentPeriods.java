package slidingwindow.april08;

import java.util.Scanner;

public class GetDescentPeriods {

    public static long getDescentPeriods(int[] prise){
        int n = prise.length;

        long result = 1; //first element
        long streak = 1;

        for (int i = 1; i < n; i++) {
            //check if smooth descent continuous
            if (prise[i] == prise[i - 1] - 1){
                streak++;
            } else {
                streak = 1;
            }
            result += streak;
        }
        return result;

    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter array size:");
        int n = sc.nextInt();

        int[] prices = new int[n];

        System.out.println("Enter prices:");
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        long result = getDescentPeriods(prices);

        System.out.println("Total smooth descent periods: " + result);

        sc.close();
    }
}
