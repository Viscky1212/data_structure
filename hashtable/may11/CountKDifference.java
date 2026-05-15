package hashtable.may11;

import java.util.HashMap;
import java.util.Map;

public class CountKDifference {

    // sol : 3
    public int countKDifference(int[] nums, int k){
        Map<Integer,Integer> freqMap = new HashMap<>();
        int count = 0;
        for (int num : nums){
            count += freqMap.getOrDefault(num - k, 0);
            count += freqMap.getOrDefault(num + k, 0);
            freqMap.put(num,freqMap.getOrDefault(num,0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {

        CountKDifference sol = new CountKDifference();

        int[] nums1 = {1,2,2,1};
        System.out.println(sol.countKDifference(nums1, 1)); // 4

        int[] nums2 = {1,3};
        System.out.println(sol.countKDifference(nums2, 3)); // 0

        int[] nums3 = {3,2,1,5,4};
        System.out.println(sol.countKDifference(nums3, 2)); // 3
    }
}
