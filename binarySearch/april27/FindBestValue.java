package binarySearch.april27;

import java.util.Arrays;

public class FindBestValue {

    public int findBestValue(int[] arr, int target){
        Arrays.sort(arr);

        int n = arr.length;

        //prefix sum
        int[] prefix = new int[n];
        prefix[0] = arr[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        int low = 0, high = arr[n - 1];

        int bestVal = 0;
        int minDiff = Integer.MAX_VALUE;

        while (low <= high){
            int mid = low + (high - low) / 2;
            int currSum = computeSum(arr,prefix,mid);
            int diff = Math.abs(currSum - target);

            //update answer

            if (diff < minDiff || (diff == minDiff && mid < bestVal)){
                minDiff = diff;
                bestVal = mid;
            }

            //Binary search
            if (currSum < target){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return bestVal;
    }

    private int computeSum(int[] arr, int[] prefix, int val){
        int n = arr.length;

        //Binary search first index where arr[i] > val
        int idx = Arrays.binarySearch(arr,val);

        if (idx < 0){
            idx = -idx - 1;
        } else {
            while (idx < n && arr[idx] == val) idx++;
        }

        int sum = 0;
        if (idx > 0) sum += prefix[idx - 1];

        sum += (n - idx) * val;

        return sum;
    }

    public static void main(String[] args) {

        FindBestValue sol = new FindBestValue();

        int[] arr1 = {4, 9, 3};
        int target1 = 10;
        System.out.println(sol.findBestValue(arr1, target1)); // 3

        int[] arr2 = {2, 3, 5};
        int target2 = 10;
        System.out.println(sol.findBestValue(arr2, target2)); // 5

        int[] arr3 = {60864, 25176, 27249, 21296, 20204};
        int target3 = 56803;
        System.out.println(sol.findBestValue(arr3, target3)); // 11361
    }
}
