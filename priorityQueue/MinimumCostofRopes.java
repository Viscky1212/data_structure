package priorityQueue;

import java.util.PriorityQueue;

public class MinimumCostofRopes {
    long minCost(long arr[], int n){
        //min Heap to store rope length
        PriorityQueue<Long> minHeap = new PriorityQueue<>();

        //Install all ropes into heap
        for (long rope : arr){
            minHeap.add(rope);
        }

        long totalCost = 0;

        //continew until only one rope remains
        while ((minHeap.size() > 1)){
           long first =  minHeap.poll();
           long second = minHeap.poll();
           long cost = first + second;

           totalCost += cost;

           //add combined rope back
            minHeap.add(cost);
        }
        return  totalCost;
    }

    public static void main(String[] args) {
        MinimumCostofRopes obj = new MinimumCostofRopes();
        long arr[] = {3,2,2,6};
        int n = arr.length;
        System.out.println(obj.minCost(arr,n));
    }
}
