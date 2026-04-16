package priorityQueue;

import java.util.*;

public class RearrangeBarcodes {
    public static int[] rearrangeBarcodes(int[] barcodes){
        HashMap<Integer, Integer> freq = new HashMap<>();
        for ( int b : barcodes){
            freq.put(b, freq.getOrDefault(b, 0) + 1);
        }
        //step 2 : max Heap based on frequency
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (Map.Entry<Integer,Integer> entry : freq.entrySet()){
            maxHeap.add(new int[]{entry.getKey(),entry.getValue()});
        }
        int n = barcodes.length;
        int[] result = new int[n];
        int index = 0;

        //step 3 : Build result
        while (maxHeap.size() >= 2){
            int[] first = maxHeap.poll();
            int[] second = maxHeap.poll();

            result[index++] = first[0];
            result[index++] = second[0];

            if(--first[1] > 0) maxHeap.add(first);
            if (--second[1] > 0) maxHeap.add(second);
        }
        //step 4 : If one element left
        if(!maxHeap.isEmpty()){
            result[index] = maxHeap.poll()[0];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] barcodes = {1,1,1,2,2,2};

        System.out.println(Arrays.toString(rearrangeBarcodes(barcodes)));

    }
}
