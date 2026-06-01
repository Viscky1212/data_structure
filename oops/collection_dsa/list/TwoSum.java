package oops.collection_dsa.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TwoSum {



//    public void add(int num) {
//        numToIndex.put(num, numToIndex.size());
//    }

//    public int[] twoSum(int[] nums, int target) {
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] + nums[j] == target) {
//                    return new int[]{i, j};
//                }
//            }
//        }
//        return new int[]{-1, -1}; // Return -1 if no solution is found
//    }

    private final List<Integer> numbers;

    public TwoSum() {
        numbers = new ArrayList<>();
    }

    public void add(int num) {
        numbers.add(num);
        Collections.sort(numbers);
    }

    public boolean find(int target) {
        int left = 0;
        int right = numbers.size() - 1;

        while (left < right) {
            int sum = numbers.get(left) + numbers.get(right);
            if (sum == target) {
                return true;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        TwoSum sol = new TwoSum();
//        int[] nums1 = {2, 7, 11, 15};
//        int target1 = 9;
            sol.add(2);
            sol.add(7);
            sol.add(11);
            sol.add(15);
        System.out.println(sol.find(9));
//        int[] result1 = sol.twoSum(nums1, target1);
//        System.out.println("Output: [" + result1[0] + ", " + result1[1] + "]");


//        int[] nums2 = {3, 2, 4};
//        int target2 = 6;
            sol.add(3);
            sol.add(2);
            sol.add(4);
        System.out.println(sol.find(6));
//        int[] result2 = sol.twoSum(nums2, target2);
//        System.out.println("Output: [" + result2[0] + ", " + result2[1] + "]");

    }
}
