package two_pointer_problem;

import java.util.HashSet;
import java.util.Set;

public class LargestPositiveWithNegativeApp {

    public static void main(String[] args) {
        LargestPositiveWithNegativeApp solution = new LargestPositiveWithNegativeApp();

        int[] nums1 = {-1, 2, -3, 3};
        int[] nums2 = {-1, 10, 6, 7, -7, 1};
        int[] nums3 = {-10, 8, 6, 7, -2, -3};

        System.out.println(solution.findMaxK(nums1)); // 3
        System.out.println(solution.findMaxK(nums2)); // 7
        System.out.println(solution.findMaxK(nums3)); // -1
    }

    public int findMaxK(int[] nums) {
        Set<Integer> set = new HashSet<>();

        //Add all element
        for (int num : nums){
            set.add(num);
        }
        int max = -1;

        for (int num : nums){

            //check only positive numbers
            if (num > 0 && set.contains(-num)){
                max = Math.max(max,num);
            }
        }
        return max;

    }
    }
