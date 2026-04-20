package dp.dp2;

public class MaximumSumRectangle {

    int maximumSumRectangle(int R, int C, int M[][]){
        int maxSum = Integer.MIN_VALUE;

        for (int left = 0; left < C; left++) {
            int[] temp = new int[R];

            for (int right = left; right < C; right++) {
                for (int i = 0; i < R; i++) {
                    temp[i] += M[i][right];
                }
                maxSum = Math.max(maxSum,kadane(temp));
            }
        }
        return maxSum;
    }

    private int kadane(int[] arr){
        int mazEndingHere = arr[0];
        int maxSoFar = arr[0];

        for (int i = 1; i < arr.length; i++) {
            mazEndingHere = Math.max(arr[i],mazEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar,mazEndingHere);
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        MaximumSumRectangle sol = new MaximumSumRectangle();
        int[][] M = {
                {1, 2, -1, -4, -20},
                {-8, -3, 4, 2, 1},
                {3, 8, 10, 1, 3},
                {-4, -1, 1, 7, -6}
        };

        int R = M.length;
        int C = M[0].length;

        System.out.println(sol.maximumSumRectangle(R, C, M));
    }
}
