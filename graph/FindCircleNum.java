package graph;

public class FindCircleNum {

    public int findCircleNum(int[][] isConnected){
        int n = isConnected.length;

        boolean[] visited = new boolean[n];
        int provinces = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]){
               dfs(i, isConnected,visited);
               provinces++;
            }
        }
        return provinces;
    }

    public void dfs(int city, int[][] isConnected, boolean[] visited ){
        visited[city] = true;

        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[city][i] == 1 && !visited[i]){
                dfs(i, isConnected,visited);
            }
        }
    }



    public static void main(String[] args) {
        FindCircleNum sol = new FindCircleNum();
        int[][] graph1 = {
                {1,1,0},
                {1,1,0},
                {0,0,1}
        };

        int[][] graph2 = {
                {1,0,0},
                {0,1,0},
                {0,0,1}
        };

        System.out.println("Output 1: " + sol.findCircleNum(graph1)); // 2
        System.out.println("Output 2: " + sol.findCircleNum(graph2)); // 3
    }
}
