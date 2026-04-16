package priorityQueue;

import java.util.*;

public class FindClosestElements {
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        // Max Heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
                (a, b) -> {

                    int diff = Math.abs(b - x) - Math.abs(a - x);

                    if (diff == 0)
                        return b - a;

                    return diff;
                }
        );

        for (int num : arr){
            maxHeap.add(num);
            if (maxHeap.size() > k){
                maxHeap.poll();
            }
        }
        List<Integer> result = new ArrayList<>(maxHeap);
        Collections.sort(result);
        return  result;
    }

    public static void main(String[] args) {
        int[] arr = {5,4,1,2,3};
        int k = 4;
        int x = 3;

        System.out.println(findClosestElements(arr, k, x));

    }
}
