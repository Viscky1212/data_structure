package patternBase.recursionAndBackTracking.sheet;

public class ArrayIsSorted {

    public boolean isSorted(int[] arr, int index) {
        // Base case: If we reach the last element or the array has only one element
        if (index == arr.length - 1 || arr.length == 1) {
            return true;
        }

        // Check if the current element is greater than the next element
        if (arr[index] > arr[index + 1]) {
            return false;
        }

        // Recursive call to check the next pair of elements
        return isSorted(arr, index + 1);
    }

    public static void main(String[] args) {
        ArrayIsSorted arrayIsSorted = new ArrayIsSorted();
        int[] arr = {1, 2, 3, 4, 5}; // Change this array to test different cases
        boolean result = arrayIsSorted.isSorted(arr, 0);
        System.out.println("Is the array sorted? " + result);
    }
}
