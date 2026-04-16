package slidingwindow.april08;

import java.util.Scanner;

public class MaxVowels {

    //function to check vowel
    public boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public int maxVowels(String s , int k){
        int count = 0;
        int maxCount = 0;

        //step1 : first window
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))){
                count++;
            }
        }
        maxCount = count;

        //step 2 : sliding window
        for (int i = k; i < s.length(); i++) {
            //Remove left char
            if (isVowel(s.charAt(i - k))){
                count--;
            }
            //add right char
            if (isVowel((s.charAt(i)))){
                count++;
            }
            maxCount = Math.max(maxCount,count);
        }
        return maxCount;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter you string : ");
        String s = sc.next();  // input string
        int k = sc.nextInt(); // window size

        MaxVowels sol = new MaxVowels();
        int result = sol.maxVowels(s, k);

        System.out.println("Result : " + result);

        sc.close();
    }
}
