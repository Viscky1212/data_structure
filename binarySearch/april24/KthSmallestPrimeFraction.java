package binarySearch.april24;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthSmallestPrimeFraction {

    public int[] kthSmallestPrimeFraction(int[] arr, int k){
        int n = arr.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> arr[a[0]] * arr[b[1]] - arr[a[1]] * arr[b[0]]
        );

        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{0,i});
        }

        for (int count = 1; count < k; count++) {
            int[] current = pq.poll();
            int i = current[0];
            int j = current[1];


            if (i + 1 < j) pq.offer(new int[]{i + 1, j});
        }
        int[] result = pq.poll();
        return new int[]{arr[result[0]],arr[result[1]]};
    }

    public static void main(String[] args) {
        KthSmallestPrimeFraction solution = new KthSmallestPrimeFraction();
        int[] arr1 = {1, 2, 3, 5};
        int k1 = 3;
        System.out.println(Arrays.toString(solution.kthSmallestPrimeFraction(arr1, k1))); // [2, 5]

        int[] arr2 = {1, 7};
        int k2 = 1;
        System.out.println(Arrays.toString(solution.kthSmallestPrimeFraction(arr2, k2))); // [1, 7]
    }
}
