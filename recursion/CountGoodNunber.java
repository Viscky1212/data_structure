package recursion;

public class CountGoodNunber {

    private static final long MOD = 1_000_000_007;

    public int countGoodNumbers(long n){
        long evenPos = (n + 1) /2;
        long oddPos = n / 2;

        long enenWays = power(5, evenPos);
        long oddWays = power(4,oddPos);

        return (int)((enenWays * oddWays) % MOD);
    }

    private long power(long base, long exp){

        long res = 1;
        while (exp > 0){
            if ((exp & 1)  == 1){
                res = (res * base) % MOD;
            }

            base = (base * base) % MOD;
            exp >>= 1;
        }
        return res;
    }


    public static void main(String[] args) {
        CountGoodNunber sol = new CountGoodNunber();
        System.out.println(sol.countGoodNumbers(1));  // 5
        System.out.println(sol.countGoodNumbers(4));  // 400
        System.out.println(sol.countGoodNumbers(50)); // 564908303
    }
}
