package patternBase.binarySearch;// Java program to demonstrate working of an algorithm that finds
// an element in an array of infinite size
import java.util.*;

public class FindPositionOfElement {
    public static int binarySearch(ArrayList<Integer> arr, int target, int start, int end) {
        // Perform binary search within the range [start, end]
        while (start <= end) {
            // Calculate the mid index
            int mid = start + (end - start) / 2;

            // If target is smaller, search the left half
            if (target < arr.get(mid)) {
                end = mid - 1;
            }
            // If target is larger, search the right half
            else if (target > arr.get(mid)) {
                start = mid + 1;
            }
            // If target is found, return the index
            else {
                return mid;
            }
        }
        // If the target is not found, return -1
        return -1;
    }

    public static int findPos(ArrayList<Integer> arr, int target) {
        // Initialize start and end for the search range
        int start = 0;
        int end = 1;

        // Keep doubling the search range until the target
        // is within the range
        while (end < arr.size() && target > arr.get(end)) {
            // Temporarily store the current end
            // as new start
            int temp = end + 1;

            // Double the box size and update the end index
            end = end + (end - start + 1) * 2;

            // Clamp end if it goes out of array bounds
            if (end >= arr.size())
                end = arr.size() - 1;

            // Update start to the old end + 1
            start = temp;
        }

        // Perform binary search within the found range
        return binarySearch(arr, target, start, end);
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170));

        int target = 170;
        int ans = findPos(arr, target);
        System.out.println(ans);
    }
}