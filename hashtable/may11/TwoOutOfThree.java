package hashtable.may11;

import java.util.*;
//sol : 4
public class TwoOutOfThree {

    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3){
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Set<Integer> set3 = new HashSet<>();

        for (int num : nums1){
            set1.add(num);
        }

        for (int num : nums2){
            set2.add(num);
        }

        for (int num : nums3){
            set3.add(num);
        }

        Map<Integer,Integer> freqMap = new HashMap<>();

        for (int num : set1){
            freqMap.put(num, freqMap.getOrDefault(num,0) + 1);
        }


        for (int num : set2){
            freqMap.put(num, freqMap.getOrDefault(num,0) + 1);
        }


        for (int num : set3){
            freqMap.put(num, freqMap.getOrDefault(num,0) + 1);
        }

        List<Integer> result = new ArrayList<>();
        for (int num : freqMap.keySet()){
            if (freqMap.get(num) >= 2){
                result.add(num);
            }
        }
        return result;
    }


    public static void main(String[] args) {

        TwoOutOfThree sol = new TwoOutOfThree();

        int[] nums1 = {1,1,3,2};
        int[] nums2 = {2,3};
        int[] nums3 = {3};

        System.out.println(
                sol.twoOutOfThree(nums1, nums2, nums3)
        );
        // [2,3]
    }
}
