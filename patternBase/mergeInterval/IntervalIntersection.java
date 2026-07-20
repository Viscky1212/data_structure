package patternBase.mergeInterval;
import java.util.*;

public class IntervalIntersection {
    private static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i = 0, j = 0;
        List<int[]> result = new ArrayList<>();

        while (i < firstList.length && j < secondList.length) {
            int startMax = Math.max(firstList[i][0], secondList[j][0]);
            int endMin = Math.min(firstList[i][1], secondList[j][1]);

            if (startMax <= endMin) {
                result.add(new int[]{startMax, endMin});
            }

            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }

        return result.toArray(new int[result.size()][]);
    }
    public static void main(String[] args) {
        int[][] firstList = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
        int[][] secondList = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};

        int[][] result = intervalIntersection(firstList, secondList);

        for (int[] interval : result) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }
    }
}

/*
[Naive Approach] - Using Nested Loops - O(n ^ 2) Time and O(1) Space
[Expected Approach] - Using Sorting - O(n * log n) Time and O(1) Space
[Alternate Approach] - Using Prefix Sum


// Function to check if any two intervals
// in the given list intersect with each other
import java.util.*;

class GfG {

    // Function to check if any two intervals
    // in the given list intersect with each other
    static boolean isIntersect(int[][] intervals) {
        int n = intervals.length;

        // find the maximum end time
        int maxEnd = 0;
        for (int i = 0; i < n; i++) {
            maxEnd = Math.max(maxEnd, intervals[i][1]);
        }

        // create an array of size maxEnd
        // and initialize it with 0
        int[] arr = new int[maxEnd + 2];

        // iterate over all intervals
        for (int i = 0; i < n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            // increment the start time
            arr[start] += 1;

            // decrement the end time
            arr[end + 1] -= 1;
        }

        // iterate over the array and
        // calculate the prefix sum
        for (int i = 1; i <= maxEnd; i++) {
            arr[i] += arr[i - 1];

            // if the prefix sum is greater than 1
            // then the intervals intersect
            if (arr[i] > 1)
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {5, 7}, {2, 4}, {6, 8}};
        if (isIntersect(intervals))
            System.out.println("True");
        else
            System.out.println("False");
    }
}




// Function to check if any two intervals
// in the given list intersect with each other
import java.util.*;

class GfG {

    // Function to check if any two intervals
    // in the given list intersect with each other
    static boolean isIntersect(int[][] intervals) {
        int n = intervals.length;

        // sort the intervals based on the starting time
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });

        // check if any of the interval
        // intersects with its previous
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] <= intervals[i - 1][1])
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {5, 7}, {2, 4}, {6, 8}};
        if (isIntersect(intervals))
            System.out.println("True");
        else
            System.out.println("False");
    }
}



// Function to check if any two intervals
// intersect with each other
import java.util.*;

class GfG {

    // Function to check if any two intervals
    // intersect with each other
    static boolean isIntersecting(int[] a, int[] b) {
        if (a[1] < b[0] || b[1] < a[0])
            return false;
        return true;
    }

    // Function to check if any two intervals
    // in the given list intersect with each other
    static boolean isIntersect(int[][] intervals) {
        int n = intervals.length;

        // Iterate over all pairs of intervals
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                // check, if two intervals intersect
                if (isIntersecting(intervals[i], intervals[j]))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {5, 7}, {2, 4}, {6, 8}};
        if (isIntersect(intervals))
            System.out.println("True");
        else
            System.out.println("False");
    }
}







 */
