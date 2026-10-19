package patternBase.stack.octoberHashMap;

import java.util.*;

public class CanConstruct {

    public boolean canConstruct(String ransomNote, String magazine) {

        Map<Character, Integer> map = new HashMap<>();

        // Count magazine characters
        for (char ch : magazine.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Consume characters
        for (char ch : ransomNote.toCharArray()) {

            if (!map.containsKey(ch) || map.get(ch) == 0) {
                return false;
            }

            map.put(ch, map.get(ch) - 1);
        }

        return true;
    }
//    public boolean canConstruct(String ransomNote, String magazine) {
//
//        int[] freq = new int[26];
//
//        //count characters available in magazine
//        for(char ch : magazine.toCharArray()){
//            freq[ch - 'a']++;
//        }
//
//        //consume character for ransomeNode
//        for(char ch : ransomNote.toCharArray()){
//
//            freq[ch - 'a']--;
//
//            //character not available enough
//            if(freq[ch - 'a'] < 0){
//                return false;
//            }
//        }
//
//        return true;
//    }

    public static void main(String[] args) {

        CanConstruct canConstruct = new CanConstruct();
        String ransomNote = "aa";
        String magazine = "aab";
        boolean result = canConstruct.canConstruct(ransomNote, magazine);
        System.out.println("Can construct ransom note from magazine: " + result); // Output: true
    }
}
