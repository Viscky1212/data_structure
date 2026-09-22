package patternBase.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class PickGifts {

    public static long pickGifts(int[] gifts, int k) {
//java.util.PriorityQueue<Integer> maxHeap = new java.util.PriorityQueue<>((a, b) -> b - a);

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int gift : gifts) {
            maxHeap.offer(gift);
        }
        System.out.println("Initial maxHeap: " + maxHeap);

        for (int i = 0; i < k; i++) {
            int maxGift = maxHeap.poll();
            System.out.println("Round " + (i + 1) + ": Picked gift with value " + maxGift);
            int newGift = (int) Math.floor(Math.sqrt(maxGift));
            System.out.println("Round " + (i + 1) + ": New gift value after sqrt: " + newGift);
            maxHeap.offer(newGift);
            System.out.println("Round " + (i + 1) + ": Updated maxHeap: " + maxHeap);
        }

//        for (int i = 0; i < k; i++) {
//            int maxGift = maxHeap.poll();
//            int newGift = (int) Math.floor(Math.sqrt(maxGift));
//            maxHeap.offer(newGift);
//        }
//
        long totalValue = 0;
        while (!maxHeap.isEmpty()) {
            totalValue += maxHeap.poll();
        }
//
      return totalValue;
    }

    public static void main(String[] args) {
        int[] gifts = {9, 7, 3, 1};
        int k = 4;
        long totalValue = pickGifts(gifts, k);
        System.out.println("Total value of gifts after " + k + " rounds: " + totalValue);
    }
}
