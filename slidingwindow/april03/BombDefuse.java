package slidingwindow.april03;

import java.util.Arrays;

public class BombDefuse {

    public int[] decrypt(int[] code, int k) {

        int n = code.length;
        int[] res = new int[n];

        if (k == 0) return res;

        int windowSum = 0;
        int start = 1, end = k;

        if (k < 0) {
            k = -k;
            start = n - k;
            end = n - 1;
        }

        // initial window
        for (int i = start; i <= end; i++) {
            windowSum += code[i % n];
        }

        for (int i = 0; i < n; i++) {
            res[i] = windowSum;

            // slide window correctly
            windowSum -= code[start % n];
            start++;
            end++;
            windowSum += code[end % n];
        }

        return res;
    }

    public static void main(String[] args) {
        BombDefuse sol = new BombDefuse();
        int[] code = {5, 7, 1, 4};
        int k = 3;

        int[] result = sol.decrypt(code, k);

        System.out.println("Decrypted Code:");
        System.out.println(Arrays.toString(result));
    }
}
