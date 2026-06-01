package two_pointer_problem.may29;

import java.util.Arrays;

public class KgetStrongest {

    public static void main(String[] args) {
        KgetStrongest sol = new KgetStrongest();
        int[] arr1 = {1, 2, 3, 4, 5};
        int k1 = 2;
        int[] result1 = sol.getStrongest(arr1, k1);
        for (int num : result1) {
            System.out.print(num + " ");
        }
        System.out.println();

        int[] arr2 = {6, 7, 11, 7, 6, 8};
        int k2 = 5;
        int[] result2 = sol.getStrongest(arr2, k2);
        for (int num : result2) {
            System.out.print(num + " ");
        }
    }

    public int[] getStrongest(int[] arr, int k) {
        int n = arr.length;
        Arrays.sort(arr);
        int median = arr[(n - 1) / 2];

        int[] result = new int[k];
        int left = 0, right = n - 1;
        int index = 0;

        while (index < k) {
            int leftDiff = Math.abs(arr[left] - median);
            int rightDiff = Math.abs(arr[right] - median);

            if (rightDiff > leftDiff) {

                result[index++] = arr[right];
                right--;

            } else if (leftDiff > rightDiff) {

                result[index++] = arr[left];
                left++;

            } else {

                // Equal strength
                if (arr[right] > arr[left]) {

                    result[index++] = arr[right];
                    right--;

                } else {

                    result[index++] = arr[left];
                    left++;
                }
            }
        }
        return result;
    }
}
