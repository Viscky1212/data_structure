package patternBase.stack.Sep29;

import java.util.*;

public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        // Stack to store indices of the temperatures array
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // While the stack is not empty and the current temperature is greater than the temperature at the index stored at the top of the stack
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                result[index] = i - index; // Calculate the number of days until a warmer temperature
            }
            stack.push(i); // Push the current index onto the stack
        }

        return result;
    }

    public static void main(String[] args) {

        DailyTemperatures dt = new DailyTemperatures();
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = dt.dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(result)); // Output: [1, 1, 4, 2, 1, 1, 0, 0]
    }
}
