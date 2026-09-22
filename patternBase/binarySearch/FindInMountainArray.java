package patternBase.binarySearch;

public class FindInMountainArray {

    /**
     * // This is the MountainArray's API.
     * // You should not implement it, or speculate about its implementation.
     * interface MountainArray {
     *     public int get(int index);
     *     public int length();
     * }
     */

        // MountainArray interface
        interface MountainArray {
            int get(int index);
            int length();
        }

        // Implementation for local testing
        static class MyMountainArray implements MountainArray {

            private int[] arr;

            MyMountainArray(int[] arr) {
                this.arr = arr;
            }

            @Override
            public int get(int index) {
                return arr[index];
            }

            @Override
            public int length() {
                return arr.length;
            }
        }

        // Main solution
        static class Solution {

            public int findInMountainArray(
                    int target,
                    MountainArray mountainArr) {

                int n = mountainArr.length();

                // 1. Find peak
                int peak = findPeak(mountainArr, n);

                // 2. Search increasing part first
                int result = binarySearchIncreasing(
                        mountainArr,
                        target,
                        0,
                        peak
                );

                // If found on left side,
                // it is the minimum index
                if (result != -1) {
                    return result;
                }

                // 3. Search decreasing part
                return binarySearchDecreasing(
                        mountainArr,
                        target,
                        peak + 1,
                        n - 1
                );
            }

            // Find peak index
            private int findPeak(
                    MountainArray arr,
                    int n) {

                int left = 0;
                int right = n - 1;

                while (left < right) {

                    int mid = left + (right - left) / 2;

                    if (arr.get(mid) < arr.get(mid + 1)) {

                        // Increasing side
                        // Peak is on the right
                        left = mid + 1;

                    } else {

                        // Decreasing side
                        // Peak can be mid
                        right = mid;
                    }
                }

                return left;
            }

            // Binary search on increasing part
            private int binarySearchIncreasing(
                    MountainArray arr,
                    int target,
                    int left,
                    int right) {

                while (left <= right) {

                    int mid = left + (right - left) / 2;

                    int value = arr.get(mid);

                    if (value == target) {
                        return mid;
                    }

                    if (value < target) {

                        // Target is on right
                        left = mid + 1;

                    } else {

                        // Target is on left
                        right = mid - 1;
                    }
                }

                return -1;
            }

            // Binary search on decreasing part
            private int binarySearchDecreasing(
                    MountainArray arr,
                    int target,
                    int left,
                    int right) {

                while (left <= right) {

                    int mid = left + (right - left) / 2;

                    int value = arr.get(mid);

                    if (value == target) {
                        return mid;
                    }

                    if (value < target) {

                        // Array is decreasing,
                        // so target is on left
                        right = mid - 1;

                    } else {

                        // Target is on right
                        left = mid + 1;
                    }
                }

                return -1;
            }
        }

        // Main method
        public static void main(String[] args) {

            int[] arr = {1, 2, 3, 4, 5, 3, 1};

            int target = 3;

            MountainArray mountainArr =
                    new MyMountainArray(arr);

            Solution solution = new Solution();

            int result =
                    solution.findInMountainArray(
                            target,
                            mountainArr
                    );

            System.out.println("Target = " + target);
            System.out.println("Index  = " + result);
        }



//
//    public static int findInMountainArray(int[] arr, int target) {
//        int peak = findPeak(arr);
//
//        // Search in the ascending part
//        int index = binarySearch(arr, target, 0, peak);
//        if (index != -1) {
//            return index;
//        }
//
//        // Search in the descending part
//        return binarySearchDescending(arr, target, peak + 1, arr.length - 1);
//    }
//
//    private static int findPeak(int[] arr) {
//        int left = 0;
//        int right = arr.length - 1;
//
//        while (left < right) {
//            int mid = left + (right - left) / 2;
//            if (arr[mid] < arr[mid + 1]) {
//                left = mid + 1;
//            } else {
//                right = mid;
//            }
//        }
//        return left; // or right, both are the same at this point
//    }
//
//    private static int binarySearch(int[] arr, int target, int left, int right) {
//        while (left <= right) {
//            int mid = left + (right - left) / 2;
//            if (arr[mid] == target) {
//                return mid;
//            } else if (arr[mid] < target) {
//                left = mid + 1;
//            } else {
//                right = mid - 1;
//            }
//        }
//        return -1; // Target not found
//    }
//
//    private static int binarySearchDescending(int[] arr, int target, int left, int right) {
//        while (left <= right) {
//            int mid = left + (right - left) / 2;
//            if (arr[mid] == target) {
//                return mid;
//            } else if (arr[mid] > target) {
//                left = mid + 1;
//            } else {
//                right = mid - 1;
//            }
//        }
//        return -1; // Target not found
//    }
//
//    public static void main(String[] args) {
//        int[] mountainArr = {1, 3, 5, 7, 6, 4, 2};
//        int target = 6;
//        int index = findInMountainArray(mountainArr, target);
//        System.out.println("Target " + target + " found at index: " + index);
//    }
}
