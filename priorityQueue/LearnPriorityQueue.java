package priorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class LearnPriorityQueue {
    public static void main(String[] args) {
       PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
 //       PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(10);
        pq.add(40);
        pq.add(20);
        pq.add(60);
        pq.add(30);
        pq.add(5);

        System.out.println(pq.poll());

        System.out.println(pq);
    }
}