package hashtable.may11;

import java.util.HashMap;
import java.util.Map;

public class MostFrequent {
//sol 6
    public int mostFrequent(int[] nums, int key){
        Map<Integer,Integer> freqMap = new HashMap<>();
        int maxFreq = 0;
        int ans = -1;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == key){
                int target = nums[i + 1];
                int freq = freqMap.getOrDefault(target,0) + 1;

                freqMap.put(target,freq);

                if (freq > maxFreq){
                    maxFreq = freq;
                    ans = target;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MostFrequent sol = new MostFrequent();
        int[] nums1 = {1,100,200,1,100};
        System.out.println(sol.mostFrequent(nums1, 1));
        // 100

        int[] nums2 = {2,2,2,2,3};
        System.out.println(sol.mostFrequent(nums2, 2));
        // 2
    }
}
