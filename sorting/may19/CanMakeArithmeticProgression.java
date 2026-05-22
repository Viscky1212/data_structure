package sorting.may19;

import java.util.Arrays;

public class CanMakeArithmeticProgression {

    public boolean canMakeArithmeticProgression(int[] arr){
        Arrays.sort(arr);

        int diff = arr[1] - arr[0];

        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != diff){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CanMakeArithmeticProgression sol = new CanMakeArithmeticProgression();
        int[] arr1 = {3, 5, 1};
        System.out.println(sol.canMakeArithmeticProgression(arr1));
        // Output: true

        int[] arr2 = {1, 2, 4};
        System.out.println(sol.canMakeArithmeticProgression(arr2));
        // Output: false

        int[] arr3 = {7, 7, 7, 7};
        System.out.println(sol.canMakeArithmeticProgression(arr3));
        // Output: true
    }
}
