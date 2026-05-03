package binarySearch.april28;

import java.util.Map;

public class FindLengthOfShortestSubarray {

    public int findLengthOfShortestSubarray(int[] arr){
        int n = arr.length;

        //Step 1 : Find longest non-decreasing prefix
        int left = 0;
        while (left < n - 1 && arr[left] <= arr[left + 1]){
            left++;
        }

        //Already sorted
        if (left == n - 1){
            return 0;
        }

        //Step 2 : Find longest non-decreasing suffix
        int right = n - 1;
        while (right > 0 && arr[right - 1] <= arr[right]){
            right--;
        }

        //Step 3 remove either prefix or suffix entirely
        int ans = Math.min(n -left - 1, right);

        //Step 4 : try merging prefix and suffix
        int i = 0, j = right;

        while (i <= left && j < n){
            if (arr[i] <= arr[j]){
                //valid merge
                ans = Math.min(ans, j - i - 1);
                i++;
            } else {
                j++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        FindLengthOfShortestSubarray sol = new FindLengthOfShortestSubarray();

        int[] arr1 = {1,2,3,10,4,2,3,5};
        System.out.println(sol.findLengthOfShortestSubarray(arr1)); // 3

        int[] arr2 = {5,4,3,2,1};
        System.out.println(sol.findLengthOfShortestSubarray(arr2)); // 4

        int[] arr3 = {1,2,3};
        System.out.println(sol.findLengthOfShortestSubarray(arr3)); // 0
    }
}
