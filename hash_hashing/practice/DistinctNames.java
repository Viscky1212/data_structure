package hash_hashing.practice;

import java.util.*;

public class DistinctNames {

    public static long distinctNames(String[] ideas){

        //Step 1 : Create 26 group
        Set<String>[] groups = new HashSet[26];

        for (int i = 0; i < 26; i++) {
            groups[i] = new HashSet<>();
        }
        //step 2 : Fill group with suffix
        for (String idea : ideas){
            int index = idea.charAt(0) - 'a';
            groups[index].add(idea.substring(1));
        }
        long result = 0;

        //compare each pair of groups
        for (int i = 0; i < 26; i++) {
            for (int j = i + 1; j < 26; j++) {
                //Count common suffixes
                int common = 0;

                for (String suffix : groups[i]){
                    if (groups[j].contains(suffix)){
                        common++;
                    }
                }

                //calculate valid combinations
                int uniqueI = groups[i].size() - common;
                int uniqueJ = groups[j].size() - common;

                result += (long) uniqueI * uniqueJ * 2;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        DistinctNames sol = new DistinctNames();
        String[] ideas1 = {"coffee","donuts","time","toffee"};
        System.out.println("Output: " + distinctNames(ideas1)); // 6

        String[] ideas2 = {"lack","back"};
        System.out.println("Output: " + distinctNames(ideas2)); // 0

    }
}
