package priorityQueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class LeastInterval {
    public static int leastInterval(char [] tasks, int n){
        int[] freq = new int[26];

        //count frequncy
        for (char c : tasks){
            freq[c - 'A']++;
        }

        //Max heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int f : freq){
            if ( f > 0){
                maxHeap.add(f);
            }
        }

        int time = 0;
        while (!maxHeap.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int cycle = n + 1;
            while (cycle > 0 && !maxHeap.isEmpty()){
                int current = maxHeap.poll();
                current--;
                if (current > 0){
                    temp.add(current);
                }
                time++;
                cycle--;
            }
            //push remaining tasks back
            for (int t : temp){
                maxHeap.add(t);
            }
            if (maxHeap.isEmpty()) break;
            time += cycle;
        }
        return time;
    }

    public static void main(String[] args) {
        char[] tasks = {'A','A','A','B','B','B'};
        int n = 2;

        System.out.println(leastInterval(tasks, n));

    }
}
