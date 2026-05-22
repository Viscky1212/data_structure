package sorting.may20;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DistinctAverages {

    public int distinctAverages(int[] nums){
        Arrays.sort(nums);
        System.out.println("Array after sort :" +Arrays.toString(nums));

        Set<Integer> set = new HashSet<>();

        int left = 0;
        int right = nums.length - 1;

        while (left < right){
            int sum = nums[left] + nums[right];
            System.out.println("Sum is " + sum);

            set.add(sum);
            left++;
            System.out.println("Left : " + left);
            right--;
            System.out.println("Right value : " + right);
        }
        int result = set.size();
        System.out.println("FInal result : " + result);
        return result;
    }

    public static void main(String[] args) {
        DistinctAverages sol = new DistinctAverages();

        int[] nums1 = {4, 1, 4, 0, 3, 5};
        System.out.println(sol.distinctAverages(nums1));
        // Output: 2

//        int[] nums2 = {1, 100};
//        System.out.println(sol.distinctAverages(nums2));
//        // Output: 1
    }
}
