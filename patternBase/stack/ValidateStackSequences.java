package patternBase.stack;

import java.util.Stack;

public class ValidateStackSequences {

//    public static boolean validateStackSequences(int[] pushed, int[] popped) {
//        int j = 0;
//        int n = pushed.length;
//
//        for (int x : pushed) {
//            pushed[j++] = x; // Push the element onto the stack
//            while (j > 0 && pushed[j - 1] == popped[0]) {
//                j--; // Pop the element from the stack
//                popped = java.util.Arrays.copyOfRange(popped, 1, popped.length); // Move to the next element in popped
//            }
//        }
//
//        return j == 0; // If the stack is empty, the sequences are valid
//    }


    public static boolean validateStackSequences(int[] pushed, int[] popped) {

        Stack<Integer> stack = new Stack();

        int j = 0;

        for (int num : pushed) {

            stack.push(num);

            while (!stack.isEmpty()
                    && stack.peek() == popped[j]) {

                stack.pop();
                j++;
            }
        }

        return stack.isEmpty();
    }
    public static void main(String[] args) {

        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 5, 3, 2, 1};

        System.out.println(validateStackSequences(pushed, popped)); // Output: true
    }
}
