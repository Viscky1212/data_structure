package priorityQueue;

import java.util.Arrays;
import java.util.PriorityQueue;

public class CarPooling {

    public static boolean carPooling(int[][] trips, int capacity){
        //sort trips by pickup location
        Arrays.sort(trips,(a,b) -> a[1] - b[1]);

        //Min heap  based on drop location
        PriorityQueue<int[]> minHeap =
                new PriorityQueue<>((a, b) -> a[2] - b[2]);

        int currentPassengers = 0;

        for (int[] trip : trips){
            int passengers = trip[0];
            int from = trip[1];
            int to = trip[2];

            //Remove passenger who already got down
            while (!minHeap.isEmpty() && minHeap.peek()[2] <= from){
                currentPassengers -= minHeap.poll()[0];
            }

            //add new passenger
            currentPassengers += passengers;
            if (currentPassengers > capacity)
                return false;
                minHeap.add(trip);
        }
        return  true;
    }

    public static void main(String[] args) {

        int[][] trips = {
                {2,1,5},
                {3,3,7}
        };

        int capacity = 4;

        System.out.println(carPooling(trips, capacity));
    }
}
