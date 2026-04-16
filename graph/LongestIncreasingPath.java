package graph;

public class LongestIncreasingPath {

    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    public int longestIncreasingPath(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];

        int max = 0;

        //try starting from every cell
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max,dfs(matrix,i, j, dp));
            }
        }
        return max;
    }

    public int dfs(int[][] matrix, int i , int j, int[][] dp){
        if (dp[i][j] != 0){
            return dp[i][j];
        }

        int max = 1; //minimum path = itself

        for (int[] d : dirs){
            int ni = i + d[0];
            int nj = j + d[1];

            if (ni >= 0 && nj >= 0 && ni < matrix.length && nj < matrix[0].length) {

                if (matrix[ni][nj] > matrix[i][j]) {
                    max = Math.max(max, 1 + dfs(matrix, ni, nj, dp));
                }
            }
        }
        dp[i][j] = max;
        return max;
    }


    public static void main(String[] args) {
        LongestIncreasingPath sol = new LongestIncreasingPath();
        int[][] matrix1 = {
                {9,9,4},
                {6,6,8},
                {2,1,1}
        };

        int[][] matrix2 = {
                {3,4,5},
                {3,2,6},
                {2,2,1}
        };

        System.out.println("Output 1: " + sol.longestIncreasingPath(matrix1)); // 4
        System.out.println("Output 2: " + sol.longestIncreasingPath(matrix2)); // 4
    }
}
