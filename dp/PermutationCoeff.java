package dp;

public class PermutationCoeff {

    private static final int MOD = 1_000_000_007;

    public int PermutationCoeff(int n , int k){
        //edge cases
        if (k > n) return 0;
        if (k == 0) return 1;

        long result = 1;
        //compute n * (n - 1) * (n - k  + 1)
        for (int i = 0; i < k; i++) {
            result = (result * (n - i)) % MOD;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        PermutationCoeff sol = new PermutationCoeff();

        System.out.println(sol.PermutationCoeff(10, 2)); // 90
        System.out.println(sol.PermutationCoeff(10, 3)); // 720

    }
}
