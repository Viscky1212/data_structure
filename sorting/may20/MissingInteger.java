package sorting.may20;

import java.util.HashSet;
import java.util.Set;

public class MissingInteger {

    public int missingInteger(int[] nums){
        Set<Integer> set = new HashSet<>();

        for (int num : nums){
            set.add(num);
        }

        int prefixSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1){
                prefixSum += nums[i];
            } else {
                break;
            }
        }

        int answer = prefixSum;

        while (set.contains(answer)){
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        MissingInteger sol = new MissingInteger();
        int[] nums1 = {1, 2, 3, 2, 5};
        System.out.println(sol.missingInteger(nums1));
        // Output: 6

        int[] nums2 = {3, 4, 5, 1, 12, 14, 13};
        System.out.println(sol.missingInteger(nums2));
        // Output: 15

        int[] nums3 = {5};
        System.out.println(sol.missingInteger(nums3));
        // Output: 6 if 5 exists, next missing >= 5 is 6
    }
}
