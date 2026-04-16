package graph;

import java.util.LinkedList;
import java.util.Queue;

public class WaterFlow {
    int[] dirX = {0, 0, 1, -1};
    int[] dirY = {1, -1, 0, 0};

    public int solve(int[][] A){

        int n = A.length;
        int m = A[0].length;

        boolean[][] blue = new boolean[n][m];
        boolean[][] red = new boolean[n][m];

        //bfs for blue (top + left)
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
        queue.offer(new int[]{i,0});
        blue[i][0] = true;
        }

        for (int j = 0; j < m; j++) {
            queue.offer(new int[]{0,j});
            blue[0][j] = true;
        }

        bfs(A, queue,blue);

        //BFS for red (bottom + right
        queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            queue.offer(new int[]{i , m - 1});
            red[i][m - 1] = true;
        }

        for (int j = 0; j < m; j++) {
            queue.offer(new int[]{n - 1, j});
            red[n - 1][j] = true;
        }

        bfs(A,queue,red);

        //Count insertion
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (blue[i][j] && red[i][j]){
                 count++;
                }
            }
        }
        return count;

    }

    public void bfs(int[][] A, Queue<int[]> queue, boolean[][] visited){
        int n = A.length;
        int m = A[0].length;

        while (!queue.isEmpty()){
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dirX[d];
                int ny = y + dirY[d];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m){
                    // Reverse flow condition
                    if (!visited[nx][ny] && A[nx][ny] >= A[x][y]) {
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        WaterFlow sol = new WaterFlow();
        int[][] grid = {
                {1,2,2,3,5},
                {3,2,3,4,4},
                {2,4,5,3,1},
                {6,7,1,4,5},
                {5,1,1,2,4}
        };

        System.out.println("Output: " + sol.solve(grid)); // 7


    }

}
