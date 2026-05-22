package sorting.may20;

public class BuyChoco {

    public int buyChoco(int[] prices, int money){
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;

        for (int price : prices){
            if (price < firstMin){
              secondMin = firstMin;
              firstMin = price;
            } else if (price < secondMin){
                secondMin = price;
            }
        }

        int cost = firstMin + secondMin;
        return cost <= money ? money -cost : money;
    }

    public static void main(String[] args) {
        BuyChoco sol = new BuyChoco();
        int[] prices1 = {1, 2, 2};
        int money1 = 3;
        System.out.println(sol.buyChoco(prices1, money1));
        // Output: 0

        int[] prices2 = {3, 2, 3};
        int money2 = 3;
        System.out.println(sol.buyChoco(prices2, money2));
        // Output: 3
    }
}
