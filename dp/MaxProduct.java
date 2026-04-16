package dp;

import java.util.Scanner;

public class MaxProduct {
    // Function to calculate maximum product
    public long maxProduct(int n) {

        // Edge cases (mandatory cut)
        if (n <= 1) return 0;
        if (n == 2) return 1;
        if (n == 3) return 2;

        long result = 1;

        // Greedy: break into 3s
        while (n > 4) {
            result = result * 3;
            n -= 3;
        }

        // Multiply remaining part
        result = result * n;

        return result;
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter you digit := ");
        int n = sc.nextInt(); // Input


        MaxProduct s = new MaxProduct();
        long ans = s.maxProduct(n);

        System.out.println(ans); // Output

        sc.close();
    }
}
