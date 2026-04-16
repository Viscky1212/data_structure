package graph;

import java.util.ArrayList;

public class DfsOfGraph {


    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {

        boolean[] visited = new boolean[V];

        ArrayList<Integer> result = new ArrayList<>();

        //Start DFS from node 0
        dfs(0, adj, visited, result);
        return result;

    }

        private void dfs(int node, ArrayList<ArrayList<Integer>> adj,
                     boolean[] visited, ArrayList<Integer> result) {
        visited[node] = true;
        result.add(node);

        for (int neighbor : adj.get(node)){
            if (!visited[neighbor]){
                dfs(neighbor,adj,visited,result);
            }
        }

    }

        public static void main(String[] args) {
        DfsOfGraph sol = new DfsOfGraph();
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(2);
        adj.get(0).add(3);
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(2).add(0);
        adj.get(2).add(4);
        adj.get(3).add(0);
        adj.get(4).add(2);

        System.out.println("DFS Traversal: " + sol.dfsOfGraph(V, adj));
        // Output: [0, 2, 4, 3, 1]

    }
}
