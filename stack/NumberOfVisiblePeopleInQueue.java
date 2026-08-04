package stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * LeetCode 1944. Number of Visible People in a Queue
 *
 * There are n people in a queue, with heights given in the array heights,
 * ordered from front to back. Person i can see person j (i < j) if
 * heights[i] > heights[j] and everyone between them is shorter than
 * heights[i] (i.e., person j is the first person taller than or equal to
 * person i, or the last person in the line).
 *
 * Return an array answer where answer[i] is the number of people person i
 * can see to their right.
 */
public class NumberOfVisiblePeopleInQueue {

    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] answer = new int[n];
        // Monotonic decreasing stack storing indices of heights.
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; i--) {
            // Pop everyone shorter than the current person; each pop is
            // one person the current person can see.
            while (!stack.isEmpty() && heights[stack.peek()] < heights[i]) {
                stack.pop();
                answer[i]++;
            }
            // If someone taller or equal remains, the current person can
            // see them too (but not beyond them).
            if (!stack.isEmpty()) {
                answer[i]++;
            }
            stack.push(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        NumberOfVisiblePeopleInQueue solution = new NumberOfVisiblePeopleInQueue();

        int[] heights1 = {10, 6, 8, 5, 11, 9};
        System.out.println(Arrays.toString(solution.canSeePersonsCount(heights1)));
        // Expected: [3, 1, 2, 1, 1, 0]

        int[] heights2 = {5, 1, 2, 3, 10};
        System.out.println(Arrays.toString(solution.canSeePersonsCount(heights2)));
        // Expected: [4, 1, 1, 1, 0]
    }
}
