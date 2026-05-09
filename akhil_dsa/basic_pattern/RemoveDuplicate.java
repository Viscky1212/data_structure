package akhil_dsa.basic_pattern;

import java.util.Arrays;


public class RemoveDuplicate {


//    static int[] deleteDuplicates(int[] arr) {
//
//        Arrays.sort(arr);
//        int officer = 0;
//
//        for (int cm = 1; cm < arr.length; cm++) {  // ✅ iterate all elements
//            if (arr[cm] != arr[cm - 1]) {
//                officer++;
//                arr[officer] = arr[cm];
//            }
//        }
//
//        return Arrays.copyOfRange(arr, 0, officer + 1); // ✅ return unique elements
//    }




    public static int[] deleteDuplicates(int[] arr){
        Arrays.sort(arr);
        int n = arr.length;
        int i = 0;  // value of i we have fix here becouse we are starting from arr of i = 0

        for (int j = 1; j < arr.length; j++) {
            if (arr[j] != arr[i]){
                i++;
                arr[i] = arr[j];
            }
        }
        return Arrays.copyOfRange(arr,0,i + 1);
    }

//    public static int deleteDuplicates(int[] arr){
//        Arrays.sort(arr);
//        int n = arr.length;
//
//        if (n == 0) return 0;
//
//        int i = 0;
//
//        for (int j = 1; j < arr.length; j++) {
//            if (arr[j] != arr[i]){
//                i++;
//                arr[i] = arr[j];
//            }
//        }
//        return i + 1;
//    }

        public static void main(String[] args) {

        int[] arr = {1,2,3,4,1,2,3,4};



//        int length = deleteDuplicates(arr);
//        for (int i = 0; i < length; i++) {
//            System.out.print(arr[i] + " " );
//        }

         //   System.out.println(deleteDuplicates(arr));


        System.out.println(Arrays.toString(deleteDuplicates(arr))); // ✅ print values
    }

}
