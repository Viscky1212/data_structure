package hashtable.may05;

import java.util.HashSet;
import java.util.Set;

public class CanBeTypedWords {

    public int canBeTypedWords(String text, String brokenLetters){
        //Step 1 : store broken letters
        Set<Character> broken = new HashSet<>();

        for (char ch : brokenLetters.toCharArray()){
            broken.add(ch);
          //  System.out.println(broken);
        }

        int count = 0;

        //Step 2 : split words
        String[] words = text.split(" ");

        //Step 3 : check each word
        for (String word : words){
            boolean canType = true;
            for (char ch : word.toCharArray()){
                if (broken.contains(ch)){
                    canType = false;
                    break;
                }
            }
            if (canType){
                count++;
            }
        }

        return count;
    }


    public static void main(String[] args) {

        CanBeTypedWords sol = new CanBeTypedWords();

        System.out.println(sol.canBeTypedWords("hello world", "ad")); // 1
        System.out.println(sol.canBeTypedWords("leet code", "lt"));   // 1
        System.out.println(sol.canBeTypedWords("leet code", "e"));    // 0
    }
}
