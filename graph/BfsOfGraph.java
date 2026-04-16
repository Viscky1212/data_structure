package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BfsOfGraph {

    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj){
        boolean[] visited = new boolean[V];
        ArrayList<Integer> result = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();

        //Start BFS from node 0
        queue.offer(0);
        visited[0] = true;

        while (!queue.isEmpty()){
            int node = queue.poll();
            result.add(node);

            for (int neighnbor : adj.get(node)){
                if (!visited[neighnbor]){
                    visited[neighnbor]  = true;
                    queue.offer(neighnbor);
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        BfsOfGraph sol = new BfsOfGraph();
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(0).add(3);
        adj.get(2).add(4);

        System.out.println("BFS Traversal: " + sol.bfsOfGraph(V, adj));
        // Output: [0, 1, 2, 3, 4]

    }
}
