package binarySearch.april28;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

public class MinimumEffortPath {

    public int minimumEffortPath(int[][] heights){
        int rows = heights.length;
        int cols = heights[0].length;

        //effort matrix
        int[][] effort = new int[rows][cols];
        for (int[] row : effort){
            Arrays.fill(row,Integer.MAX_VALUE);
        }

        //minHeap :{effort , row , col}
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0,0,0});
        effort[0][0] = 0;
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};

        while (!pq.isEmpty()){
            int[] curr = pq.poll();
            int currEffort = curr[0];
            int r = curr[1];
            int c = curr[2];

            //reached destination
            if (r == rows - 1 && c == cols - 1){
                return currEffort;
            }

            for (int[] d : dirs){
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols) {
                    int diff = Math.abs(heights[r][c] - heights[nr][nc]);
                    int newEffort = Math.max(currEffort,diff);

                    if (newEffort < effort[nr][nc]){
                        effort[nr][nc] = newEffort;
                        pq.offer(new int[]{newEffort,nr,nc});
                    }
                }
                }
        }
        return 0;
    }

    public static void main(String[] args) {

        MinimumEffortPath sol = new MinimumEffortPath();

        int[][] grid1 = {
                {1,2,2},
                {3,8,2},
                {5,3,5}
        };
        System.out.println(sol.minimumEffortPath(grid1)); // 2

        int[][] grid2 = {
                {1,2,3},
                {3,8,4},
                {5,3,5}
        };
        System.out.println(sol.minimumEffortPath(grid2)); // 1
    }
}
