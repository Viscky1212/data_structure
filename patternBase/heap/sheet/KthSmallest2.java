package patternBase.heap.sheet;

import java.util.PriorityQueue;

public class KthSmallest2 {

    static class Node{
        int value;
        int row;
        int col;

        Node(int value, int row, int col){
            this.value = value;
            this.row = row;
            this.col = col;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {

        int n = matrix.length;

        //Min heap based value
        PriorityQueue<Node> minHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(a.value, b.value)
        );


        // Add first element of every row
        for (int row = 0; row < n; row++) {
            minHeap.offer(new Node(matrix[row][0], row, 0));
        }

        //Add first element of every row
        for(int i = 1; i < k; i++){

            Node current =minHeap.poll();

            int nextCol = current.col + 1;

            //remove smallest k-1 element
            if(nextCol < n){
                minHeap.offer(
                        new Node(
                                matrix[current.row][nextCol],
                                current.row,nextCol
                        )
                );
            }
        }

        //kth smallest
        return minHeap.peek().value;



    }

    public static void main(String[] args) {
        KthSmallest2 kthSmallest2 = new KthSmallest2();
        int[][] matrix = {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };
        int k = 8;
        int result = kthSmallest2.kthSmallest(matrix, k);
        System.out.println("The " + k + "th smallest element is: " + result);
    }
}
