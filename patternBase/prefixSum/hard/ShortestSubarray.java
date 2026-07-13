package patternBase.prefixSum.hard;

import java.util.ArrayDeque;
import java.util.Deque;

public class ShortestSubarray {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int answer = Integer.MAX_VALUE;
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i <= n; i++) {
            while (!deque.isEmpty() && prefix[i] - prefix[deque.peekFirst()] >= k) {
                answer = Math.min(answer, i - deque.pollFirst());
            }

            while (!deque.isEmpty() && prefix[i] <= prefix[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.offerLast(i);
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
    public static void main(String[] args) {
        ShortestSubarray shortestSubarray = new ShortestSubarray();
        int[] nums = {1, 2, 3, 4, 5};
        int k = 11;
        int result = shortestSubarray.shortestSubarray(nums, k);
        System.out.println("Length of the shortest subarray: " + result);
    }
}
