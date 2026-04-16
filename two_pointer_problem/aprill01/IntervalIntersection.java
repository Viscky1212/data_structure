package two_pointer_problem.aprill01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalIntersection {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList){
        List<int[]> result = new ArrayList<>();
        int i = 0; //pointer for firstList
        int j = 0; //Pointer for secondList

        while (i < firstList.length && j < secondList.length){
            int start = Math.max(firstList[i][0],secondList[j][0]);
            int end = Math.min(firstList[i][1],secondList[j][1]);

            if (start <= end){
                result.add(new int[]{start,end});
            }

            if (firstList[i][1] < secondList[j][1]) i++;
            else j++;
        }
        return result.toArray(new int[result.size()][]);
    }


    public static void main(String[] args) {
        IntervalIntersection sol = new IntervalIntersection();
        // Example 1
        int[][] first = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
        int[][] second = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};

        int[][] res1 = sol.intervalIntersection(first, second);
        System.out.println("Example 1 Output: " + Arrays.deepToString(res1));
        // Output: [[1, 2], [5, 5], [8, 10], [15, 23], [24, 24], [25, 25]]

        // Example 2
        int[][] empty = {};
        int[][] res2 = sol.intervalIntersection(first, empty);
        System.out.println("Example 2 Output: " + Arrays.deepToString(res2));
        // Output: []
    }
}
