package binarySearch.april30;

import java.util.Arrays;
import java.util.Map;

public class NonOverlapping {

    public int maxTwoEvents(int[][] events){
        //Step 1 ; sort by start time
        Arrays.sort(events,(a,b) -> a[0] - b[0]);

        int n = events.length;

        //Step 2 : max suffix array
        int[] mazSuffix = new int[n];
        mazSuffix[n - 1] = events[n - 1][2];

        for (int i = n - 2; i >= 0 ; i--) {
            mazSuffix[i] = Math.max(events[i][2],mazSuffix[i + 1]);
        }

        int maxValue = 0;

        //Step 3 : process each event
        for (int i = 0; i < n; i++) {
            int currValue = events[i][2];

            //Binary search for next non- overlapping event
            int nextIndex = binarySearch(events,events[i][1]);

            if (nextIndex != -1){
                currValue += mazSuffix[nextIndex];
            }
            maxValue = Math.max(maxValue,currValue);
        }
        return maxValue;
    }

    private int binarySearch(int[][] events , int endTime){
        int left = 0, right = events.length - 1;
        int ans = -1;

        while (left <= right){
            int mid = left + (right - left) / 2;

            if (events[mid][0] > endTime){
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        NonOverlapping sol = new NonOverlapping();

        int[][] events1 = {{1, 3, 2}, {4, 5, 2}, {2, 4, 3}};
        System.out.println(sol.maxTwoEvents(events1)); // 4

        int[][] events2 = {{1, 3, 2}, {4, 5, 2}, {1, 5, 5}};
        System.out.println(sol.maxTwoEvents(events2)); // 5

        int[][] events3 = {{1, 5, 3}, {1, 5, 1}, {6, 6, 5}};
        System.out.println(sol.maxTwoEvents(events3)); // 8
    }

}
