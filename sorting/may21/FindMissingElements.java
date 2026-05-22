package sorting.may21;

import java.util.ArrayList;
import java.util.List;

public class FindMissingElements {

    public List<Integer> findMissingElements(int[] nums){
        boolean[] present = new boolean[101];

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums){
            present[num] = true;
            min = Math.min(min,num);
            max = Math.max(max,num);
        }

        List<Integer> result = new ArrayList<>();

        for (int value = min; value <= max; value++) {
            if (!present[value]){
                result.add(value);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        FindMissingElements sol = new FindMissingElements();
        int[] nums1 = {1, 4, 2, 5};
        System.out.println(sol.findMissingElements(nums1));
        // Output: [3]

        int[] nums2 = {7, 8, 6, 9};
        System.out.println(sol.findMissingElements(nums2));
        // Output: []

        int[] nums3 = {5, 1};
        System.out.println(sol.findMissingElements(nums3));
        // Output: [2, 3, 4]

        int[] nums4 = {1, 2};
        System.out.println(sol.findMissingElements(nums4));
        // Output: []
    }
}
