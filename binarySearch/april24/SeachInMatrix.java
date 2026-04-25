package binarySearch.april24;

public class SeachInMatrix {

    public boolean searchMatrix(int[][] matrix, int target){
        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = m * n - 1;

        while (left <= right){
            int mid = left + (right - left) / 2;
            int value = matrix[mid / n][mid % n];

            if (value == target)return true;
            else if (value < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }

    public static void main(String[] args) {
        SeachInMatrix solution = new SeachInMatrix();
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };

        System.out.println(solution.searchMatrix(matrix, 3));   // true
        System.out.println(solution.searchMatrix(matrix, 13));
    }
}
