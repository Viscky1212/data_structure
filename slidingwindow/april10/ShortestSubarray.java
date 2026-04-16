package slidingwindow.april10;

import java.util.Deque;
import java.util.LinkedList;

public class ShortestSubarray {

    public int shortestSubarray(int[] nums, int k){
        int n = nums.length;
        long[] prefix = new long[n + 1];

        //Step  1 : Build prefix sum
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        Deque<Integer> dq = new LinkedList<>();
        int minLen = Integer.MAX_VALUE;

        for (int j = 0; j <= n; j++) {
            // Step 2: Check valid subarray
            while (!dq.isEmpty() && prefix[j] - prefix[dq.peekFirst()] >= k) {
                minLen = Math.min(minLen, j - dq.pollFirst());
            }

            //Step 3 : Maintain monotonic increasing deque
            while (!dq.isEmpty() && prefix[j] <= prefix[dq.peekLast()]){
                dq.pollLast();
            }
            dq.offerLast(j);
        }
        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }

    public static void main(String[] args) {
        ShortestSubarray sol = new ShortestSubarray();
        int[] nums1 = {1};
        System.out.println(sol.shortestSubarray(nums1, 1)); // 1

        int[] nums2 = {1, 2};
        System.out.println(sol.shortestSubarray(nums2, 4)); // -1

        int[] nums3 = {2, -1, 2};
        System.out.println(sol.shortestSubarray(nums3, 3)); // 3
    }
}
