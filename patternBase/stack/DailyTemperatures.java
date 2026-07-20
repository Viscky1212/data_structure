package patternBase.stack;

import java.util.*;

public class DailyTemperatures {


     public static int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;

        int[] answer = new int[n];

        Stack<Integer> stack = new Stack<>();


        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() &&
                    temperatures[i] > temperatures[stack.peek()]) {

                int index = stack.pop();

                answer[index] = i - index;
            }

            stack.push(i);
        }

        return answer;
    }


//    public static int[] dailyTemperatures(int[] temperatures) {
//        int n = temperatures.length;
//        int[] result = new int[n];
//        int[] stack = new int[n];
//        int top = -1;
//
//        for (int i = 0; i < n; i++) {
//            while (top >= 0 && temperatures[i] > temperatures[stack[top]]) {
//                int index = stack[top--];
//                result[index] = i - index;
//            }
//            stack[++top] = i;
//        }
//
//        return result;
//    }


    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = dailyTemperatures(temperatures);

        for (int days : result) {
            System.out.print(days + " ");
        }
    }
}
