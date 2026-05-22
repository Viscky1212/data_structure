package sorting.may21;

import java.util.Arrays;

public class MinimumBoxes {

    public int minimumBoxes(int[] apple, int[] capacity){
        int totalApples = 0;
        for (int apples : apple){
            totalApples += apples;
        }

        Arrays.sort(capacity);

        int boxesUsed = 0;

        for (int i = capacity.length - 1; i >= 0; i--) {
            totalApples -= capacity[i];
            boxesUsed++;

            if (totalApples <= 0){
                return boxesUsed;
            }
        }
        return boxesUsed;
    }

    public static void main(String[] args) {
        MinimumBoxes sol = new MinimumBoxes();
        int[] apple1 = {1, 3, 2};
        int[] capacity1 = {4, 3, 1, 5, 2};
        System.out.println(sol.minimumBoxes(apple1, capacity1));
        // Output: 2

        int[] apple2 = {5, 5, 5};
        int[] capacity2 = {2, 4, 2, 7};
        System.out.println(sol.minimumBoxes(apple2, capacity2));
        // Output: 4

        int[] apple3 = {2, 3};
        int[] capacity3 = {1, 4};
        System.out.println(sol.minimumBoxes(apple3, capacity3));
        // Output: 2
    }
}
