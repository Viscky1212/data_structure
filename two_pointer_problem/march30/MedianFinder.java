package two_pointer_problem.march30;

import java.util.PriorityQueue;

public class MedianFinder {
    private PriorityQueue<Integer> maxHeap; // left side
    private PriorityQueue<Integer> minHeap; // right side

    public MedianFinder(){

        //Max Heap
        maxHeap = new PriorityQueue<>((a,b) ->b - a);
        //Min heap
        minHeap = new PriorityQueue<>();


    }

    public void  addNum(int num){
        //Step 1 : Add to mazHeap
        maxHeap.offer(num);

        //Step 2 : Balance heaps (move largest to left -> right )
        minHeap.offer(maxHeap.poll());

        //Step 3 : Ensure size condition
        if(minHeap.size() > maxHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
    }


    public double findMedian(){
        if (maxHeap.size() == minHeap.size()){
            return  (maxHeap.peek() + minHeap.peek()) /2.0;
        }
        return maxHeap.peek();
    }



    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();

        mf.addNum(1);
        mf.addNum(2);
        System.out.println("Median: " + mf.findMedian()); // 1.5

        mf.addNum(3);
        System.out.println("Median: " + mf.findMedian()); // 2.0
    }
}
