package dynamicProgramming.april30;

public class BestTimeToByStock {
    public int maxProfit(int[] prices){
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices){
            if (price < minPrice){
                minPrice = price;
            } else {
                int profit = price - minPrice;
                maxProfit = Math.max(maxProfit,profit);
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {

        BestTimeToByStock sol = new BestTimeToByStock();

        int[] prices1 = {7,1,5,3,6,4};
        System.out.println(sol.maxProfit(prices1)); // 5

        int[] prices2 = {7,6,4,3,1};
        System.out.println(sol.maxProfit(prices2)); // 0
    }
}
