package hash_hashing.practice;

import java.util.*;

public class NumberOfExcellency {

    public static long countExcellentPairs(int[] nums, int k){
      //step 1 : remove duplicate
        Set<Integer> unique = new HashSet<>();

        for(int num : nums){
            unique.add(num);
        }

        Map<Integer,Integer> bitCountFreq = new HashMap<>();
        for (int num : unique){
           int bits = Integer.bitCount(num);
           bitCountFreq.put(bits,bitCountFreq.getOrDefault(bits, 0) + 1);
        }

        //step 3 : count pair
       long count = 0;

        for(int b1 : bitCountFreq.keySet()){
            for (int b2 : bitCountFreq.keySet()){
                if (b1 + b2 >= k){
                     count = (long) bitCountFreq.get(b1) * bitCountFreq.get(b2);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,1};
        int k1 = 3;

       long res1 = countExcellentPairs(nums1,k1);
        System.out.println("Excellent Pairs : "+ res1);

        int[] nums2 = {5,1,1};
        int k2 = 10;

        long res2 = countExcellentPairs(nums2,k2);
        System.out.println("Excellent Pairs : "+ res2);

    }
}
