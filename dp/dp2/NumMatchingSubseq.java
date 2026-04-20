package dp.dp2;

import java.util.ArrayList;
import java.util.List;

public class NumMatchingSubseq {

    public int numMatchingSubseq(String s, String[] words){
        List<Integer>[] positions = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            positions[i] = new ArrayList<>();
        }

        for (int i = 0; i < s.length(); i++) {
            positions[s.charAt(i) - 'a'].add(i);
        }

        int count = 0;

        for (String word : words){
            if (isSubSequence(word,positions)) {
                count++;
            }
        }
        return count;
    }

    private  boolean isSubSequence(String word , List<Integer>[] positions){
        int prevIndex = -1;
        for (int i = 0; i < word.length(); i++) {
            List<Integer> list = positions[word.charAt(i) - 'a'];
            int nextIndex = upperBound(list, prevIndex);

            if (nextIndex == -1){
                return false;
            }
            prevIndex = nextIndex;
        }
        return true;
    }

    private int upperBound(List<Integer>list, int target){
        int left = 0, right = list.size() - 1;
        int ans = -1;

        while (left <= right){
            int mid = left + (right - left) / 2;

            if (list.get(mid) > target){
                ans = list.get(mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        NumMatchingSubseq sol = new NumMatchingSubseq();
        String s = "abcde";
        String[] words = {"a", "bb", "acd", "ace"};

        System.out.println(sol.numMatchingSubseq(s, words));
    }
}
