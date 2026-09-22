package patternBase.heap;

import java.util.PriorityQueue;

public class GetFinalState {

    static class Pair{
        int value;
        int index;

        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public static int[] getFinalState(int[] nums, int k, int multiply) {


        //min heap
        //first compare value
        //if value is same then compare index
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> {
            if (a.value != b.value) {
                return Integer.compare(a.value, b.value);
            }
            return Integer.compare(a.index, b.index);
        });

        //put all elements in the min heap
        for (int i = 0; i < nums.length; i++) {
            minHeap.offer(new Pair(nums[i], i));
        }

        //perform k operations
        for (int operations = 0; operations < k; operations++) {

            //Get minimum value from the heap
            Pair current = minHeap.poll();

            //multiply it with the given multiply value
            current.value *= multiply;

            //update original array with the new value
            nums[current.index] = current.value;

            //Put the updated value back into the min heap
            minHeap.offer(current);
        }

        return nums;

    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 3, 5, 6};
        int k = 5;
        int multiplier = 2;
        int[] finalState = getFinalState(nums, k, multiplier);

        System.out.print("Final State: ");
        for (int num : finalState) {
            System.out.print(num + " ");
        }
    }
}
