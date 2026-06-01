package two_pointer_problem.may29;

import java.util.Arrays;

public class AdvantageCount {

        public static void main(String[] args) {
            AdvantageCount sol = new AdvantageCount();
            int[] A1 = {2, 7, 11, 15};
            int[] B1 = {1, 10, 4, 11};
            int[] result1 = sol.advantageCount(A1, B1);
            for (int num : result1) {
                System.out.print(num + " ");
            }
            System.out.println();

            int[] A2 = {12, 24, 8, 32};
            int[] B2 = {13, 25, 32, 11};
            int[] result2 = sol.advantageCount(A2, B2);
            for (int num : result2) {
                System.out.print(num + " ");
            }
        }

        public int[] advantageCount(int[] nums1, int[] nums2) {
            int n = nums1.length;
            Arrays.sort(nums1);

            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                arr[i][0] = nums2[i];
                arr[i][1] = i;
            }
            Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

            int[] result = new int[n];
            int left = 0, right = n - 1;
            for (int i = n - 1; i >= 0; i--) {
                int value = arr[i][0];
                int originalIndex = arr[i][1];

               if (nums1[right] > value) {
                    result[originalIndex] = nums1[right];
                    right--;
                } else {
                    result[originalIndex] = nums1[left];
                    left++;
                }
            }
            return result;
        }

}
