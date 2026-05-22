package sorting.may21;

import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

public class MaxKDistinct {

    public int[] maxKDistinct(int[] nums, int k){
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());

        for (int num : nums){
            set.add(num);
        }

        int resultSize = Math.min(k, set.size());
        int[] result = new int[resultSize];

        int index = 0;
        for (int num : set){
            if (index == resultSize){
                break;
            }
            result[index++] = num;
        }
        return result;
    }

    public static void main(String[] args) {
        MaxKDistinct sol = new MaxKDistinct();
        int[] nums1 = {84, 93, 100, 77, 90};
        System.out.println(Arrays.toString(sol.maxKDistinct(nums1, 3)));
        // Output: [100, 93, 90]

        int[] nums2 = {84, 93, 100, 77, 93};
        System.out.println(Arrays.toString(sol.maxKDistinct(nums2, 3)));
        // Output: [100, 93, 84]

        int[] nums3 = {1, 1, 1, 2, 2, 2};
        System.out.println(Arrays.toString(sol.maxKDistinct(nums3, 6)));
        // Output: [2, 1]
    }
}
