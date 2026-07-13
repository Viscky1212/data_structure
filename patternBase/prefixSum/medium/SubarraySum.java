package patternBase.prefixSum.medium;

import java.util.*;

public class SubarraySum {
    public int subarraySum(int[] nums, int k) {
        //prefixSum  -> how many times it appeared
        Map<Integer,Integer> map = new HashMap<>();

        map.put(0, 1);

        int prefixSum = 0;
        int count = 0;

        for(int num : nums){
            prefixSum += num;

            if(map.containsKey(prefixSum - k)){
                count += map.get(prefixSum - k);
            }

            map.put(prefixSum, map.getOrDefault(prefixSum,0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        SubarraySum solution = new SubarraySum();
        int[] nums = {1, 2, 3, 4, 5};
        int k = 9;
        int result = solution.subarraySum(nums, k);
        System.out.println("Result: " + result);
    }
}
