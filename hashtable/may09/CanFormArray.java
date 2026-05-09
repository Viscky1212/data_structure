package hashtable.may09;

import java.util.HashMap;
import java.util.Map;

//problem 5

public class CanFormArray {

    public boolean canFormArray(int[] arr, int[][] pieces){
        //Step 1: map first element -> piece
        Map<Integer,int[]> map = new HashMap<>();

        for (int[] piece : pieces){
            map.put(piece[0],piece);
        }

        int i = 0;
        //step 2 : match arr
        while (i < arr.length){
            if (!map.containsKey(arr[i])){
                return false;
            }

            int[] piece = map.get(arr[i]);

            for (int num : piece){
                if (arr[i] != num){
                    return false;
                }
                i++;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        CanFormArray sol = new CanFormArray();

        System.out.println(sol.canFormArray(
                new int[]{15,88}, new int[][]{{88},{15}}
        )); // true

        System.out.println(sol.canFormArray(
                new int[]{49,18,16}, new int[][]{{16,18,49}}
        )); // false

        System.out.println(sol.canFormArray(
                new int[]{91,4,64,78}, new int[][]{{78},{4,64},{91}}
        )); // true
    }

}
