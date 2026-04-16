package two_pointer_problem;

public class ReverseSubmatrix {

    public static int[][] reverseSubmatrix(int[][] grid, int x, int y, int k){
        int top = x;
        int bottom = x + k - 1;

        //Swap rows inside the submatrix
        while (top < bottom){
            for (int col = y; col < y + k; col++) {
                //swap element
                int temp = grid[top][col];
                grid[top][col] = grid[bottom][col];
                grid[bottom][col] = temp;
            }

            top++;
            bottom--;
        }
        return grid;
    }

    public static void printMatrix (int[][]  grid){
        for (int[] row : grid){
            for (int val : row){
                System.out.print(val + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Example 1
        int[][] grid1 = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };

        int x1 = 1, y1 = 0, k1 = 3;

        System.out.println("Before Flip:");
        printMatrix(grid1);

        reverseSubmatrix(grid1, x1, y1, k1);

        System.out.println("\nAfter Flip:");
        printMatrix(grid1);


        // Example 2
        int[][] grid2 = {
                {3,4,2,3},
                {2,3,4,2}
        };

        int x2 = 0, y2 = 2, k2 = 2;

        System.out.println("\nBefore Flip:");
        printMatrix(grid2);

        reverseSubmatrix(grid2, x2, y2, k2);

        System.out.println("\nAfter Flip:");
        printMatrix(grid2);
    }
}
