package slidingwindow.april06;

import java.util.HashMap;
import java.util.Map;

public class BinarySubarraysWithSum {

    //Prefix + HashMap
    public int numSubarraysWithSum(int[] nums, int goal){
        Map<Integer,Integer> map = new HashMap<>();

        map.put(0, 1); //base case
        int sum = 0;
        int count = 0;

        for (int num : nums){
            sum += num;

            //check if (sum - goal ) exists
            if (map.containsKey(sum - goal)){
                count += map.get(sum - goal);
            }

            //Store current sum
            map.put(sum,map.getOrDefault(sum,0) + 1);
        }
        return count;
    }

    //Sliding Window Helper
    public int alMost(int[] nums,int goal){
        if (goal < 0) return 0;

        int left = 0, sum = 0, count = 0;

        for (int right = 0; right <nums.length ; right++) {
            sum += nums[right];

            while (sum > goal){
                sum -= nums[left];
                left++;
            }
            count += (right - left + 1);
        }
        return count;
    }

    //Sliding window
    public int numSubarraysWithSumSW(int[] nums , int goal){
        return alMost(nums, goal) - alMost(nums, goal - 1);
    }

    //Brute force
    public int bruteForce(int[] nums, int goal){
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == goal) count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        BinarySubarraysWithSum sol = new BinarySubarraysWithSum();

        int[] nums1 = {1, 0, 1, 0, 1};
        int goal1 = 2;

        System.out.println("Prefix Sum Result: " + sol.numSubarraysWithSum(nums1, goal1));
        System.out.println("Sliding Window Result: " + sol.numSubarraysWithSumSW(nums1, goal1));
        System.out.println("Brute Force Result: " + sol.bruteForce(nums1, goal1));

        int[] nums2 = {0, 0, 0, 0, 0};
        int goal2 = 0;

        System.out.println("Test Case 2: " + sol.numSubarraysWithSum(nums2, goal2));

    }

}
