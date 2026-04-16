package priorityQueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class FindKLargestElement {
    public static ArrayList<Integer> kLargest(int arr[], int n, int k) {

        // Min Heap (smallest element at top)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Step 1: Traverse the array
        for(int num : arr) {

            // Add element to heap
            minHeap.offer(num);

            // If heap size exceeds k remove smallest element
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // Step 2: Store heap elements into result list
        ArrayList<Integer> result = new ArrayList<>(minHeap);

        // Step 3: Sort in descending order
        Collections.sort(result, Collections.reverseOrder());

        return result;
    }

    // Main method for testing
    public static void main(String[] args) {

        int arr[] = {12,5,787,1,23};
        int n = arr.length;
        int k = 2;

        ArrayList<Integer> result = kLargest(arr, n, k);

        for(int num : result) {
            System.out.print(num + " ");
        }
    }
}
