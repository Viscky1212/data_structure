package patternBase.slidingWindow;
public class MaxSumSubarrayK {

    public static long maximumSumSubarray(int k, int[] arr) {

        long windowSum = 0;

        // First window
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        long maxSum = windowSum;

        // Slide window
        for (int i = k; i < arr.length; i++) {

            windowSum =
                    windowSum
                            - arr[i - k]
                            + arr[i];

            maxSum =
                    Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {

        int[] arr =
                {1, 4, 2, 10, 23, 3, 1, 0, 20};

        int k = 4;

        System.out.println(
                maximumSumSubarray(k, arr)
        );
    }
}