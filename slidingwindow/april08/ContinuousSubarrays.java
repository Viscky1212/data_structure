package slidingwindow.april08;

import java.util.ArrayDeque;
import java.util.Deque;

public class ContinuousSubarrays {

    public static long continuousSubarrays(int[] nums) {

        Deque<Integer> minDeque = new ArrayDeque<>();
        Deque<Integer> maxDeque = new ArrayDeque<>();

        int left = 0;
        long result = 0;

        for (int right = 0; right < nums.length; right++) {

            // Maintain minDeque (increasing)
            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] > nums[right]) {
                minDeque.pollLast();
            }
            minDeque.offerLast(right);

            // Maintain maxDeque (decreasing)
            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] < nums[right]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(right);

            // Shrink window if invalid
            while (nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > 2) {

                if (minDeque.peekFirst() == left) {
                    minDeque.pollFirst();
                }
                if (maxDeque.peekFirst() == left) {
                    maxDeque.pollFirst();
                }

                left++;
            }

            // Count subarrays
            result += (right - left + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1000000000, 1000000000, 1000000000};
        System.out.println(continuousSubarrays(nums)); // Works correctly
    }
}
