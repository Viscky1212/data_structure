package hashtable.may13;

import java.util.HashMap;
import java.util.Map;

public class MostFrequentEven {

    public int mostFrequentEven(int[] nums) {

        Map<Integer, Integer> freqMap = new HashMap<>();

        // Count only even numbers
        for (int num : nums) {
            if (num % 2 == 0) {
                freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            }
        }

        int answer = -1;
        int maxFreq = 0;

        // Find most frequent even number
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {

            int num = entry.getKey();
            int freq = entry.getValue();

            if (freq > maxFreq) {
                maxFreq = freq;
                answer = num;
            } else if (freq == maxFreq && num < answer) {
                answer = num;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        MostFrequentEven sol = new MostFrequentEven();
        int[] nums1 = {0,1,2,2,4,4,1};
        System.out.println(sol.mostFrequentEven(nums1));
        // Output: 2

        int[] nums2 = {4,4,4,9,2,4};
        System.out.println(sol.mostFrequentEven(nums2));
        // Output: 4

        int[] nums3 = {29,47,21,41,13,37,25,7};
        System.out.println(sol.mostFrequentEven(nums3));
        // Output: -1
    }
}
