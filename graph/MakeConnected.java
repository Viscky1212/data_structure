package graph;

import java.util.ArrayList;
import java.util.List;

public class MakeConnected {

    public int makeConnected(int[][] connections, int n){
        //Step 1 : Check if enough cable exits
        if (connections.length < n - 1){
            return -1;
        }

        // Step 2 : Build graph
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : connections){
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        int components = 0;

        //step 3 : Count component

        for (int i = 0; i < n; i++) {
            if (!visited[i]){
                dfs(i, adj, visited);
                components++;
            }
        }

        //Step 4 : Operations needed
        return components - 1;

    }

    public void dfs(int node , List<List<Integer>> adj, boolean[] visited ){
        visited[node] = true;
        for (int neighbor : adj.get(node)){
            if (!visited[neighbor]){
                dfs(neighbor,adj,visited);
            }
        }
    }

    public static void main(String[] args) {
    MakeConnected sol = new MakeConnected();

        int[][] conn1 = {{0,1},{0,2},{1,2}};
        int n1 = 4;

        int[][] conn2 = {{0,1},{0,2},{0,3},{1,2},{1,3}};
        int n2 = 6;

        System.out.println("Output 1: " + sol.makeConnected(conn1, n1)); // 1
        System.out.println("Output 2: " + sol.makeConnected(conn2, n2)); // 2


    }
}
