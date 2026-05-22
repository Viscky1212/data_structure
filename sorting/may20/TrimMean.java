package sorting.may20;

import java.util.Arrays;

// sol : 1
public class TrimMean {

    public double trimMean(int[] arr){
        Arrays.sort(arr);

        int n = arr.length;
        int removeCount = n/20;

        int sum = 0;
        for (int i = removeCount; i < n - removeCount; i++) {
            sum += arr[i];
        }

        int remainCount = n - 2 * removeCount;

        return (double) sum / remainCount;
    }

    public static void main(String[] args) {
        TrimMean sol = new TrimMean();
        int[] arr1 = {
                1,2,2,2,2,2,2,2,2,2,
                2,2,2,2,2,2,2,2,2,3
        };

        System.out.println(sol.trimMean(arr1));
        // Output: 2.0

        int[] arr2 = {
                6,2,7,5,1,2,0,3,10,2,
                5,0,5,5,0,8,7,6,8,0
        };

        System.out.println(sol.trimMean(arr2));
        // Output: 4.0
    }
}
