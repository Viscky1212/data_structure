package patternBase.prefixSum.hard;

public class CountRangeSum {

    public int count = 0;

    public static int countRangeSum(int[] nums, int lower, int upper) {

        long[] prefix = new long[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        return mergeSort(prefix, 0, prefix.length - 1, lower, upper);
    }

    private static int mergeSort(long[] sum, int left, int right, int lower, int upper) {

        if (left >= right)
            return 0;

        int mid = left + (right - left) / 2;

        int count = mergeSort(sum, left, mid, lower, upper)
                + mergeSort(sum, mid + 1, right, lower, upper);

        int low = mid + 1;
        int high = mid + 1;

        // Count valid pairs
        for (int i = left; i <= mid; i++) {

            while (low <= right && sum[low] - sum[i] < lower)
                low++;

            while (high <= right && sum[high] - sum[i] <= upper)
                high++;

            count += high - low;
        }

        // Merge sorted halves
        long[] temp = new long[right - left + 1];

        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {
            if (sum[i] <= sum[j])
                temp[k++] = sum[i++];
            else
                temp[k++] = sum[j++];
        }

        while (i <= mid)
            temp[k++] = sum[i++];

        while (j <= right)
            temp[k++] = sum[j++];

        System.arraycopy(temp, 0, sum, left, temp.length);

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 5, -1};
        int lower = -2;
        int upper = 2;

        int result = countRangeSum(nums, lower, upper);
        System.out.println("Count of range sums: " + result); // Output: 3
    }
}
