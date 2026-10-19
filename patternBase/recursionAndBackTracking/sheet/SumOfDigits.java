package patternBase.recursionAndBackTracking.sheet;

public class SumOfDigits {
//    public int sumOfDigits(int n) {
//        if (n == 0) {
//            return 0;
//        }
//        return (n % 10) + sumOfDigits(n / 10);
//    }

    public int sumOfDigits(int n) {

        int sum = 0;

        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }

        return sum;
    }

    public static void main(String[] args) {
        SumOfDigits sumOfDigits = new SumOfDigits();
        int n = 12345; // Change this value to test different numbers
        int result = sumOfDigits.sumOfDigits(n);
        System.out.println("Sum of digits in " + n + " is: " + result);
    }
}
