package hash_hashing.practice;

import java.util.*;

public class MinSetSize {

    public static int minSetSize(int[] arr){
        //count freq
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2 : collect freq
        List<Integer> freqList = new ArrayList<>(map.values());

        Collections.sort(freqList,Collections.reverseOrder());

        int removed = 0, count = 0;
        int half = arr.length / 2;

        //step 4 : pick largest freq
        for (int freq : freqList){
            removed += freq;
            count++;

            if (removed >= half){
                return count;
            }
        }
        return count;

    }

    public static void main(String[] args) {

        int[] arr1 = {3,3,3,3,5,5,5,2,2,7};
        System.out.println(minSetSize(arr1));


        int[] arr2 = {7,7,7,7,7,7};
        System.out.println(minSetSize(arr2));
    }
}
