package dp;

public class MaxSumIS {

    public int maxSumIS(int arr[]){
        int n = arr.length;

        //step 1 : dp array
        int[] dp = new int[n];

        //initialize with self value
        for (int i = 0; i < n; i++) {
            dp[i] = arr[i];
        }

        int maxSum = arr[0];

        //Step 2 : Build dp
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]){
                    dp[i] = Math.max(dp[i],dp[j] + arr[i]);
                }
            }
            maxSum = Math.max(maxSum,dp[i]);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        MaxSumIS sol = new MaxSumIS();

        int[] arr1 = {1, 101, 2, 3, 100};
        System.out.println(sol.maxSumIS(arr1)); // 106

        int[] arr2 = {4, 1, 2, 3};
        System.out.println(sol.maxSumIS(arr2)); // 6
    }
}
