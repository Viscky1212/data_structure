package two_pointer_problem;

import java.util.Arrays;

public class TriangleNumber {

    public static int triangleNumber(int[] nums){
        int n = nums.length;
        int count = 0;

        Arrays.sort(nums);

        for (int k = n - 1; k >= 2 ; k--) {
            int i = 0;
            int j = k - 1;

            while (i < j){
                if (nums[i] + nums[j] > nums[k]){
                    count += j - i;
                    j--;
                } else {
                    i++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,3,4};

        int result = triangleNumber(nums);

        System.out.println("Number of valid triangles: " + result);
    }
}
