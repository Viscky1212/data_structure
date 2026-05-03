package hashtable.april30;

import java.util.HashSet;
import java.util.Set;

public class UniqueMorseRepresentations {

    public int uniqueMorseRepresentations(String[] words){
        String[] morse = {
                ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---",
                "-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-",
                "..-","...-",".--","-..-","-.--","--.."
        };

        Set<String> set = new HashSet<>();
        for (String word : words){
            StringBuilder sb = new StringBuilder();
            for (char ch : word.toCharArray()){
                sb.append(morse[ch - 'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }

    public static void main(String[] args) {

        UniqueMorseRepresentations sol = new UniqueMorseRepresentations();

        String[] words1 = {"gin","zen","gig","msg"};
        System.out.println(sol.uniqueMorseRepresentations(words1)); // 2

        String[] words2 = {"a"};
        System.out.println(sol.uniqueMorseRepresentations(words2)); // 1
    }
}
