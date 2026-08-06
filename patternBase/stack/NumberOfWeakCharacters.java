package patternBase.stack;

import java.util.Arrays;

public class NumberOfWeakCharacters {

    public static int numberOfWeakCharacters(int[][] properties) {
        // Sort the properties array based on attack in descending order
        // If attack is the same, sort based on defense in ascending order
        Arrays.sort(properties, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

        int maxDefense = 0;
        int weakCount = 0;

        for (int[] property : properties) {
            if (property[1] < maxDefense) {
                weakCount++;
            } else {
                maxDefense = property[1];
            }
        }

        return weakCount;
    }

    public static void main(String[] args) {

        int[][] properties = {{5, 5}, {6, 3}, {3, 6}};
        System.out.println(numberOfWeakCharacters(properties));
    }
}
