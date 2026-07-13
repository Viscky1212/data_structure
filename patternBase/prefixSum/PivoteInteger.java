package patternBase.prefixSum;

public class PivoteInteger {

    public int pivotInteger(int n) {
        int totalSum = n * (n + 1) / 2; // Sum of first n integers
        int leftSum = 0;

        for (int i = 1; i <= n; i++) {
            leftSum += i;
            if (leftSum == totalSum - leftSum + i) {
                return i; // Found the pivot integer
            }
        }

        return -1; // No pivot integer found
    }
    public static void main(String[] args) {
        PivoteInteger calculator = new PivoteInteger();
        int pivot = calculator.pivotInteger(8);
        System.out.println("Pivot integer: " + pivot); // Output: 6
    }
}
