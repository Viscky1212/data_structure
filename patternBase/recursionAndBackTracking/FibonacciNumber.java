package patternBase.recursionAndBackTracking;

public class FibonacciNumber {
    public static int fibonacci(int n) {
        if (n <= 1) {
            System.out.println("Fibonacci(" + n + ") = " + n);
            return n;
        }
        System.out.println("Calculating Fibonacci(" + n + ")");
        int ans1 = fibonacci(n - 1);
        int ans2 = fibonacci(n - 2);
        System.out.println("Fibonacci(" + n + ") = Fibonacci(" + (n - 1) + ") + Fibonacci(" + (n - 2) + ") = " + ans1 + " + " + ans2 + " = " + (ans1 + ans2));
        return ans1 + ans2;
    }


    public static void main(String[] args) {
        int n = 5; // Change this value to compute a different Fibonacci number
        int result = fibonacci(n);
        System.out.println("Fibonacci number at position " + n + " is: " + result);
    }
}
