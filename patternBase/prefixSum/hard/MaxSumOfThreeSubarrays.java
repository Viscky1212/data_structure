package patternBase.prefixSum.hard;

public class MaxSumOfThreeSubarrays {
    // sol - 2
    public static int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }

        int[] left = new int[n];
        int total = sum[k] - sum[0];
        left[k - 1] = 0;
        for (int i = k; i < n; i++) {
            if (sum[i + 1] - sum[i + 1 - k] > total) {
                total = sum[i + 1] - sum[i + 1 - k];
                left[i] = i + 1 - k;
            } else {
                left[i] = left[i - 1];
            }
        }

        int[] right = new int[n];
        total = sum[n] - sum[n - k];
        right[n - k] = n - k;
        for (int i = n - k - 1; i >= 0; i--) {
            if (sum[i + k] - sum[i] >= total) {
                total = sum[i + k] - sum[i];
                right[i] = i;
            } else {
                right[i] = right[i + 1];
            }
        }

        int[] result = new int[3];
        total = 0;
        for (int j = k; j <= n - 2 * k; j++) {
            int i = left[j - 1], l = right[j + k];
            int currentSum = (sum[i + k] - sum[i]) + (sum[j + k] - sum[j]) + (sum[l + k] - sum[l]);
            if (currentSum > total) {
                total = currentSum;
                result[0] = i;
                result[1] = j;
                result[2] = l;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 2, 6, 7, 5, 1};
        int k = 2;
        int[] result = maxSumOfThreeSubarrays(nums, k);
        System.out.println("Starting indices of the three subarrays: [" + result[0] + ", " + result[1] + ", " + result[2] + "]");
    }
}
