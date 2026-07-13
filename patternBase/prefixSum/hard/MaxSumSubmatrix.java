package patternBase.prefixSum.hard;

import java.util.TreeSet;

public class MaxSumSubmatrix {
    //write TreeSet example
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int answer = Integer.MIN_VALUE;

        //fix left column
        for(int left = 0; left < cols; left++){
            int[] rowSum = new int[rows];

            //Extend right column
            for(int right = left; right < cols; right++){
                for(int r = 0; r < rows; r++){
                    rowSum[r] += matrix[r][right];
                }

                //Find max subarray sum <= k in rowSum

                answer = Math.max(answer, maxSubArrayNoMoreThank(rowSum , k));

                if(answer == k){
                    return k;
                }
            }
        }
        return answer;
    }

    public int maxSubArrayNoMoreThank(int[] nums, int k){

        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);

        int prefixSum = 0;
        int best = Integer.MIN_VALUE;

        for(int num : nums){
            prefixSum += num;

            Integer ceil = set.ceiling(prefixSum - k);

            if(ceil != null){
                best = Math.max(best, prefixSum - ceil);
            }

            set.add(prefixSum);
        }

        return best;
    }


    public static void main(String[] args) {
        MaxSumSubmatrix maxSumSubmatrix = new MaxSumSubmatrix();
        int[][] matrix = {
                {1, 0, 1},
                {0, -2, 3}
        };
        int k = 2;
        int result = maxSumSubmatrix.maxSumSubmatrix(matrix, k);
        System.out.println("Max sum of submatrix no more than k: " + result);
    }
}
