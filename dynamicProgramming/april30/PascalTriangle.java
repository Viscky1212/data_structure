package dynamicProgramming.april30;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public List<Integer> getRow(int rowIndex){
        List<Integer> row = new ArrayList<>();
        row.add(1);

        for (int i = 1; i <= rowIndex; i++) {
            row.add(1);
            for (int j = i - 1; j > 0; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }

        return row;
    }

    public static void main(String[] args) {

        PascalTriangle sol = new PascalTriangle();

        System.out.println(sol.getRow(3)); // [1,3,3,1]
        System.out.println(sol.getRow(0)); // [1]
        System.out.println(sol.getRow(1)); // [1,1]
    }
}
