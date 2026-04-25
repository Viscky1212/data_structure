package binarySearch.april24;

import java.util.Stack;

public class Find132pattern {

    public boolean find132pattern(int[] nums){
        int third = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < third){
                return true;
            }
            while (!stack.isEmpty() && nums[i] > stack.peek()){
                third = stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        Find132pattern solution = new Find132pattern();
        int[] nums1 = {1, 2, 3, 4};
        System.out.println(solution.find132pattern(nums1)); // false

        int[] nums2 = {3, 1, 4, 2};
        System.out.println(solution.find132pattern(nums2)); // true

        int[] nums3 = {-1, 3, 2, 0};
        System.out.println(solution.find132pattern(nums3)); // true
    }
}
