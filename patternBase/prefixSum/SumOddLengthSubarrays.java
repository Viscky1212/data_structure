package patternBase.prefixSum;

public class SumOddLengthSubarrays {
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            // number of ways to choose starting point
            int leftChoices = i + 1;

            // number of ways to choose ending point
            int rightChoices = n - i;

            // total subarrays containing arr[i]
            int totalSubarrays = leftChoices * rightChoices;

            // among total subarrays, odd-length subarrays are half rounded up
            int oddCount = (totalSubarrays + 1) / 2;

            // contribution of current element
            sum += oddCount * arr[i];
        }

        return sum;
    }
    public static void main(String[] args) {
        SumOddLengthSubarrays calculator = new SumOddLengthSubarrays();
        int[] arr = {1, 4, 2, 5, 3};
        int sum = calculator.sumOddLengthSubarrays(arr);
        System.out.println("Sum of all odd-length subarrays: " + sum); // Output: 58
    }
}
