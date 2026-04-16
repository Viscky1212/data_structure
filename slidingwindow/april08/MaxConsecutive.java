package slidingwindow.april08;

import java.util.Scanner;

public class MaxConsecutive {

    //helper function to calculate max consecutive for target hour

    public static int maxConsecutive(String s, int k , char target){
        int left = 0;
        int maxLen = 0;
        int count = 0; //number of char to flip

        for (int right = 0; right < s.length(); right++) {
            //if current char is not target -> need flip
            if (s.charAt(right) != target){
                count++;
            }

            //if flip exceed k -> shrink window
            while (count > k){
                if (s.charAt(left) != target){
                    count--;
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    public static int maxConsecutiveAnswers(String answerKey, int k){

        //Try both cases : make all 'T' or all 'F'
        int makeT = maxConsecutive(answerKey,k,'T');
        int makeF = maxConsecutive(answerKey,k,'F');

        return  Math.max(makeT,makeF);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter answer key (T/F):");
        String s = sc.nextLine();

        System.out.println("Enter k:");
        int k = sc.nextInt();

        int result = maxConsecutiveAnswers(s, k);

        System.out.println("Maximum consecutive answers: " + result);

        sc.close();
    }
}
