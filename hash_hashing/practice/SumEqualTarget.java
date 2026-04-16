package hash_hashing.practice;

import java.util.*;

public class SumEqualTarget {

    public  static  int sumEqualTarget(int[][] matrix, int target){
        int n = matrix.length;
        int m = matrix[0].length;

        int count = 0;

        //fix top row
        for (int top = 0; top <n; top++) {
            int[] colSum = new int[m]; //1D Array

            //Expand bottom
            for (int bottom = top; bottom < n; bottom++) {
                for (int col = 0; col < m; col++) {
                    colSum[col] += matrix[bottom][col];
                }

                //Count subarrays with sum = target
                count += sumArraySum(colSum, target);
            }
        }
        return count;

    }

    public static int sumArraySum(int[] nums, int target){
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);

        int prefixSum = 0;
        int count = 0;
        for (int num : nums){
            prefixSum += num;

            if(map.containsKey((prefixSum - target))){
                count += map.get(prefixSum - target);
            }
            map.put(prefixSum,map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0,1,0},
                {1,1,1},
                {0,1,0}
        };

        int target = 3;

        System.out.println(sumEqualTarget(matrix, target)); // Output: 6
    }
}
