package slidingwindow.april08;

import java.util.Scanner;

public class LongestSemiRepetitiveSubstring {
    public static int longestSemiRepetitiveSubstring(String s){
        int left = 0;
        int countPair = 0;
        int maxLen = 1;

        for (int rigth = 1; rigth < s.length(); rigth++) {
            //check adjacent pair
            if (s.charAt(rigth) == s.charAt(rigth -1 )){
                countPair++;
            }

            //shrink window if more than 1 pair
            while (countPair > 1){
                if (s.charAt(left) == s.charAt(left + 1)){
                    countPair--;
                }
                left++;
            }
            maxLen = Math.max(maxLen, rigth - left + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter string:");
        String s = sc.nextLine();

        int result = longestSemiRepetitiveSubstring(s);

        System.out.println("Longest semi-repetitive substring length: " + result);

        sc.close();
    }
}
