package hash_hashing.practice;

import java.util.Arrays;
import java.util.Scanner;

public class AppealSum {

    public long appealSum(String s){
        int n = s.length();

        //Store last occurance of each character
        int[] lastSeen = new int[26];
        Arrays.fill(lastSeen, -1);
        long result = 0;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            //contribution of current character

            int lastIndex = lastSeen[ch - 'a'];

            long contribution = (long) (i - lastIndex)* (n - i);
            result += contribution;

            //Update last seen index
            lastSeen[ch - 'a'] = i;
        }
        return result;
    }

    public static void main(String[] args) {
        AppealSum sol = new AppealSum();

        // Test Case 1
        String s1 = "abbca";
        System.out.println("Input: " + s1);
        System.out.println("Output: " + sol.appealSum(s1)); // Expected: 28

        // Test Case 2
        String s2 = "code";
        System.out.println("\nInput: " + s2);
        System.out.println("Output: " + sol.appealSum(s2)); // Expected: 20

        // Optional: User Input
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter a string:");
        String input = sc.nextLine();

        System.out.println("Total Appeal: " + sol.appealSum(input));

        sc.close();
    }
}
