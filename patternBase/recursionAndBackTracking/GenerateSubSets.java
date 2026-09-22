package patternBase.recursionAndBackTracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateSubSets {

    public static void generateSubsets(int[] arr, int n, int index, List<Integer> temp) {
        if (index == n) {
           System.out.println(temp);
            return;
        }

        // Include the current element
        temp.add(arr[index]);
        generateSubsets(arr, n, index + 1, temp);



        // Exclude the current element
        temp.remove(temp.size() - 1);
        generateSubsets(arr, n, index + 1, temp);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};

        List<Integer> temp = new ArrayList<>();
        generateSubsets(arr,arr.length,0,temp);
    }
}
