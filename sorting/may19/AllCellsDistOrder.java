package sorting.may19;

import java.util.Arrays;

public class AllCellsDistOrder {

    public int[][] allCellsDistOrder(int row, int col, int rCenter, int cCenter){
        int[][] result = new int[row*col][2];

        int index = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result[index][0] = i;
                result[index][1] = j;
                index++;
            }
        }

        Arrays.sort(result,(a,b) ->{
            int distA = Math.abs(a[0] -rCenter) + Math.abs(a[1] -cCenter);
            int distB = Math.abs(b[0] - rCenter) + Math.abs(b[1] - cCenter);
            return distA - distB;
        });

        return result;
    }

    private  static void print(int[][] arr){
        System.out.println(Arrays.deepToString(arr));
    }

    public static void main(String[] args) {
        AllCellsDistOrder sol = new AllCellsDistOrder();

        int[][] ans1 = sol.allCellsDistOrder(1, 2, 0, 0);
        print(ans1);
        // Output: [[0, 0], [0, 1]]

        int[][] ans2 = sol.allCellsDistOrder(2, 2, 0, 1);
        print(ans2);
        // Output: [[0, 1], [0, 0], [1, 1], [1, 0]]

        int[][] ans3 = sol.allCellsDistOrder(2, 3, 1, 2);
        print(ans3);
        // Output: [[1, 2], [0, 2], [1, 1], [0, 1], [1, 0], [0, 0]]
    }
}
