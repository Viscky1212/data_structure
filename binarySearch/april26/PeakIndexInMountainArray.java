package binarySearch.april26;

public class PeakIndexInMountainArray {

    public int peakIndexInMountainArray(int[] arr){
        int left = 0;
        int right = arr.length - 1;

        while (left < right){
            int mid = left +(right - left) / 2;
            if (arr[mid] < arr[mid + 1]){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        PeakIndexInMountainArray sol = new PeakIndexInMountainArray();
        int[] arr1 = {0, 1, 0};
        System.out.println(sol.peakIndexInMountainArray(arr1)); // 1

        int[] arr2 = {0, 2, 1, 0};
        System.out.println(sol.peakIndexInMountainArray(arr2)); // 1

        int[] arr3 = {0, 10, 5, 2};
        System.out.println(sol.peakIndexInMountainArray(arr3)); // 1
    }
}
