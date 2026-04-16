package slidingwindow.april06;

import org.ietf.jgss.GSSManager;

import java.util.*;

public class MedianSlidingWindow {

    class DualHeap{
        PriorityQueue<Integer> small;  //max heap
        PriorityQueue<Integer> large;  //Min heap
        Map<Integer, Integer> delayed;
        int k;
        int smallSize, largeSize;

        public DualHeap(int k){
            this.k = k;
            small = new PriorityQueue<>(Collections.reverseOrder());
            large = new PriorityQueue<>();
            delayed = new HashMap<>();
            smallSize = 0;
            largeSize = 0;
        }

        public double getMedian(){
            if (k % 2 == 1)return small.peek();
            else return ((long) small.peek() + large.peek()) / 2.0;
        }

        public void insert(int num){
            if (small.isEmpty() || num <= small.peek()){
                small.offer(num);
                smallSize++;
            } else {
                large.offer(num);
                largeSize++;
            }
            balance();
        }

        public void erase(int num){
            delayed.put(num, delayed.getOrDefault(num,0) + 1);

            if (num <= small.peek()){
                smallSize--;
                if (num == small.peek()) prune(small);
            } else {
                largeSize--;
                if (num == large.peek()) prune(large);
            }
            balance();
        }

        private void prune(PriorityQueue<Integer> heap){
            while (!heap.isEmpty()){
                int num = heap.peek();
                if (delayed.containsKey(num)){
                    delayed.put(num, delayed.get(num) - 1);
                    if (delayed.get(num) == 0) delayed.remove(num);
                    heap.poll();
                } else  break;
            }
        }

        private  void balance(){
            if (smallSize > largeSize + 1){
                large.offer(small.poll());
                smallSize--;
                largeSize++;
                prune(small);
            } else if (smallSize < largeSize) {
                small.offer(large.poll());
                smallSize++;
                largeSize--;
                prune(large);
            }
        }
    }




    public double[] medianSlidingWindow(int[] nums, int k){
        DualHeap dh= new DualHeap(k);
        int n = nums.length;
        double[] result = new double[n - k + 1];

        for (int i = 0; i < k; i++) {
            dh.insert(nums[i]);
        }

        result[0] = dh.getMedian();

        for (int i = k; i < n; i++) {
            dh.insert(nums[i]);
            dh.erase(nums[i - k]);
            result[i - k + 1] = dh.getMedian();
        }
        return result;
    }

    public static void main(String[] args) {
        MedianSlidingWindow sol = new MedianSlidingWindow();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;

        double[] res = sol.medianSlidingWindow(nums, k);

        System.out.println(Arrays.toString(res));
        // Expected: [1.0, -1.0, -1.0, 3.0, 5.0, 6.0]
    }
}
