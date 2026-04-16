package slidingwindow.april07;

public class NumberOfSubarraysWithAvgThreshold {

    //Optimal sliding window
    public static int numOfSubarrays(int[] arr, int k , int threshold){
        int target = k * threshold; // transeformed condition
        int sum = 0;
        int count = 0;

        //first window
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        if (sum >= target) count++;

        //slide window
        for (int i = k; i < arr.length; i++) {
            sum += arr[i]; //add next
            sum -= arr[ i - k]; // remove previous

            if(sum >= target){
                count++;
            }
        }
        return count;
    }


    //Brute force (for understanding )
    public static int bruteForce(int[] arr, int k , int threshold){
        int count = 0;

        for (int i = 0; i < arr.length - k; i++) {
            int sum  = 0;
            for (int j = i; j < i + k; j++) {
                sum += arr[j];
            }
            if (sum >= k * threshold)count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr1 = {2,2,2,2,5,5,5,8};
        int k1 = 3, threshold1 = 4;

        System.out.println("Optimal Result: " + numOfSubarrays(arr1, k1, threshold1));
        System.out.println("Brute Force Result: " + bruteForce(arr1, k1, threshold1));

        int[] arr2 = {11,13,17,23,29,31,7,5,2,3};
        int k2 = 3, threshold2 = 5;

        System.out.println("Test Case 2: " + numOfSubarrays(arr2, k2, threshold2));
    }
}
