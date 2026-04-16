package priorityQueue;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class MincostToHireWorkers {
    static class Worker{
        int quality;
        int wage;
        double ratio;

        public Worker(int quality, int wage) {
            this.quality = quality;
            this.wage = wage;
            this.ratio = (double) wage / quality;
        }
    }

    public static double mincostToHireWorkers(int[] quality, int[] wage, int k){
        int n = quality.length;
        Worker[] workers = new Worker[n];

        //create worker with ratio
        for (int i = 0; i < n; i++) {
            workers[i] = new Worker(quality[i], wage[i]);
        }

        //sort by ratio
        Arrays.sort(workers,(a,b) -> Double.compare(a.ratio,b.ratio));
        //max heap to store qualities
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());

        int qualitySum = 0;
        double result = Double.MAX_VALUE;

        for (Worker w : workers){
            maxHeap.add(w.quality);
            qualitySum += w.quality;

            //Maintain only k worker
            if (maxHeap.size() > k){
                qualitySum -= maxHeap.poll();
            }

            //if we have k worker calculate cost
            if(maxHeap.size() == k){
                result = Math.min(result,qualitySum * w.ratio);
            }
        }
        return Math.round(result * 100.0) / 100.0;
    }

    public static void main(String[] args) {

        int[] quality = {10,20,5};
        int[] wage = {70,50,30};
        int k = 2;

        System.out.println(mincostToHireWorkers(quality, wage, k));
    }
}
