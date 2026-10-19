package patternBase.recursionAndBackTracking.sheet.backtrack;

import java.util.*;

public class Partition {
    public List<List<String>> partition(String s) {

        List<List<String>> result = new ArrayList<>();

        backtrack(s, 0, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(String s, int start, List<String> current, List<List<String>> result){

        //Base case
        if(start == s.length()){
            result.add(new ArrayList<>(current));
            return;
        }

        //Try every possible substring
        for(int end = start; end < s.length(); end++){

            //check whether substring is palindrome
            if(isPalindrome(s, start, end)){

                //choose
                current.add(s.substring(start, end + 1));

                backtrack(s, end + 1, current, result);

                current.remove(current.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right){
        while(left < right){

            if(s.charAt(left) != s.charAt(right)){
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        Partition partition = new Partition();
        String s = "aab"; // Change this value to test different strings
        List<List<String>> result = partition.partition(s);
        System.out.println("Palindromic partitions of \"" + s + "\": " + result);
    }
}
