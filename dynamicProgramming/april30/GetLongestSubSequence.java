package dynamicProgramming.april30;

import java.util.ArrayList;
import java.util.List;

public class GetLongestSubSequence {
    public List<String> getLongestSubsequence(String[] words,int[] groups){
        List<String> res = new ArrayList<>();

        //Always take first element
        res.add(words[0]);
        int lastGroup = groups[0];

        for (int i = 0; i < words.length; i++) {
            if (groups[i] != lastGroup){
                res.add(words[i]);
                lastGroup = groups[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        GetLongestSubSequence sol = new GetLongestSubSequence();
        String[] words1 = {"e","a","b"};
        int[] groups1 = {0,0,1};

        System.out.println(sol.getLongestSubsequence(words1, groups1));
        // ["e","b"] or ["a","b"]

        String[] words2 = {"a","b","c","d"};
        int[] groups2 = {1,0,1,1};

        System.out.println(sol.getLongestSubsequence(words2, groups2));
        // ["a","b","c"]
    }
}
