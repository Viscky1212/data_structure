package priorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class PickGifts {

    public  long pickGifts(int[] gifts, int k){
        // Max Heap
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());

        //insert all piles
        for (int g : gifts){
            maxHeap.add(g);
        }

        //perform k operations
        while (k-- > 0){
            int maxPile = maxHeap.poll();
           int remaining = (int) Math.floor(Math.sqrt(maxPile));
        maxHeap.add(remaining);
        }
        //calculates total remaining gifts
        long total = 0;
        for (int val : maxHeap){
            total += val;
        }
        return total;
    }

    public static void main(String[] args) {
        PickGifts obj = new PickGifts();
        int[] gifts = {25, 64, 9, 4, 100};
        int k = 4;

        System.out.println(obj.pickGifts(gifts, k));
    }
}
