package recursion;

public class KthCharacterGame {

    public static char kthCharacter(long k, int[] operations){
        int n = operations.length;

        //Step 1 Compute lengths
        long[] len = new long[n + 1];
        len[0] = 1;

        for (int i = 1; i <= n ; i++) {
            len[i] = Math.min(len[i - 1] * 2, k);
        }
        int shift = 0;

        //Step 2 : Traverse backwords
        for (int i = n; i > 0 ; i--) {
            long half = len[i - 1];

            if (k > half){
                k -= half;

                if (operations[i - 1] == 1){
                    shift++;
                }
            }
        }
        return (char) ('a' + (shift % 26));
    }

    public static void main(String[] args) {

        // Example 1
        long k1 = 5;
        int[] ops1 = {0, 0, 0};
        System.out.println("Output: " + kthCharacter(k1, ops1)); // a

        // Example 2
        long k2 = 10;
        int[] ops2 = {0, 1, 0, 1};
        System.out.println("Output: " + kthCharacter(k2, ops2)); // b

        // Additional tests
        long k3 = 1;
        int[] ops3 = {1, 1, 1};
        System.out.println("Output: " + kthCharacter(k3, ops3));

        long k4 = 1000000000000L;
        int[] ops4 = {1, 0, 1, 1, 0};
        System.out.println("Output: " + kthCharacter(k4, ops4));
    }
}
