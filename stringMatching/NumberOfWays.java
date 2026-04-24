package stringMatching;

public class NumberOfWays {
    private static final long MOD = 1_000_000_007L;

    public int numberOfWays(String s, String t, long k){
        int n = s.length();
        int matchCount = countMatchingRelation(s,t);
        boolean zeroShiftMatch = s.equals(t);

        long[][] transaction = {
                {0, n - 1L},
                {1, n - 2L}
        };

        long[][] power = matrixPower(transaction, k);

        long waysToZero = power[0][0];
        long waysToNonZero = power[1][0];

        long answer;

        if (zeroShiftMatch){
            answer = (waysToZero + ((long) (matchCount - 1) * waysToNonZero) % MOD) % MOD;
        } else {
            answer = ((long) matchCount * waysToNonZero) % MOD;
        }
        return (int) answer;
    }

    private int countMatchingRelation(String s, String t){
        String combined = t + "#" + s + s;
        int[] lps = buildLPS(combined);

        int n = s.length();
        int targetLength = t.length();
        int count = 0;

        for (int i = targetLength + 1; i < combined.length(); i++) {
            if (lps[i] == targetLength){
                int startInDoubleString = i - 2* targetLength;
                if (startInDoubleString >= 0 && startInDoubleString < n) count++;
            }
        }
        return count;
    }

    public int[] buildLPS(String str){
        int[] lps = new int[str.length()];
        int len = 0;

        for (int i = 1; i < str.length(); i++) {
            while (len > 0 && str.charAt(i) != str.charAt(len)){
                len = lps[len - 1];
            }

            if (str.charAt(i) == str.charAt(len)){
                len++;
                lps[i] = len;
            }
        }
        return lps;
    }

    private long[][] matrixPower(long[][] base,long exp){
    long[][] result = {
            {1 , 0},
            {0 , 1}
    };

    while (exp > 0){
        if ((exp & 1) == 1){
            result = multiply(result,base);
        }
        base = multiply(base,base);
        exp >>= 1;
    }
    return result;
    }

    private long[][] multiply(long[][] a, long[][] b) {
        long[][] product = new long[2][2];

        product[0][0] = (a[0][0] * b[0][0] + a[0][1] * b[1][0]) % MOD;
        product[0][1] = (a[0][0] * b[0][1] + a[0][1] * b[1][1]) % MOD;
        product[1][0] = (a[1][0] * b[0][0] + a[1][1] * b[1][0]) % MOD;
        product[1][1] = (a[1][0] * b[0][1] + a[1][1] * b[1][1]) % MOD;

        return product;
    }

    public static void main(String[] args) {
        NumberOfWays sol = new NumberOfWays();
        String s1 = "abcd";
        String t1 = "cdab";
        long k1 = 2;
        System.out.println("Output: " + sol.numberOfWays(s1, t1, k1)); // 2

        String s2 = "ababab";
        String t2 = "ababab";
        long k2 = 1;
        System.out.println("Output: " + sol.numberOfWays(s2, t2, k2)); // 2
    }
}
