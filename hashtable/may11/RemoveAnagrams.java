package hashtable.may11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// sol 9
public class RemoveAnagrams {

    public List<String> removeAnagrams(String[] words){
        List<String> result = new ArrayList<>();

        String prev = "";

        for (String word : words){
            char[] chars = word.toCharArray();

            Arrays.sort(chars);
            String sortedWord = new String(chars);

            //keep only if not anagram of previous
            if (!sortedWord.equals(prev)){
                result.add(word);
                prev = sortedWord;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        RemoveAnagrams sol = new RemoveAnagrams();
        String[] words1 = {"abba","baba","bbaa","cd","cd"};

        System.out.println(
                sol.removeAnagrams(words1)
        );

        // [abba, cd]


        String[] words2 = {"a","b","c","d","e"};

        System.out.println(
                sol.removeAnagrams(words2)
        );

        // [a, b, c, d, e]
    }
}
