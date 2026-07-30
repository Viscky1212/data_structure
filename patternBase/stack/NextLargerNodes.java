package patternBase.stack;

import java.util.*;


public class NextLargerNodes {

//    public static int[] nextLargerNodes(int[] arr) {
//        int n = arr.length;
//        int[] result = new int[n];
//        Stack<Integer> stack = new Stack<>();
//
//        for (int i = 0; i < n; i++) {
//            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
//                result[stack.pop()] = arr[i];
//            }
//            stack.push(i);
//        }
//
//        return result;
//    }

    public static int[] nextLargerNodes(int[] head) {

        // Linked List को Array में बदलेंगे
        List<Integer> list = new ArrayList<>();

        for (int val : head) {
            list.add(val);
        }

        int n = list.size();
        int[] ans = new int[n];

        Stack<Integer> stack = new Stack<>();

        // Right से Left चलेंगे
        for (int i = n - 1; i >= 0; i--) {

            // छोटे या बराबर elements हटा दो
            while (!stack.isEmpty()
                    && stack.peek() <= list.get(i)) {

                stack.pop();
            }

            // अगर कोई बड़ा नहीं मिला
            if (stack.isEmpty()) {
                ans[i] = 0;
            } else {
                ans[i] = stack.peek();
            }

            // Current value push करो
            stack.push(list.get(i));
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5};
        int[] result = nextLargerNodes(arr);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}