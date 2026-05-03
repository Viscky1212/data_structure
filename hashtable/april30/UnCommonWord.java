package hashtable.april30;

import java.util.*;

public class UnCommonWord {

    public String[] uncommonFromSentences(String s1, String s2){
        Map<String, Integer> freq = new HashMap<>();

        //count word from s1
        for (String word : s1.split(" ")){
            freq.put(word,freq.getOrDefault(word,0) + 1);
        }

        //count word form s2
        for (String word : s2.split(" ")){
            freq.put(word,freq.getOrDefault(word,0) + 1);
        }
        List<String> result = new ArrayList<>();

        //collect uncommon words
        for (String word : freq.keySet()){
            if (freq.get(word) == 1){
                result.add(word);
            }
        }
        return result.toArray(new String[0]);
    }


    public static void main(String[] args) {
        UnCommonWord sol = new UnCommonWord();

        String s1 = "this apple is sweet";
        String s2 = "this apple is sour";

        System.out.println(Arrays.toString(
                sol.uncommonFromSentences(s1, s2)
        ));
        // ["sweet", "sour"]

        String s3 = "apple apple";
        String s4 = "banana";

        System.out.println(Arrays.toString(
                sol.uncommonFromSentences(s3, s4)
        ));
        // ["banana"]
    }
}
