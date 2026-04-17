package recursion;

public class MinNonZeroProduct {
    private static final long MOD = 1_000_000_007L;

    public int minNonZeroProduct(int p){
        if (p == 1){
            return 1;
        }

        long max = (1L << p) - 1;
        long secondMax = max - 1;
        long exponent = (1L << (p - 1)) - 1;

        long part1 = modPow(secondMax % MOD,exponent,MOD);
        long part2 = max % MOD;

        return (int) ((part1 * part2) % MOD);
    }

    private long modPow(long base, long exp, long mod){
        long res = 1;
        while (exp > 0){
            if ((exp & 1) == 1){
                res = (res * base) % MOD;
            }
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return res;
    }


    public static void main(String[] args) {
        MinNonZeroProduct sol = new MinNonZeroProduct();

        int p1 = 1;
        int p2 = 2;
        int p3 = 3;

        System.out.println("Input: p = " + p1 + ", Output: " + sol.minNonZeroProduct(p1));
        System.out.println("Input: p = " + p2 + ", Output: " + sol.minNonZeroProduct(p2));
        System.out.println("Input: p = " + p3 + ", Output: " + sol.minNonZeroProduct(p3));
    }
}
