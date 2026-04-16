package slidingwindow.april03.april04;

import java.util.*;

public class MinimumPositiveSumSubarray {

    public int minimumSumSubarray(List<Integer> nums, int l, int r){
        int n = nums.size();
        int minSum = Integer.MAX_VALUE;

        //Try all starting points

        for (int i = 0; i < n; i++) {
            int sum = 0;

            //expand window
            for (int j = i; j < n && j < i + r; j++) {
                sum += nums.get(j);

                int len = j - i + 1;

                //check valid length
                if (len >= l && sum > 0 ){
                    minSum = Math.min(minSum, sum);
                }
            }
        }
        return minSum == Integer.MAX_VALUE ? -1 : minSum;
    }


    public static void main(String[] args) {
        MinimumPositiveSumSubarray sol = new MinimumPositiveSumSubarray();
        List<Integer> nums1 = Arrays.asList(3, -2, 1, 4);
        int l1 = 2, r1 = 3;

        List<Integer> nums2 = Arrays.asList(-2, 2, -3, 1);
        int l2 = 2, r2 = 3;

        System.out.println(sol.minimumSumSubarray(nums1, l1, r1)); // 1
        System.out.println(sol.minimumSumSubarray(nums2, l2, r2)); // -1 ✅
    }
}
