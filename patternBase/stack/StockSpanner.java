package patternBase.stack;

import java.util.Stack;

public class StockSpanner {

//    public static int[] calculateSpans(int[] prices) {
//        int n = prices.length;
//        int[] spans = new int[n];
//        java.util.Stack<Integer> stack = new java.util.Stack<>();
//
//        for (int i = 0; i < n; i++) {
//            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
//                stack.pop();
//            }
//            spans[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek());
//            stack.push(i);
//        }
//
//        return spans;
//    }


    private Stack<int[]> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }

    public  int calculateSpans(int price) {
        int span = 1;

        while(!stack.isEmpty() && stack.peek()[0] <= price){
            span += stack.pop()[1];
        }

        stack.push(new int[]{price,span});

        return span;
    }
    public static void main(String[] args) {

        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        StockSpanner stockSpanner = new StockSpanner();
        int[] spans = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            spans[i] = stockSpanner.calculateSpans(prices[i]);
        }

        for (int span : spans) {
            System.out.print(span + " ");
        }
    }
}
