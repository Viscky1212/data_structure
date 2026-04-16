package slidingwindow.april09;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class MinArrivalsToDiscard {

    public int minArrivalsToDiscard(int[] arrivals, int w, int m) {

        Map<Integer, Deque<Integer>> map = new HashMap<>();
        int discard = 0;

        for (int i = 0; i < arrivals.length; i++) {

            int val = arrivals[i];

            map.putIfAbsent(val, new ArrayDeque<>());
            Deque<Integer> dq = map.get(val);

            // Step 1: Remove indices out of window
            while (!dq.isEmpty() && dq.peekFirst() < i - w + 1) {
                dq.pollFirst();
            }

            // Step 2: Check constraint
            if (dq.size() == m) {
                // must discard
                discard++;
            } else {
                // keep it
                dq.addLast(i);
            }
        }

        return discard;
    }
    public static void main(String[] args) {
       MinArrivalsToDiscard sol = new MinArrivalsToDiscard();

        // Test Case 1
        int[] arr1 = {1,2,1,3,1};
        System.out.println(sol.minArrivalsToDiscard(arr1, 4, 2)); // 0

        // Test Case 2
        int[] arr2 = {1,2,3,3,3,4};
        System.out.println(sol.minArrivalsToDiscard(arr2, 3, 2)); // 1
    }
}
