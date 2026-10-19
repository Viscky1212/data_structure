package patternBase.heap.sheet;

import patternBase.heap.PriorityQ;

import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequentElement {

    public int[] topKFrequent(int[] nums, int k) {
        // Implementation for finding the top K frequent elements
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> frequencyMap.get(a) - frequencyMap.get(b));

        for (int num : frequencyMap.keySet()) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        //Build result
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll();
        }
        return result;

    }

    public static void main(String[] args) {
        TopKFrequentElement topKFrequentElement = new TopKFrequentElement();
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] result = topKFrequentElement.topKFrequent(nums, k);
        System.out.print("Top " + k + " frequent elements are: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
