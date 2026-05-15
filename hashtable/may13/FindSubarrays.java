package hashtable.may13;

import java.util.*;

public class FindSubarrays {

    public boolean findSubarrays(int[] nums) {

        Set<Long> seenSums = new HashSet<>();

        for (int i = 0; i < nums.length - 1; i++) {

            long sum = (long) nums[i] + nums[i + 1];

            if (seenSums.contains(sum)) {
                return true;
            }

            seenSums.add(sum);
        }

        return false;
    }

//    public List<List<Integer>> findSubArray(int[] nums){
//        Map<Long,Integer> sumToIndexMap = new HashMap<>();
//
//        for (int i = 0; i < nums.length - 1; i++) {
//            long sum = (long) nums[i] + nums[i + 1];
//
//            if (sumToIndexMap.containsKey(sum)){
//                int previousIndex = sumToIndexMap.get(sum);
//
//                List<List<Integer>> result = new ArrayList<>();
//
//                result.add(Arrays.asList(nums[previousIndex],nums[previousIndex + 1]));
//                result.add(Arrays.asList(nums[i],nums[i + 1]));
//                return result;
//            }
//            sumToIndexMap.put(sum,i);
//        }
//        return new ArrayList<>();
//    }

    public static void main(String[] args) {
        FindSubarrays sol = new FindSubarrays();

        int[] nums1 = {4,2,4};
        System.out.println(sol.findSubarrays(nums1));

        int[] nums2 = {1,2,3,4,5};
        System.out.println(sol.findSubarrays(nums2));

        int[] nums3 = {0,0,0};
        System.out.println(sol.findSubarrays(nums3));


    }
}
