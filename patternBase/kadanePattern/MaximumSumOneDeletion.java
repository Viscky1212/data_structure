package patternBase.kadanePattern;

public class MaximumSumOneDeletion {
    public int maximumSum2(int[] arr) {
        // max subarray sum ending here without any deletion
        int noDelete = arr[0];

        // max subarray sum ending here with one deletion used
        int oneDelete = 0;

        // overall maximum answer
        int answer = arr[0];

        for (int i = 1; i < arr.length; i++) {
            // if we use one deletion, there are 2 choices:
            // 1. delete current element -> take previous noDelete
            // 2. keep current element and extend previous oneDelete
            oneDelete = Math.max(noDelete, oneDelete + arr[i]);

            // normal Kadane: either start fresh or extend
            noDelete = Math.max(arr[i], noDelete + arr[i]);

            // update final answer
            answer = Math.max(answer, Math.max(noDelete, oneDelete));
        }

        return answer;
    }

    public static int maximumSum(int[] arr) {
        int n = arr.length;
        int maxSumNoDeletion = arr[0];
        int maxSumWithDeletion = 0;
        int result = arr[0];

        for (int i = 1; i < n; i++) {
            maxSumWithDeletion = Math.max(maxSumNoDeletion, maxSumWithDeletion + arr[i]);
            maxSumNoDeletion = Math.max(arr[i], maxSumNoDeletion + arr[i]);
            result = Math.max(result, Math.max(maxSumNoDeletion, maxSumWithDeletion));
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, -2, 0, 3};
        int result = maximumSum(arr);
        System.out.println("Maximum subarray sum with at most one deletion: " + result); // Output: 4
    }
}
