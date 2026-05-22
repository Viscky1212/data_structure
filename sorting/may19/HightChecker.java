package sorting.may19;

import java.util.Arrays;

public class HightChecker {

    public int heightChecker(int[] heights){
        int[] expected = heights.clone();
        Arrays.sort(expected);

        int count = 0;

        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expected[i]){
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        HightChecker sol = new HightChecker();
        int[] heights1 = {1, 1, 4, 2, 1, 3};
        System.out.println(sol.heightChecker(heights1));
        // Output: 3

        int[] heights2 = {5, 1, 2, 3, 4};
        System.out.println(sol.heightChecker(heights2));
        // Output: 5

        int[] heights3 = {1, 2, 3, 4, 5};
        System.out.println(sol.heightChecker(heights3));
        // Output: 0
    }
}
