package slidingwindow.april07;

import java.util.HashMap;
import java.util.Map;

public class CountNiceSubarrays {

    //Prefix sum + hashMap
    public static  int numberOfSubarrays(int[] nums, int k){
        Map<Integer, Integer> map = new HashMap<>();

        map.put(0 , 1);

        int count = 0;
        int sum = 0;

        for (int num : nums){
            //convert to binary tree (odd = 1, even = 0)
            sum += (num % 2);
            if (map.containsKey(sum - k)){
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    //Sliding window helper
    public static int atMost(int[] nums, int k){
        int left = 0, count = 0, oddCount = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] % 2 == 1){
                oddCount++;
            }
            while (oddCount > k){
                if (nums[left] % 2 == 1){
                    oddCount--;
                }
                left++;
            }
            count += (right - left + 1);
        }
        return count;
    }
    //Sliding window main
    public static int numberOfSubarraysSW(int[] nums, int k){
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    //Brute force
    public static int bruteForce(int[] nums, int k){
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int odd = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] % 2 == 1) odd++;
                if (odd == k) count++;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        int[] nums1 = {1,1,2,1,1};
        int k1 = 3;

        System.out.println("Prefix Sum Result: " + numberOfSubarrays(nums1, k1));
        System.out.println("Sliding Window Result: " + numberOfSubarraysSW(nums1, k1));
        System.out.println("Brute Force Result: " + bruteForce(nums1, k1));

        int[] nums2 = {2,4,6};
        System.out.println("Test Case 2: " + numberOfSubarrays(nums2, 1));

        int[] nums3 = {2,2,2,1,2,2,1,2,2,2};
        System.out.println("Test Case 3: " + numberOfSubarrays(nums3, 2));
    }
}
