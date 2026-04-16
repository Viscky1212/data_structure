package slidingwindow.april10;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k){
        if (nums == null || nums.length == 0) return new int[0];

        int n = nums.length;
        int[] result = new int[n - k + 1];

        Deque<Integer> dp = new LinkedList<>();  //Store indices

        for (int i = 0; i < n; i++) {
            //Step 1 : remove out -of - window indices
            if (!dp.isEmpty() && dp.peekFirst() <= i - k) dp.pollFirst();

            //Step 2 : Maintain decreasing order
            while (!dp.isEmpty() && nums[dp.peekLast()] < nums[i]) dp.pollLast();

            //Step 3 : add current index
            dp.offerLast(i);

            //Step 4 : Record result
            if (i >= k - 1){
                result[i - k + 1] = nums[dp.peekFirst()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MaxSlidingWindow sol = new MaxSlidingWindow();
        int[] nums1 = {1,3,-1,-3,5,3,6,7};
        int k1 = 3;
        System.out.println(Arrays.toString(sol.maxSlidingWindow(nums1, k1)));
        // Expected: [3,3,5,5,6,7]

        int[] nums2 = {1};
        int k2 = 1;
        System.out.println(Arrays.toString(sol.maxSlidingWindow(nums2, k2)));
        // Expected: [1]
    }
}
