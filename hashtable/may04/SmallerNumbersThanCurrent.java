package hashtable.may04;

import java.util.Arrays;

public class SmallerNumbersThanCurrent {

    public int[] smallerNumbersThanCurrent(int[] nums){
        int[] freq = new int[101];

        //Step 1: count frequency
        for (int num : nums){
            freq[num]++;
        }

        //step 2 : prefix sum
        for (int i = 1; i < 101; i++) {
            freq[i] += freq[i - 1];
        }

        //step 3 : build result
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0){
                result[i] = 0;
            } else {
                result[i] = freq[nums[i] - 1];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SmallerNumbersThanCurrent sol = new SmallerNumbersThanCurrent();
        System.out.println(Arrays.toString(
                sol.smallerNumbersThanCurrent(new int[]{8,1,2,2,3})
        )); // [4,0,1,1,3]

        System.out.println(Arrays.toString(
                sol.smallerNumbersThanCurrent(new int[]{6,5,4,8})
        )); // [2,1,0,3]

        System.out.println(Arrays.toString(
                sol.smallerNumbersThanCurrent(new int[]{7,7,7,7})
        )); // [0,0,0,0]
    }
}
