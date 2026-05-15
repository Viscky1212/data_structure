package hashtable.may11;


//Sol : 4
public class CheckValid {

    public boolean checkValid(int[][] matrix){
        int n = matrix.length;
        //check in row
        for (int i = 0; i < n; i++) {
            boolean[] seen = new boolean[n + 1];

            for (int j = 0; j < n; j++) {
                int num = matrix[i][j];

                if (seen[num]){
                    return false;
                }
                seen[num] = true;
            }
        }

        //check column
        for (int j = 0; j < n; j++) {
            boolean[] seen = new boolean[n + 1];

            for (int i = 0; i < n; i++) {
                int num = matrix[i][j];

                if (seen[num]){
                    return false;
                }
                seen[num] = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CheckValid sol = new CheckValid();
        int[][] matrix1 = {
                {1,2,3},
                {3,1,2},
                {2,3,1}
        };

        System.out.println(sol.checkValid(matrix1));
        // true


        int[][] matrix2 = {
                {1,1,1},
                {1,2,3},
                {1,2,3}
        };

        System.out.println(sol.checkValid(matrix2));
        // false
    }

}
