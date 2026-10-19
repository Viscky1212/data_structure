package patternBase.heap.sheet;

import java.util.*;

public class MergeArrays {
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
    public ArrayList<Integer> mergeArrays(int[][] mat) {
        // Code here
        int n = mat.length;
        ArrayList<Integer> result = new ArrayList<>();

        ///MinHeap based value
        PriorityQueue<Node> minHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(a.value, b.value)
        );


        //Put first element of every row into heap
        for(int i = 0; i < n; i++){
            if(mat[i].length > 0){
                minHeap.offer(new Node(mat[i][0], i, 0));
            }
        }

        //K- Way merge
        while(!minHeap.isEmpty()){

            Node current = minHeap.poll();

            //add smallest element
            result.add(current.value);

            //Move to next element
            int nextCol = current.col + 1;

            if(nextCol < mat[current.row].length){
                minHeap.offer(
                        new Node(
                                mat[current.row][nextCol],
                                current.row, nextCol));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MergeArrays mergeArrays = new MergeArrays();
        int[][] mat = {
                {1, 4, 7},
                {2, 5, 8},
                {3, 6, 9}
        };
        ArrayList<Integer> result = mergeArrays.mergeArrays(mat);
        System.out.println("Merged array: " + result);
    }
}
