package patternBase.recursionAndBackTracking.sheet;

public class Fibonaccy {

    public int fib(int n) {
        if (n <= 1) {
            System.out.println("Fibonacci of -> " + n + " is: " + n);
            return n;
        }
      //  int result = fib(n - 2);
        int result2 = fib(n - 1);
     //   System.out.println("Fibonacci of -> " + n + " is: " + result);
        System.out.println("Fibonacci of -> " + n + " is: " + result2);
        return result2;
    }

//    public int fib(int n) {
//        if (n <= 1) {
//            System.out.println("Fibonacci of base case -> " + n + " is: " + n);
//            return n;
//        }
//        int first = fib(n - 1);
//        int second = fib(n - 2);
//        int result = first + second;
//        System.out.println("Fibonacci of -> " + n + " is: " + result);
//        return result;
//    }

    public static void main(String[] args) {

        Fibonaccy fibonacci = new Fibonaccy();
        int n = 5; // Change this value to compute a different Fibonacci number
        int result = fibonacci.fib(n);
        System.out.println("Fibonacci of -> " + n + " is: " + result);
    }
}


