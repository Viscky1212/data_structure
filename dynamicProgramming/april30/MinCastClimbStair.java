package dynamicProgramming.april30;

public class MinCastClimbStair {

    public int minCostClimbingStairs(int[] cost){
        int n = cost.length;

        int prev2 = cost[0];
        int prev1= cost[1];

        for (int i = 2; i < n; i++) {
            int curr = cost[i] + Math.min(prev1,prev2);

            prev2 = prev1;
            prev1 = curr;
        }
        return Math.min(prev1,prev2);
    }


    public static void main(String[] args) {

        MinCastClimbStair sol = new MinCastClimbStair();

        int[] cost1 = {10,15,20};
        System.out.println(sol.minCostClimbingStairs(cost1)); // 15

        int[] cost2 = {1,100,1,1,1,100,1,1,100,1};
        System.out.println(sol.minCostClimbingStairs(cost2)); // 6
    }
}
