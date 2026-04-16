package two_pointer_problem;

import java.util.ArrayList;
import java.util.List;

public class FindClosestElements {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - k;

        while (left < right){
            int mid =  left + (right - left) / 2;

            if (x - arr[mid] > arr[mid + k] - x){
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = left; i < left + k; i++) {
            result.add(arr[i]);
        }
        return result;
    }
        public static void main(String[] args) {
            FindClosestElements sol = new FindClosestElements();

            int[] arr = {1,2,3,4,5};
            int k = 4;
            int x = 3;

            List<Integer> result = sol.findClosestElements(arr, k, x);

            System.out.println("Closest elements: " + result);
        }

}
