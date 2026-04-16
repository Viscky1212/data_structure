package graph;

import java.util.*;

public class FindShortestCycle {

    public int findShortestCycle(int n, int[][] edges){
        //Build adjancency list
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int shorttestCycle = Integer.MAX_VALUE;

        //Step 2 : BFS from each node
        for (int start = 0; start < n; start++) {

            int[] dist = new int[n];
            Arrays.fill(dist, - 1);

            int[] parent = new int[n];
            Arrays.fill(parent, - 1);

            Queue<Integer> queue = new LinkedList<>();

            queue.offer(start);
            dist[start] = 0;

            while (!queue.isEmpty()){
                int u = queue.poll();
                for (int v : adj.get(u)){
                    //Not visited
                    if (dist[v] == -1){
                        dist[v] = dist[u] + 1;
                        parent[v] = u;
                        queue.offer(v);
                    }

                    //Visited and not present -> cycle
                    else if (parent[u] != v) {
                        int cycleLen = dist[u] + dist[v] + 1;
                        shorttestCycle = Math.min(shorttestCycle,cycleLen);
                    }
                }
            }

        }
        return shorttestCycle == Integer.MAX_VALUE ? -1 : shorttestCycle;


    }
    public static void main(String[] args) {
        FindShortestCycle sol = new FindShortestCycle();
        int n1 = 7;
        int[][] edges1 = {
                {0,1},{1,2},{2,0},
                {3,4},{4,5},{5,6},{6,3}
        };

        int n2 = 4;
        int[][] edges2 = {
                {0,1},{0,2}
        };

        System.out.println("Output 1: " + sol.findShortestCycle(n1, edges1)); // 3
        System.out.println("Output 2: " + sol.findShortestCycle(n2, edges2)); // -1
    }
}
