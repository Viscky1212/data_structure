package sorting.may20;

import java.util.HashMap;
import java.util.Map;

public class UnequalTriplets {

    public int unequalTriplets(int[] nums){
        Map<Integer,Integer> freqMap = new HashMap<>();
        System.out.println("Element in map : " + freqMap);
        for (int num : nums){
            freqMap.put(num,freqMap.getOrDefault(num,0) + 1);
            System.out.println("Key set : "+ freqMap.keySet());
            System.out.println("Value Set : "+ freqMap.values());
        }

        int left = 0;
        int right = nums.length;
        int answer = 0;

        for (int freq : freqMap.values()){

            right -= freq;
            System.out.println("Right pointer vlaue is : " + right);

            answer += left * freq * right;
            System.out.println("Answer is " + answer);

            left += freq;
            System.out.println("left pointer value is " + left);
        }

        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        UnequalTriplets sol = new UnequalTriplets();
        int[] nums1 = {4, 4, 2, 4, 3};
        System.out.println(sol.unequalTriplets(nums1));
        // Output: 3
//
//        int[] nums2 = {1, 1, 1, 1, 1};
//        System.out.println(sol.unequalTriplets(nums2));
//        // Output: 0
//
//        int[] nums3 = {1, 2, 3, 4};
//        System.out.println(sol.unequalTriplets(nums3));
//        // Output: 4
    }
}
