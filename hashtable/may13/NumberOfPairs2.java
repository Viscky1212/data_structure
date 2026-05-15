package hashtable.may13;

import java.util.Arrays;

public class NumberOfPairs2 {

    public int[] numberOfPairs(int[] nums){

        int[] freq = new int[101];

        //count freq of each number
        for (int num : nums){
            freq[num]++;
        }

        int pairs = 0;
        int leftOver = 0;

        //calculate pairs and leftover number
        for (int count : freq){
            pairs += count/2;
            leftOver += count % 2;
        }

        return new int[]{pairs,leftOver};
    }

    public static void main(String[] args) {
        NumberOfPairs2 sol = new NumberOfPairs2();
        int[] nums1 = {1, 3, 2, 1, 3, 2, 2};
        System.out.println(Arrays.toString(sol.numberOfPairs(nums1)));
        // Output: [3, 1]

        int[] nums2 = {1, 1};
        System.out.println(Arrays.toString(sol.numberOfPairs(nums2)));
        // Output: [1, 0]

        int[] nums3 = {0};
        System.out.println(Arrays.toString(sol.numberOfPairs(nums3)));
        // Output: [0, 1]
    }
}
