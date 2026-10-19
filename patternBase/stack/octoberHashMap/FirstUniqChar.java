package patternBase.stack.octoberHashMap;

import java.util.*;

public class FirstUniqChar {
    public int firstUniqChar(String s){

        Map<Character, Integer> frequency = new HashMap<>();

        //count frequency
        for(char ch : s.toCharArray()){
            frequency.put(
                    ch,
                    frequency.getOrDefault(ch,0) + 1
            );
        }

        //find first unique charcter
        for(int i = 0; i < s.length(); i++){
            if(frequency.get(s.charAt(i)) == 1){
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        FirstUniqChar firstUniqChar = new FirstUniqChar();
        String input = "leetcode";
        int index = firstUniqChar.firstUniqChar(input);
        System.out.println("Index of first unique character: " + index); // Output: 0
    }



    // public int firstUniqChar(String s) {

    //     int[] frequency = new int[26];

    //     //step 1 : Count frequency of every charcter
    //     for(char ch : s.toCharArray()){
    //         frequency[ch - 'a']++;
    //     }

    //     //step 2 : find first character
    //     //whose frequency is exactly 1

    //     for(int i = 0; i < s.length(); i++){

    //         if(frequency[s.charAt(i) - 'a'] == 1){
    //             return i;
    //         }
    //     }

    //     //no unique charcter found
    //     return -1;
    // }


}


/*

create frequency[26]

for each character ch:
    frequency[ch - 'a']++

for i = 0 to n-1:

    if frequency[s[i] - 'a'] == 1:
        return i

return -1


*/