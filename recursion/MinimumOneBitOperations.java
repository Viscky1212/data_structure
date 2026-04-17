package recursion;

public class MinimumOneBitOperations {

    public static int minimumOneBitOperations(int n){
        int res = 0;
        while (n > 0){
            res ^= n;
            n >>= 1;
        }
        return res;
    }

    public static int minimumOneBitOperationsRecursive(int n){
        if (n == 0) return 0;

        int k = highestBit(n);

        return ((1 << (k + 1)) - 1) - minimumOneBitOperationsRecursive(n ^ (1 << k));
    }

    public static int highestBit(int n){
        int pos = 0;
        while((1 << (pos + 1)) <= n){
            pos++;
        }
        return pos;
    }

    /**
     * Main method (Entry point)
     */
    public static void main(String[] args) {

        // Test cases
        int[] testCases = {0, 1, 2, 3, 4, 6, 9, 10};

        System.out.println("=== Minimum One Bit Operations ===");

        for (int n : testCases) {
            int result = minimumOneBitOperations(n);
            System.out.println("Input: " + n + " -> Output: " + result);
        }

        // Specific examples from problem
        System.out.println("\n=== Problem Examples ===");

        int n1 = 3;
        int n2 = 6;

        System.out.println("Input: " + n1 + " Output: " + minimumOneBitOperations(n1));
        System.out.println("Input: " + n2 + " Output: " + minimumOneBitOperations(n2));

        // Optional: Compare recursive vs optimized
        System.out.println("\n=== Recursive Verification ===");

        for (int n : testCases) {
            int iterative = minimumOneBitOperations(n);
            int recursive = minimumOneBitOperationsRecursive(n);

            System.out.println("n = " + n +
                    " | Iterative = " + iterative +
                    " | Recursive = " + recursive);
        }
    }
}
