package priorityQueue;

import java.util.*;

public class GetSkyline {

    public static List<List<Integer>> getSkyline(int[][] buildings){
        List<int[]> events = new ArrayList<>();

        //step 1 : create start and end events
        for (int[] b : buildings){
            events.add(new int[]{b[0], -b[2]}); // start
            events.add(new int[]{b[1], b[2]});  // end
        }

        // Step 2: sort events
        Collections.sort(events, (a, b) -> {
            if (a[0] != b[0])
                return a[0] - b[0];
            return a[1] - b[1];
        });
        // Step 3: max heap for heights
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());

        maxHeap.add(0);

        int prevHeight = 0;
        List<List<Integer>> result = new ArrayList<>();

        for (int[] event : events){
            int x = event[0];
            int h = event[1];

            if(h < 0){
                //start of building
                maxHeap.add(-h);
            } else {
                //end of building
                maxHeap.remove(h);
            }

            int currHeight = maxHeap.peek();

            if (currHeight != prevHeight){
                result.add(Arrays.asList(x,currHeight));
                prevHeight = currHeight;
            }
        }
        return  result;

    }

    public static void main(String[] args) {
        int[][] buildings = {
                {2,9,10},
                {3,7,15},
                {5,12,12},
                {15,20,10},
                {19,24,8}
        };

        System.out.println(getSkyline(buildings));
    }
}
