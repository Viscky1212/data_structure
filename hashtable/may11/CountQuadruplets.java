package hashtable.may11;

import java.util.HashMap;
import java.util.Map;

public class CountQuadruplets {

    public int countQuadruplets(int[] nums) {

        int n = nums.length;

        int count = 0;

        Map<Integer, Integer> map = new HashMap<>();

        // b is second index
        for (int b = n - 3; b >= 1; b--) {

            // Build valid differences for c and d
            for (int d = b + 2; d < n; d++) {

                int diff = nums[d] - nums[b + 1];

                map.put(diff, map.getOrDefault(diff, 0) + 1);
            }

            // Find matching a+b
            for (int a = 0; a < b; a++) {

                int sum = nums[a] + nums[b];

                count += map.getOrDefault(sum, 0);
            }
        }

        return count;
    }

    public static void main(String[] args) {

        CountQuadruplets sol = new CountQuadruplets();

        int[] nums1 = {1,2,3,6};
        System.out.println(sol.countQuadruplets(nums1)); // 1

        int[] nums2 = {1,1,1,3,5};
        System.out.println(sol.countQuadruplets(nums2)); // 4
    }
}
