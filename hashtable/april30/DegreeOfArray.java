package hashtable.april30;

import java.util.HashMap;
import java.util.Map;

public class DegreeOfArray {

    public int findShortestSubArray(int[] nums){
        Map<Integer,Integer> freq = new HashMap<>();
        Map<Integer,Integer> first = new HashMap<>();

        int degree = 0;
        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            //record first occurrence
            if (!first.containsKey(num)) first.put(num, i);

            //update freq
            freq.put(num,freq.getOrDefault(num, 0) + 1);
            int currentFreq = freq.get(num);

            //update degree and answer
            if (currentFreq > degree){
                degree = currentFreq;
                minLength = i - first.get(num) + 1;
            } else if (currentFreq == degree){
                minLength = Math.min(minLength, i - first.get(num) + 1);
            }
        }
        return minLength;
    }

    public static void main(String[] args) {
        DegreeOfArray sol = new DegreeOfArray();

        int[] nums1 = {1,2,2,3,1};
        System.out.println(sol.findShortestSubArray(nums1)); // 2

        int[] nums2 = {1,2,2,3,1,4,2};
        System.out.println(sol.findShortestSubArray(nums2)); // 6
    }
}
