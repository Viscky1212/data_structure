package sorting.may20;

import java.util.Arrays;

public class DeleteGreatestValue {

    public int deleteGreatestValue(int[][] grid){
        int m = grid.length;
        int n  = grid[0].length;

        for (int i = 0; i < m; i++) {
            Arrays.sort(grid[i]);
        }

        int answer = 0;

        for (int col = n - 1; col >= 0; col--) {
            int maxDeleted = 0;
            for (int row = 0; row < m; row++) {
                maxDeleted = Math.max(maxDeleted,grid[row][col]);
            }
            answer += maxDeleted;
        }
        return answer;
    }

    public static void main(String[] args) {
        DeleteGreatestValue sol = new DeleteGreatestValue();

        int[][] grid1 = {
                {1, 2, 4},
                {3, 3, 1}
        };

        System.out.println(sol.deleteGreatestValue(grid1));
        // Output: 8

        int[][] grid2 = {
                {10}
        };

        System.out.println(sol.deleteGreatestValue(grid2));
        // Output: 10
    }
}
