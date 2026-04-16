package two_pointer_problem;

import java.util.ArrayList;
import java.util.Arrays;

public class RotateArray {
    public static void rotate(int[] nums, int k){
        int n = nums.length;

        k = k % n; //handle large k
        for (int i = 0; i < k; i++) {
            int last = nums[n - 1];
            for (int j = n - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = last;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }
}
