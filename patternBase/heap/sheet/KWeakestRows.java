package patternBase.heap.sheet;

import java.util.PriorityQueue;

public class KWeakestRows {
    public int[] kWeakestRows(int[][] mat, int k) {

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> {

                    //More soldiers = stronger = worse candidat
                    if(a[1] != b[1]){
                        return Integer.compare(b[1], a[1]);
                    }

                    //Same Soldiers
                    //larger index = stonger = worse candidate
                    return Integer.compare(b[0], a[0]);
                }
        );


        for(int i = 0; i < mat.length; i++){
            int soldiers = countSoldiers(mat[i]);

            maxHeap.offer(new int[]{i, soldiers});

            //keep only ke weakest rows
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }

        int[] result = new int[k];

        //Extract from strongest to weakest,
        //So fill from the end
        for(int i = k - 1; i >= 0; i--){
            result[i] = maxHeap.poll()[0];
        }

        return result;

    }

    public int countSoldiers(int[] row){

        int count = 0;

        for(int value : row){
            if(value == 1){
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        KWeakestRows kWeakestRows = new KWeakestRows();
        int[][] mat = {
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1}
        };
        int k = 3;
        int[] result = kWeakestRows.kWeakestRows(mat, k);
        System.out.print("The indices of the " + k + " weakest rows are: ");
        for (int index : result) {
            System.out.print(index + " ");
        }
        System.out.println();
    }
}
