package linkedList;

import java.util.ArrayDeque;
import java.util.Deque;

// LeetCode 2296 - Design a Text Editor
// Strategy: two stacks split at cursor position
//   left  = chars to the LEFT  of cursor (top = nearest to cursor)
//   right = chars to the RIGHT of cursor (top = nearest to cursor)
// Every operation is O(k).
public class TextEditor {

    private final Deque<Character> left;   // top is the char just left of cursor
    private final Deque<Character> right;  // top is the char just right of cursor

    public TextEditor() {
        left  = new ArrayDeque<>();
        right = new ArrayDeque<>();
    }

    // Push every char onto the left stack; cursor ends up to the right of text.
    public void addText(String text) {
        for (char c : text.toCharArray()) {
            left.push(c);
        }
    }

    // Pop up to k chars from the left stack (simulates backspace).
    public int deleteText(int k) {
        int deleted = 0;
        while (deleted < k && !left.isEmpty()) {
            left.pop();
            deleted++;
        }
        return deleted;
    }

    // Move cursor left: shift chars from left stack to right stack.
    public String cursorLeft(int k) {
        int moves = 0;
        while (moves < k && !left.isEmpty()) {
            right.push(left.pop());
            moves++;
        }
        return lastTen();
    }

    // Move cursor right: shift chars from right stack to left stack.
    public String cursorRight(int k) {
        int moves = 0;
        while (moves < k && !right.isEmpty()) {
            left.push(right.pop());
            moves++;
        }
        return lastTen();
    }

    // Return the last min(10, left.size()) characters to the left of the cursor.
    private String lastTen() {
        int len = Math.min(10, left.size());
        char[] buf = new char[len];
        // The left stack has the nearest char at the top, so fill right-to-left.
        for (int i = len - 1; i >= 0; i--) {
            buf[i] = left.pop();
        }
        // Restore the popped chars.
        for (char c : buf) {
            left.push(c);
        }
        return new String(buf);
    }

    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        editor.addText("leetcode");
        System.out.println("addText(\"leetcode\")  -> text: leetcode|");

        System.out.println("deleteText(4)        -> " + editor.deleteText(4));   // 4,  text: leet|

        editor.addText("practice");
        System.out.println("addText(\"practice\")  -> text: leetpractice|");

        System.out.println("cursorRight(3)       -> " + editor.cursorRight(3)); // "etpractice"
        System.out.println("cursorLeft(8)        -> " + editor.cursorLeft(8));  // "leet"
        System.out.println("deleteText(10)       -> " + editor.deleteText(10)); // 4
        System.out.println("cursorLeft(2)        -> " + editor.cursorLeft(2));  // ""
        System.out.println("cursorRight(6)       -> " + editor.cursorRight(6)); // "practi"
    }
}