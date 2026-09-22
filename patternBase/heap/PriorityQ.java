package patternBase.heap;

public class PriorityQ {

    public static void main(String[] args) {
        java.util.PriorityQueue<Integer> pq = new java.util.PriorityQueue<>();

        // Adding elements to the priority queue
        pq.offer(5);
        pq.offer(1);
        pq.offer(3);
        pq.offer(4);
        pq.offer(2);

        pq.poll();
       pq.poll();


        Integer peek = pq.peek();

        System.out.println("Peek element (highest priority): " + peek);

        System.out.println("Elements in the priority queue (in order of priority):");
        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " ");
        }
    }
}
