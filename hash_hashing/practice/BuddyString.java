package hash_hashing.practice;

import java.util.ArrayList;
import java.util.List;

public class BuddyString {

    public static boolean buddyString(String s, String goal){
        //Step 1 : length check
        if(s.length() != goal.length()){
            return  false;
        }

        //case 1 : strings are equal
        if (s.equals(goal)){
            //check duplicate character
            int[] freq = new int[26];

            for(char ch : s.toCharArray()){
                freq[ch - 'a']++;

                if (freq[ch - 'a'] > 1){
                    return  true; //duplicate found
                }
            }
            return  false;
        }

        // Case 2 : string are different
        List<Integer> diff = new ArrayList<>();

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != goal.charAt(i)){
                diff.add(i);
            }
        }
        //must be exactly 2 differance

        if(diff.size() != 2){
            return  false;
        }

        int i = diff.get(0);
        int j = diff.get(1);

        //check if swapping work
        return s.charAt(i) == goal.charAt(j) && s.charAt(j) == goal.charAt(i);
    }

    public static void main(String[] args) {
        System.out.println(buddyString("ab","ab"));

        System.out.println(buddyString("aa","aa"));

        System.out.println(buddyString("ab","ba"));
    }
}
