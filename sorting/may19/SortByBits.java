package sorting.may19;

import java.util.Arrays;

public class SortByBits {

    public int[] sortByBits(int[] arr){
        Integer[] boxed = new Integer[arr.length];

        for (int i = 0; i < arr.length; i++) {
            boxed[i] = arr[i];
        }

        Arrays.sort(boxed,(a,b) ->{
            int bitCountA = Integer.bitCount(a);
            int bitCountB = Integer.bitCount(b);

            if (bitCountA != bitCountB){
                return bitCountA - bitCountB;
            }
            return a - b;
        });

        for (int i = 0; i < arr.length; i++) {
            arr[i] = boxed[i];
        }
        return arr;
    }

    public static void main(String[] args) {
        SortByBits sol = new SortByBits();

        int[] arr1 = {0,1,2,3,4,5,6,7,8};
        System.out.println(Arrays.toString(sol.sortByBits(arr1)));
        // Output: [0, 1, 2, 4, 8, 3, 5, 6, 7]

        int[] arr2 = {1024,512,256,128,64,32,16,8,4,2,1};
        System.out.println(Arrays.toString(sol.sortByBits(arr2)));
        // Output: [1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024]
    }
}
