package hashtable.may11;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayRankTransform {

    public int[] arrayRankTransform(int[] arr){

        //edge case
        if (arr.length == 0){
            return arr;
        }

        //step 1: copy and sort
        int[] sorted = arr.clone();
        Arrays.sort(sorted);

        //Step 2 : ssign reank
        Map<Integer,Integer> rankMap = new HashMap<>();

        int rank = 1;
       for (int num : sorted){
           if (!rankMap.containsKey(num)) {
               rankMap.put(num,rank++);
           }
       }


       //Step 3 :build result
        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            result[i] = rankMap.get(arr[i]);
        }
        return result;
    }


    public static void main(String[] args) {

        ArrayRankTransform sol = new ArrayRankTransform();

        int[] arr1 = {40,10,20,30};
        System.out.println(Arrays.toString(
                sol.arrayRankTransform(arr1)
        ));
        // [4,1,2,3]

        int[] arr2 = {100,100,100};
        System.out.println(Arrays.toString(
                sol.arrayRankTransform(arr2)
        ));
        // [1,1,1]
    }
}
