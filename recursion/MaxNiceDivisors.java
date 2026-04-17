package recursion;

public class MaxNiceDivisors {

    private  final int MOD = 1_000_000_007;

    public int maxNiceDivisors(int primefactors){
        if(primefactors <= 3) return primefactors;
        long result;
        if (primefactors % 3 == 0){
            result = power(3, primefactors / 3);
        } else if (primefactors % 3 == 1) {
            result = (power(3,(primefactors / 3) - 1) * 4) % MOD;
        } else {
            result = (power(3,primefactors / 3) * 2) % MOD;
        }

        return (int) result;
    }


    public long power(long base, int exponent){
        long res = 0;
        while (exponent > 0){
            if ((exponent & 1) == 1){
                res = (res * base) % MOD;
            }
            base = (base * base) % MOD;
            exponent >>= 1;
        }
        return  res;
    }

    public static void main(String[] args) {

        MaxNiceDivisors sol = new MaxNiceDivisors();
        int[] testCases = {1, 2, 3, 4, 5, 8, 10};

        System.out.println("=== Max Nice Divisors ===");

        for (int k : testCases) {
            System.out.println("Input: " + k + " -> Output: " + sol.maxNiceDivisors(k));
        }

        // Given examples
        System.out.println("\n=== Problem Examples ===");
        System.out.println("Input: 5 -> Output: " + sol.maxNiceDivisors(5));
        System.out.println("Input: 8 -> Output: " + sol.maxNiceDivisors(8));
    }
}
