package graph;

import java.util.ArrayList;
import java.util.List;

public class CountConnectedComponents {

    public int countConnectedComponents(int n, int[][] edges){
        //Step 1 : Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        int components = 0;

        //Traverse all node
        for (int i = 0; i < n; i++) {
            if (!visited[i]){
                dfs(i, adj, visited);
                components++;
            }
        }
        return components;
    }

    public void dfs(int node, List<List<Integer>> adj, boolean[] visited){
        visited[node] = true;

        for (int neighbor : adj.get(node)){
            if (!visited[neighbor]){
                dfs(neighbor,adj,visited);
            }
        }
    }

    public static void main(String[] args) {
        CountConnectedComponents sol = new CountConnectedComponents();
        int n1 = 6;
        int[][] edges1 = {{0,1},{0,2},{1,2},{3,4}};

        int n2 = 6;
        int[][] edges2 = {{0,1},{0,2},{1,2},{3,4},{3,5}};

        System.out.println("Output 1: " + sol.countConnectedComponents(n1, edges1)); // 3
        System.out.println("Output 2: " + sol.countConnectedComponents(n2, edges2)); // 2
    }
}
