package slidingwindow.april07;

public class MaxPointsFromCards {


    //Optimal sliding window solution
    public static int maxScore(int[] cardPoints, int k){
        int n = cardPoints.length;

        //edge case : take all card
        if (k == n){
            int total = 0;
            for (int num : cardPoints) total += num;
            return total;
        }

        int totalSUm = 0;
        for (int num : cardPoints){
            totalSUm += num;
        }

        int windowSize = n - k;
        int windowSum = 0;

        //first Window
        for (int i = 0; i < windowSize; i++) {
            windowSum += cardPoints[i];
        }
        int minSum = windowSum;

        //sliding Window
        for (int i = windowSize; i < n; i++) {
            windowSum += cardPoints[i];
            windowSum -= cardPoints[i - windowSize];
            minSum = Math.min(minSum, windowSum);
        }
        return totalSUm - minSum;

    }




    //bruteforce for understanding
    public static  int bruteForce(int[] cardPoints, int k){
        int n = cardPoints.length;
        int max = 0;

        for (int left = 0; left <= k; left++) {
            int sum = 0;

            //pick left card
            for (int i = 0; i < left; i++) {
                sum += cardPoints[i];
            }

            //pich right card
            for (int i = 0; i < k - left; i++) {
                sum += cardPoints[n - 1 - i];
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5,6,1};
        int k1 = 3;

        System.out.println("Optimal Result: " + maxScore(arr1, k1));
        System.out.println("Brute Force Result: " + bruteForce(arr1, k1));

        int[] arr2 = {2,2,2};
        System.out.println("Test Case 2: " + maxScore(arr2, 2));

        int[] arr3 = {9,7,7,9,7,7,9};
        System.out.println("Test Case 3: " + maxScore(arr3, 7));
    }
}
