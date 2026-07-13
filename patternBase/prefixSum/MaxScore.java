package patternBase.prefixSum;

public class MaxScore {
//    public int maxScore(int[] cardPoints, int k) {
//        int n = cardPoints.length;
//        int totalSum = 0;
//
//        // Calculate the total sum of the array
//        for (int point : cardPoints) {
//            totalSum += point;
//        }
//
//        // If k is equal to the length of the array, return the total sum
//        if (k == n) {
//            return totalSum;
//        }
//
//        // Find the minimum sum of a subarray of length n - k
//        int windowSize = n - k;
//        int currentWindowSum = 0;
//
//        // Calculate the sum of the first window
//        for (int i = 0; i < windowSize; i++) {
//            currentWindowSum += cardPoints[i];
//        }
//
//        int minWindowSum = currentWindowSum;
//
//        // Slide the window across the array
//        for (int i = windowSize; i < n; i++) {
//            currentWindowSum += cardPoints[i] - cardPoints[i - windowSize];
//            minWindowSum = Math.min(minWindowSum, currentWindowSum);
//        }
//
//        // The maximum score is the total sum minus the minimum window sum
//        return totalSum - minWindowSum;
//    }

    public int maxScore(String s) {
        // count total number of 1s in whole string
        int ones = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '1') {
                ones++;
            }
        }

        int zerosLeft = 0;
        int maxScore = 0;

        // split point goes from 0 to length - 2
        // because both left and right parts must be non-empty
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                // this 0 moves into left substring
                zerosLeft++;
            } else {
                // this 1 is no longer in right substring
                ones--;
            }

            // score = zeros in left + ones in right
            maxScore = Math.max(maxScore, zerosLeft + ones);
        }

        return maxScore;
    }

    public static void main(String[] args) {
        MaxScore maxScoreCalculator = new MaxScore();
        String s = "011101";
        System.out.println("Maximum score: " + maxScoreCalculator.maxScore(s)); // Output: 5
    }
}
