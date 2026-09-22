package patternBase.recursionAndBackTracking;

import java.util.Arrays;

public class FindMaxNumberInArray {

    public static void main(String[] args) {
//        int[] arr = {1,2,3,4,5,6,7};
//
//        System.out.println(findMax(arr,  arr.length));

        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int max = findMax(arr, 0, arr.length - 1);
        System.out.println("Maximum number in the array: " + max);

        int max2 = Arrays.stream(arr)
                .max()
                .orElseThrow(() ->
                        new IllegalArgumentException("Array is empty"));

        System.out.println("Maximum number using Streams: " + max2);

    }

//    public static int findMax(int[] arr, int n) {
//
//        if (n == 1) {
//            return arr[0];
//        }
//
//       int last = arr[n - 1];
//       int ans = findMax(arr, n - 1);
//       return Math.max(last, ans);
//    }

    public static int findMax(int[] arr, int start, int end) {
        if (start == end) {
            return arr[start];
        }

        int mid = start + (end - start) / 2;
        System.out.println("Start: " + start + ", End: " + end + ", Mid: " + mid);

        int leftMax = findMax(arr, start, mid);
        System.out.println("Left Max: " + leftMax);
        int rightMax = findMax(arr, mid + 1, end);
        System.out.println("Right Max: " + rightMax);

        return Math.max(leftMax, rightMax);

    }
}
