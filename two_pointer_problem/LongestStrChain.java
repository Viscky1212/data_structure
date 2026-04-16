package two_pointer_problem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestStrChain {

    public static int longestStrChain(String[] words){
        Arrays.sort(words,(a,b) -> a.length() - b.length());
        Map<String,Integer> dp = new HashMap<>();
        int max = 1;

        for (String word : words){
            int best = 1;

            for (int i = 0; i < word.length(); i++) {
                String prev = word.substring(0, i) + word.substring(i + 1);
                best = Math.max(best,dp.getOrDefault(prev,0) + 1);
            }
            dp.put(word,best);
            max = Math.max(max,best);
        }
        return max;
    }

    public static void main(String[] args) {
        String[] words = {"a","b","ba","bca","bda","bdca"};

        int result = longestStrChain(words);

        System.out.println("Longest String Chain Length: " + result);
    }
}
