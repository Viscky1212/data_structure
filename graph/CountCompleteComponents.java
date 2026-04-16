package graph;

import java.util.ArrayList;
import java.util.List;

public class CountCompleteComponents {

    public int countCompleteComponents(int n, int[][] edges){
        //Step 1 : Build graph
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int [] edge : edges){
            int u =  edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        int completeCount = 0;

        //Step 2 : Traverse component
        for (int i = 0; i < n; i++) {
            if (!visited[i]){
                List<Integer> component = new ArrayList<>();
                dfs(i, adj, visited, component);

                int nodes = component.size();
                int edgeCount = 0;

                //Count edges
                for (int node : component){
                    edgeCount += adj.get(node).size();
                }

                edgeCount /= 2; //undirected graph

                if (edgeCount == (nodes * (nodes - 1)) / 2){
                    completeCount++;
                }
            }
        }
        return completeCount;

    }

    private void dfs(int node, List<List<Integer>> adj,
                     boolean[] visited, List<Integer> component) {
        visited[node] = true;
        component.add(node);

        for (int neighbor : adj.get(node)){
            if (!visited[neighbor]){
                dfs(neighbor,adj,visited,component);
            }
        }

    }

        public static void main(String[] args) {

        CountCompleteComponents sol = new CountCompleteComponents();
            int n1 = 6;
            int[][] edges1 = {{0,1},{0,2},{1,2},{3,4}};

            int n2 = 6;
            int[][] edges2 = {{0,1},{0,2},{1,2},{3,4},{3,5}};

            System.out.println("Output 1: " + sol.countCompleteComponents(n1, edges1)); // 3
            System.out.println("Output 2: " + sol.countCompleteComponents(n2, edges2)); // 1
        }
}
