package patternBase.mergeInterval;

import java.util.*;

// solution for merging overlapping intervals - 1
public class MergeIntervals {

//    public static int[][] merge(int[][] intervals) {
//        if (intervals.length == 0) {
//            return new int[0][];
//        }
//
//        // Sort intervals based on the start time
//        java.util.Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
//
//        java.util.List<int[]> merged = new java.util.ArrayList<>();
//        int[] currentInterval = intervals[0];
//
//        for (int i = 1; i < intervals.length; i++) {
//            if (currentInterval[1] >= intervals[i][0]) { // Overlapping intervals
//                currentInterval[1] = Math.max(currentInterval[1], intervals[i][1]);
//            } else { // Non-overlapping interval
//                merged.add(currentInterval);
//                currentInterval = intervals[i];
//            }
//        }
//        merged.add(currentInterval); // Add the last interval
//
//        return merged.toArray(new int[merged.size()][]);
//    }


     // ⭐ CHANGED 1: Method name should be merge()
     public static int[][] merge(int[][] intervals) {

         if (intervals == null || intervals.length <= 1) {
             return intervals;
         }

         // Step 1: Sort using Merge Sort
         mergeSort(intervals, 0, intervals.length - 1);

         // Step 2: Merge overlapping intervals
         List<int[]> result = new ArrayList<>();

         int[] current = intervals[0];

         for (int i = 1; i < intervals.length; i++) {

             if (intervals[i][0] <= current[1]) {
                 current[1] = Math.max(current[1], intervals[i][1]);
             } else {
                 result.add(current);
                 current = intervals[i];
             }
         }

         result.add(current);

         return result.toArray(new int[result.size()][]);
     }

     private static void mergeSort(int[][] arr, int left, int right) {

         // ⭐ CHANGED 2: Base condition
         if (left >= right) {
             return;
         }

         int mid = left + (right - left) / 2;

         mergeSort(arr, left, mid);
         mergeSort(arr, mid + 1, right);

         // ⭐ CHANGED 3: Helper method renamed
         mergeArray(arr, left, mid, right);
     }

     // ⭐ CHANGED 3: Renamed from merge() to mergeArray()
     private static void mergeArray(int[][] arr, int left, int mid, int right) {

         int[][] temp = new int[right - left + 1][];

         int i = left;
         int j = mid + 1;
         int k = 0;

         while (i <= mid && j <= right) {

             if (arr[i][0] <= arr[j][0]) {
                 temp[k++] = arr[i++];
             } else {
                 temp[k++] = arr[j++];
             }
         }

         while (i <= mid) {
             temp[k++] = arr[i++];
         }

         while (j <= right) {
             temp[k++] = arr[j++];
         }

         for (int x = 0; x < temp.length; x++) {
             arr[left + x] = temp[x];
         }
     }
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] mergedIntervals = merge(intervals);

        for (int[] interval : mergedIntervals) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }
    }
}
