package hash_hashing.practice;

import java.util.*;

public class LargestSubArrayWithZeroSum {



   public static int largestSubArrayWithZeroSum(int arr[], int n){
       //Map : prefixSum  -> first index
       Map<Integer,Integer> map = new HashMap<>();
       int prefixSum = 0;
       int maxLength= 0;

       for(int i = 0; i < n; i++){
           prefixSum += arr[i];

           //if prefix sum is 0
           if(prefixSum == 0){
               maxLength = i + 1;
           }
           //prefix  sum seen before
           if(map.containsKey(prefixSum)){
               int previousIndex = map.get(prefixSum);
               maxLength = Math.max(maxLength, i - previousIndex);
           } else{
               //store first occurrence only
               map.put(prefixSum, i);
           }
       }

      return maxLength;
   }

    public static void main(String[] args) {
       int arr1[] = {15,-2,2,-8,1,7,10,23};
       int res1 = largestSubArrayWithZeroSum(arr1,arr1.length);
        System.out.println("Longest zero sum subarray : "+res1);

        int[] arr2 = {-1, 2, -3, 4, -5};
        int result2 = largestSubArrayWithZeroSum(arr2, arr2.length);
        System.out.println("Longest Zero Sum Subarray Length: " + result2);

    }
}
