package patternBase.stack;

import java.util.Stack;

public class RemoveDuplicateLetters {

//    public static String removeDuplicateLetters(String s) {
//        int[] count = new int[26];
//        boolean[] visited = new boolean[26];
//        StringBuilder result = new StringBuilder();
//
//        for (char c : s.toCharArray()) {
//            count[c - 'a']++;
//        }
//
//        for (char c : s.toCharArray()) {
//            count[c - 'a']--;
//
//            if (visited[c - 'a']) {
//                continue;
//            }
//
//            while (result.length() > 0 && c < result.charAt(result.length() - 1) && count[result.charAt(result.length() - 1) - 'a'] > 0) {
//                visited[result.charAt(result.length() - 1) - 'a'] = false;
//                result.deleteCharAt(result.length() - 1);
//            }
//
//            result.append(c);
//            visited[c - 'a'] = true;
//        }
//
//        return result.toString();
//    }

    public static String removeDuplicateLetters(String s) {
        int[] lastIndex = new int[26];
        boolean[] visited = new boolean[26];
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
            System.out.println("Last index of " + s.charAt(i) + ": " + lastIndex[s.charAt(i) - 'a']);

        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (visited[c - 'a']) {
                System.out.println("Character " + c + " already visited, skipping.");
                continue;
            }

            while (!stack.isEmpty()
                    && c < stack.peek()
                    && lastIndex[stack.peek() - 'a'] > i) {
                char removed = stack.pop();
                System.out.println("Removing character " + removed);
                visited[removed - 'a'] = false;
            }

            stack.push(c);
            visited[c - 'a'] = true;
        }

        for (char c : stack) {
            System.out.println("Adding character " + c + " to result.");
            result.append(c);
            System.out.println("Current result: " + result.toString());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "cbacdcbc";
        String result = removeDuplicateLetters(s);
        System.out.println(result); // Output: "acdb"
    }
}
