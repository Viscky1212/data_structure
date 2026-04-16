package slidingwindow.april09;

import java.util.*;

public class LongestEqualSubarray {

    public int longestEqualSubarray(List<Integer> num, int k){
        //Step 1 : Group indices by value
        Map<Integer,List<Integer>> map = new HashMap<>();

        for (int i = 0; i < num.size(); i++) {
            map.computeIfAbsent(num.get(i), key -> new ArrayList<>()).add(i);
        }

        int maxLen = 0;

        //Step 2 : Process each value group
        for (List<Integer> positions : map.values()){
            int left = 0;
            for (int right = 0; right < positions.size(); right++) {
                //shrink window if deletions exceed k
                while (positions.get(right) - positions.get(left) - (right - left) > k){
                    left++;
                }
                //update max length
                maxLen = Math.max(maxLen,right - left + 1);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LongestEqualSubarray sol = new LongestEqualSubarray();

        List<Integer> nums1 = Arrays.asList(1,3,2,3,1,3);
        System.out.println(sol.longestEqualSubarray(nums1, 3)); // Output: 3

        List<Integer> nums2 = Arrays.asList(1,1,2,2,1,1);
        System.out.println(sol.longestEqualSubarray(nums2, 2)); // Output: 4
    }
}
