package two_pointer_problem;

import java.util.Arrays;

public class MaxProfitAssignment {

    public static int maxProfitAssignment(int[] difficulty,int[] profit, int[] worker){
        int n = difficulty.length;

        int[][] jobs = new int[n][2];

        for (int i = 0; i < n; i++) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];

        }

        Arrays.sort(jobs,(a,b) -> a[0] - b[0]);
        Arrays.sort(worker);

        int totalProfit = 0;
        int bestProfit = 0;
        int i  = 0;

        for (int ability : worker){
            while (i < n && jobs[i][0] <= ability){
                bestProfit = Math.max(bestProfit,jobs[i][1]);
                i++;
            }
            totalProfit += bestProfit;
        }
        return totalProfit;
    }
    public static void main(String[] args) {
        int[] difficulty = {2,4,6,8,10};
        int[] profit = {10,20,30,40,50};
        int[] worker = {4,5,6,7};

        int result = maxProfitAssignment(difficulty,profit,worker);
        System.out.println("Maximum Profit : " + result);

    }
}
