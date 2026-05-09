package hashtable.may06;

import java.util.HashSet;
import java.util.Set;

public class NumDifferentIntegers {

    public int numDifferentIntegers(String word){
        Set<String> set = new HashSet<>();
        int i = 0;
        int n = word.length();

        while (i < n){
            if (Character.isDigit(word.charAt(i))){
                StringBuilder num = new StringBuilder();

                //build number
                while (i < n && Character.isDigit(word.charAt(i))){
                    num.append(word.charAt(i));
                    i++;
                }

                //remove leading zeros
                String normalized = removeLeadingZeros(num.toString());
                set.add(normalized);
            } else {
                i++;
            }
        }
        return set.size();
    }

    private String removeLeadingZeros(String s){
        int i = 0;
        while (i < s.length() && s.charAt(i) == '0'){
            i++;
        }
        return (i == s.length() ? "0" : s.substring(i));
    }

    public static void main(String[] args) {

        NumDifferentIntegers sol = new NumDifferentIntegers();

        System.out.println(sol.numDifferentIntegers("a123bc34d8ef34")); // 3
        System.out.println(sol.numDifferentIntegers("leet1234code234")); // 2
        System.out.println(sol.numDifferentIntegers("a1b01c001")); // 1
    }
}
