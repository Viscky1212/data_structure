package array;

import java.util.Arrays;

public class ArraySorting {

    public static void main(String[] args) {
        int arr[] = { 12,11,14,6,7,4,9};
//  Printing array in 3 types
//        for (int i = 0; i < arr.length; i++){
//            System.out.println(arr[i]);
//        }
//
//        for (int n : arr){
//            System.out.println(n + " ");
//        }

   //     System.out.println(Arrays.toString(arr));

      //  Arrays.sort(arr);
       // System.out.println(Arrays.toString(arr));
        int temp = 0;
        for (int i = 0; i < arr.length; i++){
            for (int j = i + 1; j < arr.length; j++){
                if (arr[i] > arr[j]){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
          //      System.out.println(Arrays.toString(arr));
            }
        }
        System.out.println(Arrays.toString(arr));

    }
}
