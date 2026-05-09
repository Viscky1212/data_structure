package akhil_dsa.basic_pattern;

import javax.swing.*;
import java.util.Arrays;

public class SortArray {

//    public String sortArray(int[] arr, int target) {
//        Arrays.sort(arr); // two-pointer requires a sorted array
//        int i = 0;
//        int j = arr.length - 1;
//
//        while (i < j) {
//            int sum = arr[i] + arr[j]; // recalculate sum each iteration
//            if (sum == target) {
//                return arr[i] + " + " + arr[j] + " = " + target;
//            } else if (sum < target) {
//                i++;
//            } else {
//                j--;
//            }
//        }
//        return "No pair found";
//    }

//    public int[] twoSum(int[] arr, int target) {
//        int i = 0;
//        int j = arr.length - 1;
//
//        while(i < j){
//            Arrays.sort(arr);
//            int sum = arr[i] + arr[j]; // ✅ recalculate on every iteration
//            if(sum == target){
//                return new int[]{i + 1, j + 1};
//            } else if(sum < target){
//                i++;
//            } else{
//                j--;
//            }
//        }
//        return new int[] {-1 , -1};  //no pair found
//    }

//    public int[] threeSum(int[] arr , int target){
//
//        Arrays.sort(arr);
//        for (int i = 0; i < arr.length - 2; i++) {
//            int left = i + 1;
//            int right = arr.length - 1;
//            while (left < right){
//                int sum = arr[i] + arr[left] + arr[right];
//
//                if (sum == target){
//                    return new int[]{i + 1, left + 1, right + 1};
//                } else if (sum < target){
//                    left++;
//                } else {
//                    right--;
//                }
//            }
//        }
//        return new int[]{-1, -1};
//    }

    public int countPairs(int[] arr, int taregt){
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {

                if (arr[i] + arr[j] == taregt){
                  //  System.out.println(arr[i]);
                  //  System.out.println(arr[j]);
                    count++;
                    System.out.println("(" + arr[i] + " , " + arr[j] + ")");
                }
            }
        }
        return count;

    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 4, 5, 1, 6};
        int target = 5;

        SortArray obj = new SortArray();
      //  System.out.println(obj.sortArray(arr, target));
      //  System.out.println(Arrays.toString(obj.twoSum(arr, target)));

        System.out.println(obj.countPairs(arr,target));
      //  System.out.println(Arrays.toString(obj.threeSum(arr,target)));
    }
}