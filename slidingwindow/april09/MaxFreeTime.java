package slidingwindow.april09;

public class MaxFreeTime {


    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {

        int n = startTime.length;

        // Step 1: durations
        int[] duration = new int[n];
        for (int i = 0; i < n; i++) {
            duration[i] = endTime[i] - startTime[i];
        }

        // Step 2: prefix sum of durations
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + duration[i];
        }

        int maxFree = 0;

        for (int i = 0; i < n; i++) {

            int j = Math.min(n - 1, i + k - 1);

            // left boundary
            int left = (i == 0) ? 0 : endTime[i - 1];

            // right boundary
            int right = (j == n - 1) ? eventTime : startTime[j + 1];

            // total duration of removed meetings
            long removed = prefix[j + 1] - prefix[i];

            // free time = total gap - remaining meetings inside
            int free = (int)(right - left - removed);

            maxFree = Math.max(maxFree, free);
        }

        return maxFree;
    }

    public static void main(String[] args) {
        MaxFreeTime sol = new MaxFreeTime();

        int eventTime1 = 5;
        int[] start1 = {1,3};
        int[] end1 = {2,5};
        System.out.println(sol.maxFreeTime(eventTime1, 1, start1, end1)); // ✅ 2

        int eventTime2 = 10;
        int[] start2 = {0,2,9};
        int[] end2 = {1,4,10};
        System.out.println(sol.maxFreeTime(eventTime2, 1, start2, end2)); // ✅ 6
    }
}
