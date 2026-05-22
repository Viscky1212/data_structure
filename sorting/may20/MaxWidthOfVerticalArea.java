package sorting.may20;

import java.util.Arrays;
//sol : 2
public class MaxWidthOfVerticalArea {

    public int maxWidthOfVerticalArea(int[][] points){
        Arrays.sort(points,(a,b) ->Integer.compare(a[0],b[0]));


        int maxWidth = 0;

        for (int i = 1; i < points.length; i++) {
            int width = points[i][0] - points[i - 1][0];
            maxWidth = Math.max(maxWidth,width);
        }

        return maxWidth;
    }

    public static void main(String[] args) {
        MaxWidthOfVerticalArea sol = new MaxWidthOfVerticalArea();
        int[][] points1 = {
                {8, 7}, {9, 9}, {7, 4}, {9, 7}
        };
        System.out.println(sol.maxWidthOfVerticalArea(points1));
        // Output: 1

        int[][] points2 = {
                {3, 1}, {9, 0}, {1, 0}, {1, 4}, {5, 3}, {8, 8}
        };
        System.out.println(sol.maxWidthOfVerticalArea(points2));
        // Output: 3
    }
}
