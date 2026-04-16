package slidingwindow.april08;

import java.util.Scanner;

public class TakeCharacters {

    public static int takeCharacters(String s, int k){
        if (k == 0) return 0;

        int n = s.length();
        int[] total = new int[3];  //a, b, c

        //Count total frequency
        for (char ch : s.toCharArray()){
            total[ch - 'a']++;
        }

        //if impossible
        if (total[0] < k || total[1] < k || total[2] < k){
            return -1;
        }

        int[] window = new int[3];
        int left = 0;
        int maxWindow = 0;

        for (int right = 0; right < n; right++) {
            window[s.charAt(right) - 'a']++;

            //shrink window if invalid
            while (window[0] > total[0] - k ||
                    window[1] > total[1] - k ||
                    window[2] > total[2] - k){
                window[s.charAt(left) - 'a']--;
                left++;
            }

            maxWindow = Math.max(maxWindow, right - left + 1);
        }
        //result = character taken
        return n - maxWindow;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter string (a,b,c only):");
        String s = sc.nextLine();

        System.out.println("Enter k:");
        int k = sc.nextInt();

        int result = takeCharacters(s, k);

        System.out.println("Minimum minutes required: " + result);

        sc.close();
    }
}
