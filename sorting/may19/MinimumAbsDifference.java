package sorting.may19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsDifference {

    public List<List<Integer>> minimumAbsDifference(int[] arr){
        Arrays.sort(arr);

        int minDiff = Integer.MAX_VALUE;

        for (int i = 1; i < arr.length; i++) {
            minDiff = Math.min(minDiff,arr[i] - arr[i - 1]);
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] == minDiff){
                result.add(Arrays.asList(arr[i - 1],arr[i]));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MinimumAbsDifference sol = new MinimumAbsDifference();

        int[] arr1 = {4, 2, 1, 3};
        System.out.println(sol.minimumAbsDifference(arr1));
        // Output: [[1, 2], [2, 3], [3, 4]]

        int[] arr2 = {1, 3, 6, 10, 15};
        System.out.println(sol.minimumAbsDifference(arr2));
        // Output: [[1, 3]]

        int[] arr3 = {3, 8, -10, 23, 19, -4, -14, 27};
        System.out.println(sol.minimumAbsDifference(arr3));
        // Output: [[-14, -10], [19, 23], [23, 27]]
    }
}
