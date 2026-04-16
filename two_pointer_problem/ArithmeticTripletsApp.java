package two_pointer_problem;

import java.util.HashSet;
import java.util.Set;

public class ArithmeticTripletsApp {
    public static void main(String[] args) {

        ArithmeticTripletsApp solution = new ArithmeticTripletsApp();
        int[] nums1 = {0,1,4,6,7,10};
        int diff1 = 3;

        int[] nums2 = {4,5,6,7,8,9};
        int diff2 = 2;

        System.out.println(solution.arithmeticTriplets(nums1, diff1)); // 2
        System.out.println(solution.arithmeticTriplets(nums2, diff2)); // 2
    }

    public int arithmeticTriplets(int[] nums, int diff){
        Set<Integer> set = new HashSet<>();

        //find all element to set
        for (int num : nums){
            set.add(num);
        }

        int count = 0;

        for (int num : nums){
            //check if num, nums + diff, num + 2 * diff exist
            if (set.contains(num + diff)  && set.contains(num + 2 * diff)){
                count++;
            }
        }
        return count;
    }
}
