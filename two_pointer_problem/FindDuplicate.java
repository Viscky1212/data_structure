package two_pointer_problem;

import java.util.*;

public class FindDuplicate {

    public static int findDuplicate(int[] nums){
        int slow = nums[0];
        int fast = nums[0];

        //phase 1 : Detect cycle
        do {
            slow  = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        //Phase 2 : Find cycle entry (duplicate)
        slow = nums[0];

        while (slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};

        int duplicate = findDuplicate(nums);
        System.out.println("Duplicate number : " + duplicate);
    }
}
