package patternBase.stack;

import java.util.Stack;

public class MinimumDeletions {
//     public static int minDeletions(String s) {
//        int deletions = 0;
//        int open = 0;
//
//        for (char c : s.toCharArray()) {
//            if (c == '(') {
//                open++;
//            } else {
//                if (open > 0) {
//                    open--;
//                } else {
//                    deletions++;
//                }
//            }
//        }
//
//        deletions += open;
//        return deletions;
//    }
//
//

//    public static int minimumDeletions(String s) {
//
//        int bCount = 0;   // अब तक कितने 'b' आए
//        int delete = 0;   // Minimum deletions
//
//        for (char ch : s.toCharArray()) {
//
//            if (ch == 'b') {
//
//                bCount++;
//
//            } else {
//
//                // Option 1 -> current 'a' delete
//                // Option 2 -> सारे previous 'b' delete
//                delete = Math.min(delete + 1, bCount);
//            }
//        }
//
//        return delete;
//    }

    //usinf stack
    public static int minDeletions(String s) {
        Stack<Character> stack = new Stack<>();
        int deletions = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    deletions++;
                }
            }
        }

        deletions += stack.size();
        return deletions;
    }

    public static void main(String[] args) {
        String s = "aabcb";
        System.out.println(minDeletions(s));
    }
}
