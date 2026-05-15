package hashtable.may11;

import java.util.*;
//sol : 8
public class FindDifference {

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int num : nums1){
            set1.add(num);
        }
        for (int num : nums2){
           set2.add(num);
        }

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        //Element in set1 but not in set2
        for (int num : set1){
            if (!set2.contains(num)){
                list1.add(num);
            }
        }

        //Element in set2 but not in set1
        for (int num : set2){

            if (!set1.contains(num)) {
                list2.add(num);
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        result.add(list1);
        result.add(list2);

        return result;
    }


        public static void main(String[] args) {
        FindDifference sol = new FindDifference();
        int[] nums1 = {1,2,3};
        int[] nums2 = {2,4,6};

        System.out.println(
                sol.findDifference(nums1, nums2)
        );

        // [[1,3],[4,6]]
    }
}
