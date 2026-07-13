package patternBase.prefixSum.medium;

import java.util.*;

public class CheckSubarraySum {

    public boolean checkSubarraySum(int[] nums, int k) {

        //reminder -> first index where it appeared
        Map<Integer,Integer> map = new HashMap<>();

        //prefix sum reminder 0 before starting array
        map.put(0, -1);

        int prefixSum = 0;

        for(int i = 0; i < nums.length; i++){
            prefixSum += nums[i];

            int remainder = prefixSum % k;

            //if same remainder appeared before
            //subarray sum between them is divisible by k

            if(map.containsKey(remainder)){
                if(i - map.get(remainder) >= 2){
                    return true;
                }
            }  else{
                map.put(remainder, i);
            }
        }
        return false;

    }
    public static void main(String[] args) {
        CheckSubarraySum solution = new CheckSubarraySum();
        int[] nums = {23, 2, 4, 6, 7};
        int k = 6;
        boolean result = solution.checkSubarraySum(nums, k);
        System.out.println("Result: " + result);
    }
}
