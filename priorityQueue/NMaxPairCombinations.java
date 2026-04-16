package priorityQueue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;

public class NMaxPairCombinations {

    static class Node {
        int sum;
        int i;
        int j;

        Node(int sum, int i, int j) {
            this.sum = sum;
            this.i = i;
            this.j = j;
        }
    }

    public int[] solve(int[] A, int[] B) {

        int n = A.length;

        // Sort arrays
        Arrays.sort(A);
        Arrays.sort(B);

        // Max Heap
        PriorityQueue<Node> maxHeap =
                new PriorityQueue<>((a, b) -> b.sum - a.sum);

        // To track visited pairs
        HashSet<String> visited = new HashSet<>();

        int[] result = new int[n];

        // Start with largest pair
        maxHeap.add(new Node(A[n - 1] + B[n - 1], n - 1, n - 1));
        visited.add((n - 1) + "#" + (n - 1));

        for (int k = 0; k < n; k++) {

            Node current = maxHeap.poll();
            result[k] = current.sum;

            int i = current.i;
            int j = current.j;

            // Next pair (i-1, j)
            if (i - 1 >= 0) {
                String key = (i - 1) + "#" + j;

                if (!visited.contains(key)) {
                    maxHeap.add(new Node(A[i - 1] + B[j], i - 1, j));
                    visited.add(key);
                }
            }

            // Next pair (i, j-1)
            if (j - 1 >= 0) {
                String key = i + "#" + (j - 1);

                if (!visited.contains(key)) {
                    maxHeap.add(new Node(A[i] + B[j - 1], i, j - 1));
                    visited.add(key);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        NMaxPairCombinations obj = new NMaxPairCombinations();

        int[] A = {1, 4, 2, 3};
        int[] B = {2, 5, 1, 6};

        int[] result = obj.solve(A, B);

        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}
