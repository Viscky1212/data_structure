package slidingwindow.april09;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximumSumAlmostUnique {

    public long maxSum(List<Integer> nums, int m , int k){
        Map<Integer,Integer> freq = new HashMap<>();
        long windowSum = 0;
        long mazSum = 0;

        int left = 0;
        for (int right = 0; right < nums.size(); right++) {

            int val = nums.get(right);

            //add element
            windowSum += val;
            freq.put(val, freq.getOrDefault(val, 0) + 1);

            //maintain window size
            if (right - left + 1 > k){
                int leftVal = nums.get(left);

                windowSum -= leftVal;

                freq.put(leftVal, freq.get(leftVal)  - 1);
                if (freq.get(leftVal) == 0){
                    freq.remove(leftVal);
                }
                left++;
            }
            //check condition
            if (right - left + 1 == k){
                if (freq.size() >= m){
                    mazSum = Math.max(mazSum, windowSum);
                }
            }
        }
        return mazSum;
    }


    // Main method
    public static void main(String[] args) {
        MaximumSumAlmostUnique sol = new MaximumSumAlmostUnique();

        List<Integer> nums1 = Arrays.asList(2,6,7,3,1,7);
        System.out.println(sol.maxSum(nums1, 3, 4)); // Output: 18

        List<Integer> nums2 = Arrays.asList(5,9,9,2,4,5,4);
        System.out.println(sol.maxSum(nums2, 1, 3)); // Output: 23

        List<Integer> nums3 = Arrays.asList(1,2,1,2,1,2,1);
        System.out.println(sol.maxSum(nums3, 3, 3)); // Output: 0
    }
}
