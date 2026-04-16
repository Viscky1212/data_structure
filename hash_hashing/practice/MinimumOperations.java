package hash_hashing.practice;

import java.util.*;

public class MinimumOperations {
    public static int minimumOperations(int[] nums) {

        int n = nums.length;

        // Edge case
        if(n <= 1) return 0;

        Map<Integer, Integer> evenMap = new HashMap<>();
        Map<Integer, Integer> oddMap = new HashMap<>();

        // Step 1: count frequencies
        for(int i = 0; i < n; i++){
            if(i % 2 == 0){
                evenMap.put(nums[i], evenMap.getOrDefault(nums[i], 0) + 1);
            } else {
                oddMap.put(nums[i], oddMap.getOrDefault(nums[i], 0) + 1);
            }
        }

        // Step 2: get top 2 frequent elements
        int[] evenTop = getTopTwo(evenMap);
        int[] oddTop = getTopTwo(oddMap);

        int evenMaxVal = evenTop[0], evenMaxFreq = evenTop[1];
        int evenSecondFreq = evenTop[3];

        int oddMaxVal = oddTop[0], oddMaxFreq = oddTop[1];
        int oddSecondFreq = oddTop[3];

        // Step 3: compute result
        if(evenMaxVal != oddMaxVal){
            return n - (evenMaxFreq + oddMaxFreq);
        } else {
            return n - Math.max(
                    evenMaxFreq + oddSecondFreq,
                    evenSecondFreq + oddMaxFreq
            );
        }
    }

    // helper: returns [maxVal, maxFreq, secondVal, secondFreq]
    private static int[] getTopTwo(Map<Integer, Integer> map){

        int maxVal = -1, maxFreq = 0;
        int secondVal = -1, secondFreq = 0;

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){

            int val = entry.getKey();
            int freq = entry.getValue();

            if(freq > maxFreq){
                secondFreq = maxFreq;
                secondVal = maxVal;

                maxFreq = freq;
                maxVal = val;

            } else if(freq > secondFreq){
                secondFreq = freq;
                secondVal = val;
            }
        }

        return new int[]{maxVal, maxFreq, secondVal, secondFreq};
    }

    // 🔥 MAIN METHOD
    public static void main(String[] args) {

        MinimumOperations sol = new MinimumOperations();

        int[] nums1 = {3,1,3,2,4,3};
        System.out.println(sol.minimumOperations(nums1)); // 3

        int[] nums2 = {1,2,2,2,2};
        System.out.println(sol.minimumOperations(nums2)); // 2
    }
}