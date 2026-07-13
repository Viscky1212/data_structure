package patternBase.slowFast;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicate {
 //   public int findDuplicate(int[] nums) {
 //       Set<Integer> seen = new HashSet<>();
//        while (true) {
//            for (int num : nums) {
//                if (seen.contains(num)) {
//                    return num;
//                }
//                seen.add(num);
//            }
//        }


    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        System.out.println("Starting slow pointer at index: " + slow + ", value: " + nums[slow]);
        int fast = nums[0];
        System.out.println("Starting fast pointer at index: " + fast + ", value: " + nums[fast]);

        // Phase 1: Finding the intersection point of the two runners.
        do {
            slow = nums[slow];
            System.out.println("Slow pointer at index: " + slow + ", value: " + nums[slow]);
            fast = nums[nums[fast]];
            System.out.println("Fast pointer at index: " + fast + ", value: " + nums[fast]);
        } while (slow != fast);

        // Phase 2: Find the entrance to the cycle.
        slow = nums[0];
        System.out.println("Resetting slow pointer to index: " + slow + ", value: " + nums[slow]);
        while (slow != fast) {
            slow = nums[slow];
            System.out.println("Slow pointer at index: " + slow + ", value: " + nums[slow]);
            fast = nums[fast];
            System.out.println("Fast pointer at index: " + fast + ", value: " + nums[fast]);
        }
        System.out.println("Duplicate found at index: " + slow + ", value: " + nums[slow]);

        return slow;
    }

    public static void main(String[] args) {
        FindDuplicate sol = new FindDuplicate();
        int[] nums1 = {1, 3, 4, 2, 2};
        System.out.println(sol.findDuplicate(nums1)); // Output: 2
//
//        int[] nums2 = {3, 1, 3, 4, 2};
//        System.out.println(sol.findDuplicate(nums2)); // Output: 3
    }
}
