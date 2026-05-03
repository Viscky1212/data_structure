package binarySearch.april28;

import java.util.Arrays;

public class MaxProfit {

    public int maxProfit(int[] inventory, int orders){
        Arrays.sort(inventory);

        long MOD = 1_000_000_007;
        long profit = 0;

        int n = inventory.length;
        int i = n - 1;

        while (orders > 0){
            int current = inventory[i];
            int count = n - i; //number with colors with same max
            int next = (i > 0) ? inventory[i - 1] : 0;

            long totalBalls = (long) count * (current - next);

            if (orders >= totalBalls){
                //take all levels
                profit += count * sum(current,next);
                orders -= totalBalls;
            } else {
                //partial fill
                int fullRows = orders /count;
                int reminder = orders % count;

                int low = current - fullRows;

                profit += count * sum(current,low);
                profit += (long) reminder *(low);

                orders = 0;
            }
            profit %= MOD;
            i--;
        }
        return (int) profit;
    }
    // sum from high to low+1
    private long sum(long high, long low){
        return (high + low + 1) * (high - low) / 2;
    }

    public static void main(String[] args) {

        MaxProfit sol = new MaxProfit();

        int[] inv1 = {2,5};
        System.out.println(sol.maxProfit(inv1, 4)); // 14

        int[] inv2 = {3,5};
        System.out.println(sol.maxProfit(inv2, 6)); // 19
    }
}
