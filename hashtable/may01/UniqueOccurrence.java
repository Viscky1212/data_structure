package hashtable.may01;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueOccurrence {

    public boolean uniqueOccurrences(int[] arr){
        Map<Integer,Integer> freq = new HashMap<>();

        //Step 1 : count frequency
        for (int num : arr){
            freq.put(num,freq.getOrDefault(num, 0)+ 1);
        }

        //Step 2 : count frequency
        Set<Integer> seen  = new HashSet<>();

        for (int count : freq.values()){

            if (seen.contains(count)){
                return false;
            }
            seen.add(count);
        }
        return true;
    }

    public static void main(String[] args) {
        UniqueOccurrence sol = new UniqueOccurrence();

        int[] arr1 = {1,2,2,1,1,3};
        System.out.println(sol.uniqueOccurrences(arr1)); // true

        int[] arr2 = {1,2};
        System.out.println(sol.uniqueOccurrences(arr2)); // false

        int[] arr3 = {-3,0,1,-3,1,1,1,-3,10,0};
        System.out.println(sol.uniqueOccurrences(arr3)); // true
    }
}
