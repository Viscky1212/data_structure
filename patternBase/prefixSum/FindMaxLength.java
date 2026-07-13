package patternBase.prefixSum;

import java.util.*;

public class FindMaxLength {

    public int findMaxLength(int[] nums) {
        int maxLength = 0;
        int prefixSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // Initialize with count 0 at index -1

        for (int i = 0; i < nums.length; i++) {
            prefixSum += (nums[i] == 0) ? -1 : 1;

            if (map.containsKey(prefixSum)) {
                maxLength = Math.max(maxLength, i - map.get(prefixSum));
            } else {
                map.put(prefixSum, i);
            }
        }

        return maxLength;
    }
    public static void main(String[] args) {
        FindMaxLength sol = new FindMaxLength();
        int[] nums = {0, 1};
        System.out.println(sol.findMaxLength(nums)); // Output: 2
    }
}
