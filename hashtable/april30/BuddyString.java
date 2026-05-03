package hashtable.april30;

import java.util.ArrayList;
import java.util.List;

public class BuddyString {

    public boolean buddyStrings(String s, String goal){
        if (s.length() != goal.length()){
            return false;
        }

        //Step 1 : String are equal
        if (s.equals(goal)){
            int[] freq = new int[26];

            for (char c : s.toCharArray()){
                freq[c - 'a']++;

                if (freq[c - 'a'] > 1){
                    return true;  //duplicate exists
                }
            }
            return false;
        }

        //Case 2 : find mismatched
        List<Integer> diff = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)){
                diff.add(i);
            }
            if (diff.size() > 2){
                return false;
            }
        }

        //must be exactly 2 mismatched
        if (diff.size() != 2){
            return false;
        }

        int i = diff.get(0);
        int j = diff.get(1);

        return s.charAt(i) == goal.charAt(j) && s.charAt(j) == goal.charAt(i);
    }

    public static void main(String[] args) {

        BuddyString sol = new BuddyString();

        System.out.println(sol.buddyStrings("ab", "ba")); // true
        System.out.println(sol.buddyStrings("ab", "ab")); // false
        System.out.println(sol.buddyStrings("aa", "aa")); // true
        System.out.println(sol.buddyStrings("abcd", "badc")); // false
    }
}
