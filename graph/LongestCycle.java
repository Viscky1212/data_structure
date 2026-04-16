package graph;

import java.util.HashMap;
import java.util.Map;

public class LongestCycle {

    public int longestCycle(int[] edges ){

        int n = edges.length;
        boolean[] visited = new boolean[n];
        int[] time = new int[n];

        int maxCycle = -1;
        int currentTime = 1;

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;;

            int node = i;
            Map<Integer,Integer> localTime = new HashMap<>();

            //Traverse current path
            while (node != -1 && !visited[node]){
                visited[node] = true;
                localTime.put(node, currentTime);
                time[node] = currentTime;
                currentTime++;

                node = edges[node];
            }

            //Cycle detection
            if (node != -1 && localTime.containsKey(node)){
                int cycleLength = currentTime - localTime.get(node);
                maxCycle = Math.max(maxCycle,cycleLength);
            }
        }
        return maxCycle;
    }

    public static void main(String[] args) {
        LongestCycle sol = new LongestCycle();
        int[] edges1 = {3,3,4,2,3};
        int[] edges2 = {2,-1,3,1};

        System.out.println("Output 1: " + sol.longestCycle(edges1)); // 3
        System.out.println("Output 2: " + sol.longestCycle(edges2)); // -1


    }
}
