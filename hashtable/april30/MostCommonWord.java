package hashtable.april30;

import javax.management.monitor.StringMonitor;
import java.util.*;

public class MostCommonWord {

    public String mostCommonWord(String paragraph, String[] banned){
        //Step 1 : banned set
        Set<String> bannedSet  = new HashSet<>(Arrays.asList(banned));

        //Step 2 : normalize paragraph
        paragraph = paragraph.toLowerCase().replaceAll("[^a-z]", " ");
        String[] words = paragraph.split("\\s+");

        Map<String, Integer> freq = new HashMap<>();

        String result = "";
        int mazFreq = 0;

        //Step 3 : count  frequencies
        for (String word : words){
            if (word.length() == 0 || bannedSet.contains(word)) continue;

            int count = freq.getOrDefault(word,0) + 1;
            freq.put(word,count);

            if (count > mazFreq){
                mazFreq = count;
                result = word;
            }

        }
        return result;
    }

    public static void main(String[] args) {

        MostCommonWord sol = new MostCommonWord();

        String paragraph1 = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned1 = {"hit"};

        System.out.println(sol.mostCommonWord(paragraph1, banned1));
        // ball

        String paragraph2 = "a.";
        String[] banned2 = {};

        System.out.println(sol.mostCommonWord(paragraph2, banned2));
        // a
    }
}
