package two_pointer_problem.march30;

import java.util.Arrays;

public class MaxNumber {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {

        int m = nums1.length, n = nums2.length;
        int[] result = new int[k];

        for (int i = Math.max(0, k - n); i <= Math.min(k, m); i++) {

            int[] part1 = maxSubsequence(nums1, i);
            int[] part2 = maxSubsequence(nums2, k - i);

            int[] candidate = merge(part1, part2);

            if (greater(candidate, 0, result, 0)) {
                result = candidate;
            }
        }

        return result;
    }

    // Get max subsequence of size k
    private int[] maxSubsequence(int[] nums, int k) {

        int[] stack = new int[k];
        int top = -1;
        int remain = nums.length;

        for (int num : nums) {

            while (top >= 0 && stack[top] < num && remain > k - top - 1) {
                top--;
            }

            if (top + 1 < k) {
                stack[++top] = num;
            }

            remain--;
        }

        return stack;
    }

    // Merge two arrays greedily
    private int[] merge(int[] nums1, int[] nums2) {

        int[] result = new int[nums1.length + nums2.length];
        int i = 0, j = 0, r = 0;

        while (i < nums1.length || j < nums2.length) {

            if (greater(nums1, i, nums2, j)) {
                result[r++] = nums1[i++];
            } else {
                result[r++] = nums2[j++];
            }
        }

        return result;
    }

    // Compare remaining arrays
    private boolean greater(int[] nums1, int i, int[] nums2, int j) {

        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }

        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }


    public static void main(String[] args) {
        MaxNumber sol = new MaxNumber();
        int[] nums1 = {3,4,6,5};
        int[] nums2 = {9,1,2,5,8,3};
        int k = 5;

        int[] result = sol.maxNumber(nums1, nums2, k);

        System.out.println("Max Number: " + Arrays.toString(result));
        // Output: [9,8,6,5,3]
    }
}
