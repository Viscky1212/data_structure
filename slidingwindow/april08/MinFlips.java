package slidingwindow.april08;

import java.util.Scanner;

public class MinFlips {

    public static int minFlips(String s){
        int n = s.length();

        //double string to simulate
        String doubled = s + s;

        int diff1 = 0;  //mismatch with pattern 0101
        int diff2 = 0;  //mismatch with 1010

        int result =  Integer.MAX_VALUE;

        for (int i = 0; i < doubled.length(); i++) {
            char expected1 = (i % 2 == 0) ? '0' : '1';
            char expected2 = (i % 2 == 0) ? '1' : '0';

            if (doubled.charAt(i) != expected1) diff1++;
            if (doubled.charAt(i) != expected2) diff2++;

            //maintain window size = n
            if (i >= n) {
                int j = i - n;


                char oldExpected1 = (j % 2 == 0) ? '0' : '1';
                char oldExpected2 = (j % 2 == 0) ? '1' : '0';

                if (doubled.charAt(j) != oldExpected1) diff1--;
                if (doubled.charAt(j) != oldExpected2) diff2--;
            }

            //when window is valid
            if (i >= n - 1){
                result = Math.min(result, Math.min(diff1,diff2));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter binary string:");
        String s = sc.nextLine();

        int result = minFlips(s);

        System.out.println("Minimum flips required: " + result);

        sc.close();
    }
}
