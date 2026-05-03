package hashtable.may01;

import java.util.Arrays;

public class RelativeSortArray {

    public int[] relativeSortArray(int[] arr1, int[] arr2){
        int[] freq = new int[1001];

        //step 1: count frequencies
        for (int num : arr1){
            freq[num]++;
        }

        int[] result = new int[arr1.length];
        int index = 0;

        //Step 2 : place elements from arr2
        for (int num : arr2){
            while (freq[num] > 0){
                result[index++] = num;
                freq[num]--;
            }
        }

        //step 3 : remaining element sorted

        for (int i = 0; i <=  1000; i++) {
            while (freq[i] > 0){
                result[index++] = i;
                freq[i]--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        RelativeSortArray sol = new RelativeSortArray();

        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};

        System.out.println(Arrays.toString(
                sol.relativeSortArray(arr1, arr2)
        ));
        // [2,2,2,1,4,3,3,9,6,7,19]
    }
}
