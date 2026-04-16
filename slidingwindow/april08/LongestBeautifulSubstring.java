package slidingwindow.april08;

import java.util.Scanner;

public class LongestBeautifulSubstring {
    public int longestBeautifulSubstring(String word){
        int maxLen = 0;
        int start = 0;
        int distinct = 1;  //first char counts

        for (int i = 1; i < word.length(); i++) {

            if (word.charAt(i) < word.charAt(i - 1)){
                //reset window
                start = i;
                distinct = 1;
            } else if (word.charAt(i) > word.charAt(i -  1)){
                //new vowel present
                distinct++;
            }
            //check if all 5 vowels present
            if (distinct == 5){
                maxLen = Math.max(maxLen, i - start + 1);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String word = sc.next();

        LongestBeautifulSubstring sol = new LongestBeautifulSubstring();
        int result = sol.longestBeautifulSubstring(word);

        System.out.println(result);

        sc.close();
    }
}
