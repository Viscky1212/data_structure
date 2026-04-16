package slidingwindow.april08;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class LongestSubarray {

    public int longestSubarray(int[] nums, int limit){
        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < nums.length; right++) {

            //maintain decreasing deque(max)
            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] < nums[right]){
                maxDeque.pollLast();
            }
            maxDeque.addLast(right);

            //maintain increasing deque(min)
            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] > nums[right]){
                minDeque.pollLast();
            }
            minDeque.addLast(right);

            //shrink window if condition is fail
            while (nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > limit){
                if (maxDeque.peekFirst() == left){
                    maxDeque.pollFirst();
                }
                if (minDeque.peekFirst() == left){
                    minDeque.pollFirst();
                }
                left++;
            }

            //update max length
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //input size
        System.out.println("Insert you number : ");
        int n = sc.nextInt();

        //input array
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        //input limit
        int limit = sc.nextInt();

        LongestSubarray sol = new LongestSubarray();
        int result = sol.longestSubarray(nums, limit);

        //output
        System.out.println("Longest value subarray : "+result);
        sc.close();

    }
}
