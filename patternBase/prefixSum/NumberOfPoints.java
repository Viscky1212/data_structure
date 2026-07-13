package patternBase.prefixSum;

import java.util.Arrays;
import java.util.List;

public class NumberOfPoints {

    public int numberOfPoints(List<List<Integer>> nums) {
        int[] points = new int[101]; // Assuming the range of points is from 0 to 100
        for (List<Integer> interval : nums) {
            int start = interval.get(0);
            int end = interval.get(1);
            points[start]++;
            points[end + 1]--;
        }
        int count = 0;
        int acctive = 0;
        for (int i = 0; i < points.length; i++) {
            acctive += points[i];
            if (acctive > 0) {
                count++;
            }
        }
        return count;

    }

    public static void main(String[] args) {
        NumberOfPoints sol = new NumberOfPoints();
        List<List<Integer>> nums = Arrays.asList(
            Arrays.asList(2, 4),
            Arrays.asList(1, 3),
            Arrays.asList(5, 7)
        );
        System.out.println("Number of points: " + sol.numberOfPoints(nums));
    }
}
