package priorityQueue;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthSmallestPrimeFraction {
    public static int[] kthSmallestPrimeFraction(int[] arr, int k){
        int n = arr.length;

        //min Heap comparing fractions
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                (a, b) -> Double.compare(
                        (double) arr[a[0]] / arr[a[1]],
                        (double) arr[b[0]] / arr[b[1]]
                )
        );
        //step 1 : push fraction with numerator index 0
        for (int j = 1; j < n; j++) {
            minHeap.add(new int[]{0, j});
        }

        for (int count = 1; count < k; count++) {
            int[]  curr = minHeap.poll();
            int i = curr[0];
            int j = curr[1];

            if (i + 1 < j){
                minHeap.add(new int[] { i + 1, j});
            }
        }
        //kth fraction
        int[] result = minHeap.poll();
        return new int[]{arr[result[0]], arr[result[1]]};
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,5};
        int k = 3;

        System.out.println(Arrays.toString(kthSmallestPrimeFraction(arr, k)));

    }
}
