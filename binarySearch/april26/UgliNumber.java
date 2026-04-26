package binarySearch.april26;

public class UgliNumber {


    public int nthUglyNumber(int n, int a, int b, int c) {

        long low = 1;
        long high = 2_000_000_000L;

        // Precompute LCMs
        long ab = lcm(a, b);
        long bc = lcm(b, c);
        long ac = lcm(a, c);
        long abc = lcm(a, bc);

        while (low < high) {

            long mid = low + (high - low) / 2;

            long count = count(mid, a, b, c, ab, bc, ac, abc);

            if (count >= n) {
                high = mid;  // possible answer
            } else {
                low = mid + 1;
            }
        }

        return (int) low;
    }

    private long count(long x, int a, int b, int c,
                       long ab, long bc, long ac, long abc) {

        return (x / a) + (x / b) + (x / c)
                - (x / ab) - (x / bc) - (x / ac)
                + (x / abc);
    }

    // GCD using Euclidean Algorithm
    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // LCM formula
    private long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    public static void main(String[] args) {

        UgliNumber sol = new UgliNumber();

        System.out.println(sol.nthUglyNumber(3, 2, 3, 5));  // Expected: 4
        System.out.println(sol.nthUglyNumber(4, 2, 3, 4));  // Expected: 6
        System.out.println(sol.nthUglyNumber(5, 2, 11, 13)); // Expected: 10
    }
}
