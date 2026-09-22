package patternBase.heap;

import java.util.PriorityQueue;

public class KthLargest {

    private final int k;

    private final PriorityQueue<Integer> minHeap;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();
        System.out.println("Current k: " + k);

        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        minHeap.offer(val);
//        System.out.println("Current minHeap: " + minHeap);
//        System.out.println("Current size of minHeap: " + minHeap.size());
//        System.out.println("Current k: " + k);
        if (minHeap.size() > k) {
            System.out.println("Removing smallest element: " + minHeap.peek());
            System.out.println("Current minHeap before removal: " + minHeap);
            System.out.println("Current k: " + k);
            minHeap.poll();
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        KthLargest kthLargest = new KthLargest(k, nums);
//        System.out.println(k + "th largest element is: " + kthLargest.add(0));
//        System.out.println(k + "th largest element is: " + kthLargest.add(7));
//        System.out.println(k + "th largest element is: " + kthLargest.add(8));
        System.out.println(k + "th largest element is: " + kthLargest.add(5));

    }
}
