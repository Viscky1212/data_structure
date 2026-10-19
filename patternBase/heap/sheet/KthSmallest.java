package patternBase.heap.sheet;

import java.util.PriorityQueue;

public class KthSmallest {
    public int kthSmallest(int[] arr, int k) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int num : arr) {
            maxHeap.offer(num);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        KthSmallest kthSmallest = new KthSmallest();
        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 3;
        int result = kthSmallest.kthSmallest(arr, k);
        System.out.println("The " + k + "rd smallest element is: " + result);
    }
}
