package hash_hashing.practice;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {

    public static int longestConsecutive(int[] A){
        //Step 1: store element in set
        Set<Integer> set = new HashSet<>();

        for(int num : A){
            set.add(num);
        }
        int maxLength = 0;

        //step 2 : check for sequence start
        for (int num : set){
            //only start if previous element not present
            if(!set.contains(num - 1)){
                int currentNum = num;
                int currentLength = 1;

                //expand sequence
                while (set.contains(currentNum + 1)){
                    currentNum++;
                    currentLength++;
                }
              maxLength =  Math.max(maxLength,currentLength);
            }
        }
        return maxLength;
    }


    public static void main(String[] args) {

        int[] arr1 = { 1, 2 , 0 ,1};
        System.out.println(longestConsecutive(arr1));

        int[] arr2 = {1,3,2,4,5,15,10};
        System.out.println(longestConsecutive(arr2));

    }
}
