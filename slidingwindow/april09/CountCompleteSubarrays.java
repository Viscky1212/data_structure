package slidingwindow.april09;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountCompleteSubarrays {
    public int countCompleteSubarrays(int[] nums){
        //Step 1 : Find total distinct element
        Set<Integer> set = new HashSet<>();

        for (int num : nums){
            set.add(num);
        }
        int k = set.size();
        //step 2 : Use formula
        return countAtMost(nums, k) - countAtMost(nums , k - 1);
    }

    //Helper function : count subarrays with at most k distinct element
    public int countAtMost(int[] nums, int k){
        Map<Integer,Integer> freq = new HashMap<>();
        int left = 0;
        int count = 0;

        for (int right = 0; right < nums.length; right++) {
            freq.put(nums[right], freq.getOrDefault(nums[right],0) + 1);

            //Shrink window if distinct > k
            while (freq.size() > k){
                freq.put(nums[left], freq.get(nums[left]) - 1);

                if (freq.get(nums[left]) == 0){
                    freq.remove(nums[left]);
                }
                left++;
            }
            //All subarrays ending at right
            count += (right - left + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        CountCompleteSubarrays sol = new CountCompleteSubarrays();

        int[] nums1 = {1, 3, 1, 2, 2};
        System.out.println(sol.countCompleteSubarrays(nums1)); // Output: 4

        int[] nums2 = {5, 5, 5, 5};
        System.out.println(sol.countCompleteSubarrays(nums2)); // Output: 10
    }
}
