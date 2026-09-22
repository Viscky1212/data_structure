package patternBase.heap;

public class FindRelativeRanks {

    public static String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] result = new String[n];
        int[] sortedScores = score.clone();
        java.util.Arrays.sort(sortedScores);

        for (int i = 0; i < n; i++) {
            int rank = java.util.Arrays.binarySearch(sortedScores, score[i]);
            if (rank == n - 1) {
                result[i] = "Gold Medal";
            } else if (rank == n - 2) {
                result[i] = "Silver Medal";
            } else if (rank == n - 3) {
                result[i] = "Bronze Medal";
            } else {
                result[i] = String.valueOf(n - rank);
            }
        }

        return result;
    }


    public static void main(String[] args) {
        int[] scores = {10, 3, 8, 9, 4};
        String[] ranks = findRelativeRanks(scores);

        for (String rank : ranks) {
            System.out.println(rank);
        }
    }
}
