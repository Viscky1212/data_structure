package priorityQueue;

public class ArrayRepresentsBinaryHeap {

    // Function to check if array represents a Max Heap
    public static boolean countSub(long arr[], long n) {

        // Traverse all internal nodes
        for (int i = 0; i <= (n / 2) - 1; i++) {

            int left = 2 * i + 1;
            int right = 2 * i + 2;

            // Check left child
            if (left < n && arr[i] < arr[left]) {
                return false;
            }

            // Check right child
            if (right < n && arr[i] < arr[right]) {
                return false;
            }
        }

        return true;
    }

    // Main method for testing
    public static void main(String[] args) {

        long arr[] = {90, 15, 10, 7, 12, 2};
        long n = arr.length;

        boolean result = countSub(arr, n);

        if (result) {
            System.out.println("1"); // Represents True
        } else {
            System.out.println("0"); // Represents False
        }
    }
}
