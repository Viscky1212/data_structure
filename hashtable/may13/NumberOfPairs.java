package hashtable.may13;

import java.util.Arrays;

public class NumberOfPairs {
    public int[] numberOfPairs(int[] nums){
        int[] freq = new int[101];

        //count frrq of each number
        for (int num : nums){
            freq[num]++;
        }

        int pairs = 0;
        int leftOver = 0;

        //calculate pairs and leftOvers
        for (int count : freq){
            pairs += count/2;
            leftOver += count % 2;
        }
        return new int[] {pairs,leftOver};
    }


    public static void main(String[] args) {
        NumberOfPairs sol = new NumberOfPairs();
        int[] nums = {1,2,3,1,2,2,3};
        System.out.println(Arrays.toString(sol.numberOfPairs(nums)));
    }
}
