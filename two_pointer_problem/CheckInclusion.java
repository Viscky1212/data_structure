package two_pointer_problem;

import java.util.Arrays;

public class CheckInclusion {

    public static boolean checkInclusion(String s1, String s2){
        //if s1 is larger than s2, permutation impossible
        if (s1.length() > s2.length()) return false;

        //frequency array
        int[] s1Count = new int[26];
        int[] windowCount = new int[26];

        //count character of s1
        for (char c : s1.toCharArray()){
            s1Count[c - 'a']++;
        }

        int windowSize = s1.length();

        for (int i = 0; i < s2.length(); i++) {
            //Add current character to window
            windowCount[s2.charAt(i) - 'a']++;

            //Remove character when window exceeds size
            if (i >= windowSize){
                windowCount[s2.charAt(i - windowSize) - 'a']--;
            }

            //check if both frequency arrays match
            if (Arrays.equals(s1Count,windowCount)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";

        boolean result = checkInclusion(s1, s2);

        System.out.println("Does s2 contain permutation of s1? " + result);

    }
}
