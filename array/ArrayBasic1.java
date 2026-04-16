package array;

import java.util.Arrays;

public class ArrayBasic1 {
    public static void main(String[] args) {
        int arr[] = {11, 2, 3, 41, 5};

        int min = arr[0];
        int max = arr[0];

        Arrays.sort(arr);
        System.out.println("Min Number ::  " + arr[0]);
        System.out.println(" Max Number :: " + arr[arr.length - 1]);

        for (int i = 0; i < arr.length; i++) {
         if (arr[i] > max){
             max = arr[i];
         }
         if (arr[i] < min){
             min = arr[i];
         }
        }
        System.out.println("Min Element :: " + min);
        System.out.println(" Max Element :: " + max);
    }
}