package dp.dp2;

public class CherryPick {

    public int cherryPickup(int n, int m, int[][] grid){
        int[][][] dp = new int[n][m][m];

        for (int row = n - 1; row >= 0; row--) {
            for (int col1 = 0; col1 < m; col1++) {
                for (int col2 = 0; col2 < m; col2++) {
                    int cherries = grid[row][col1];
                    if (col1 != col2) cherries += grid[row][col2];

                    if (row != n - 1){
                        int maxNext = 0;

                        for (int d1 = -1; d1 <= 1; d1++) {
                            for (int d2 = -1; d2 <= 1; d2++) {
                                int newCol1 = col1 + d1;
                                int newCol2 = col2 + d2;

                                if (newCol1 >= 0 && newCol1 < m && newCol2 >= 0 && newCol2 < m){
                                    maxNext = Math.max(maxNext,dp[row + 1][newCol1][newCol2]);
                                }
                            }
                        }
                        cherries += maxNext;
                    }
                    dp[row][col1][col2] = cherries;
                }
            }
        }
        return dp[0][0][m - 1];

    }

    public static void main(String[] args) {
        CherryPick sol = new CherryPick();
        int[][] grid = {
                {3, 1, 1},
                {2, 5, 1},
                {1, 5, 5},
                {2, 1, 1}
        };

        int n = grid.length;
        int m = grid[0].length;

        int result = sol.cherryPickup(n, m, grid);

        System.out.println("Maximum cherries collected: " + result);
    }

}
