package patternBase.binarySearch;

import java.util.*;

public class CountSmaller {


        static int[] nums;
        static int[] count;
        static int[] temp;

        public static List<Integer> countSmaller(int[] input) {

            nums = input;

            int n = nums.length;

            count = new int[n];
            temp = new int[n];

            // Store indexes instead of values
            int[] indexes = new int[n];

            for (int i = 0; i < n; i++) {
                indexes[i] = i;
            }

            mergeSort(indexes, 0, n - 1);

            List<Integer> result = new ArrayList<>();

            for (int c : count) {
                result.add(c);
            }

            return result;
        }

        private static void mergeSort(int[] indexes, int left, int right) {

            if (left >= right) {
                return;
            }

            int mid = left + (right - left) / 2;

            mergeSort(indexes, left, mid);
            mergeSort(indexes, mid + 1, right);

            merge(indexes, left, mid, right);
        }

        private static void merge(
                int[] indexes,
                int left,
                int mid,
                int right) {

            int i = left;
            int j = mid + 1;
            int k = left;

            // Number of elements from right half
            // that are smaller than current left element
            int rightSmaller = 0;

            while (i <= mid && j <= right) {

                if (nums[indexes[j]] < nums[indexes[i]]) {

                    // Right element is smaller
                    temp[k++] = indexes[j++];

                    rightSmaller++;

                } else {

                    // All previously moved right elements
                    // are smaller than nums[indexes[i]]
                    count[indexes[i]] += rightSmaller;

                    temp[k++] = indexes[i++];
                }
            }

            // Remaining left elements
            while (i <= mid) {

                count[indexes[i]] += rightSmaller;

                temp[k++] = indexes[i++];
            }

            // Remaining right elements
            while (j <= right) {
                temp[k++] = indexes[j++];
            }

            // Copy sorted indexes back
            for (int p = left; p <= right; p++) {
                indexes[p] = temp[p];
            }
        }

        public static void main(String[] args) {

            int[] nums = {5, 2, 6, 1};

            List<Integer> result = countSmaller(nums);

            System.out.println(result);
        }
    }