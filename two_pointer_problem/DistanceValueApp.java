package two_pointer_problem;

import java.util.Arrays;
import java.util.Map;

public class DistanceValueApp {


    public static void main(String[] args) {
        DistanceValueApp solution = new DistanceValueApp();
        int[] arr1 = {4,5,8};
        int[] arr2 = {10,9,1,8};
        int d = 2;

        System.out.println("Result: " +
                solution.findTheDistanceValue(arr1, arr2, d));
    }

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {

        Arrays.sort(arr2);
        int count = 0;

        for (int num : arr1) {

            if (isValid(arr2, num, d)) {
                count++;
            }
        }

        return count;
    }

    private boolean isValid(int[] arr, int target, int d) {

        int idx = lowerBound(arr, target);

        // Check right neighbor
        if (idx < arr.length && Math.abs(arr[idx] - target) <= d) {
            return false;
        }

        // Check left neighbor
        if (idx > 0 && Math.abs(arr[idx - 1] - target) <= d) {
            return false;
        }

        return true;
    }

    // Standard lower bound (first element >= target)
    private int lowerBound(int[] arr, int target) {

        int left = 0, right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
