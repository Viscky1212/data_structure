package sorting.may20;

import java.util.Arrays;

public class MaximumUnits {

    public int maximumUnits(int[][] boxTypes, int truckSize){
        Arrays.sort(boxTypes,(a,b) ->b[1] - a[1]);

        int totalUnits = 0;

        for (int[] box : boxTypes){
            int numberOfBoxes = box[0];
            int unitsPerBox = box[1];

            int boxesToTake = Math.min(numberOfBoxes,truckSize);

            totalUnits += boxesToTake * unitsPerBox;
            truckSize -= boxesToTake;

            if (truckSize == 0){
                break;
            }
        }
        return totalUnits;
    }

    public static void main(String[] args) {
        MaximumUnits sol = new MaximumUnits();
        int[][] boxTypes1 = {
                {1, 3}, {2, 2}, {3, 1}
        };
        int truckSize1 = 4;

        System.out.println(sol.maximumUnits(boxTypes1, truckSize1));
        // Output: 8

        int[][] boxTypes2 = {
                {5, 10}, {2, 5}, {4, 7}, {3, 9}
        };
        int truckSize2 = 10;

        System.out.println(sol.maximumUnits(boxTypes2, truckSize2));
        // Output: 91
    }
}
