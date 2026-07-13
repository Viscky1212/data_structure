package patternBase.prefixSum;

import java.util.HashMap;
import java.util.Map;

public class SubarraysDivByK {
//    public int subarraysDivByK(int[] nums, int k) {
//        int count = 0;
//        int prefixSum = 0;
//        int[] modCount = new int[k];
//        modCount[0] = 1; // Initialize for the case when prefixSum % k == 0
//
//        for (int num : nums) {
//            prefixSum += num;
//            int mod = ((prefixSum % k) + k) % k; // Handle negative mods
//            count += modCount[mod];
//            modCount[mod]++;
//        }
//
//        return count;
//    }

public int subarraysDivByK(int[] nums, int k) {
       Map<Integer, Integer> map = new HashMap<>();
       map.put(0, 1);

       int prefixSum = 0;
       int count = 0;
       for (int num : nums) {
           prefixSum += num;

           int reminder = prefixSum % k;
              if (reminder < 0) {
                  reminder += k;
              }
           count += map.getOrDefault(reminder, 0);
           map.put(reminder, map.getOrDefault(reminder, 0) + 1);
       }

        return count;
    }

    public static void main(String[] args) {
        SubarraysDivByK sol = new SubarraysDivByK();
        int[] nums = {4, 5, 0, -2, -3, 1};
        int k = 5;
        System.out.println(sol.subarraysDivByK(nums, k)); // Output: 7
    }
}
