package two_pointer_problem;

import java.util.HashSet;
import java.util.Set;

public class CheckDoubleApp {

    public static void main(String[] args) {

        CheckDoubleApp solution = new CheckDoubleApp();

        int[] arr1 = {10, 2, 5, 3};
        int[] arr2 = {3, 1, 7, 11};

        System.out.println("Result 1: " + solution.checkIfExist(arr1));
        System.out.println("Result 2: " + solution.checkIfExist(arr2));
    }

    private boolean checkIfExist(int[] arr1) {
    Set<Integer> set = new HashSet<>();

    for (int num : arr1){
        //check if double exists
        if (set.contains(2 * num)){
            return true;
        }
        //check if half exists (only if even)
        if (num % 2 == 0 && set.contains(num / 2)){
            return  true;
        }

        //add current number
        set.add(num);
    }
    return false;
    }
}
