package recursion;

public class MonkeyMove {

    private static final long MOD = 1_000_000_007L;

    public int monkeyMove(int n){
        long totalWays = modPow(2,n);
        long noCollisionWay = 2;
        long result = (totalWays - noCollisionWay + MOD) % MOD;
        return (int) result;
    }

    private long modPow(long base, long exp){
        long result = 1;
        base %= MOD;

        while (exp > 0){
            if ((exp & 1) == 1){
                result = (result * base) % MOD;
            }

            base = (base * base) % MOD;
            exp >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        MonkeyMove sol = new MonkeyMove();

        int n1 = 3;
        int n2 = 4;

        System.out.println("Input: n = " + n1);
        System.out.println("Output: " + sol.monkeyMove(n1));

        System.out.println("Input: n = " + n2);
        System.out.println("Output: " + sol.monkeyMove(n2));
    }
}
