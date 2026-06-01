package design.may27;

class MinStack {

    // Head of linked list stack
    private Node head;

    /**
     * Node class
     * value -> actual stack value
     * min   -> minimum value till this node
     * next  -> next node reference
     */
    private static class Node {

        int value;
        int min;
        Node next;

        Node(int value, int min) {
            this.value = value;
            this.min = min;
        }
    }

    // Constructor
    public MinStack() {
        head = null;
    }

    /**
     * Push element into stack
     * Time Complexity: O(1)
     */
    public void push(int x) {

        // First element
        if (head == null) {
            head = new Node(x, x);
        } else {

            // Store old head
            Node oldHead = head;

            // Create new node
            head = new Node(x, Math.min(x, oldHead.min));

            // Link new node to previous node
            head.next = oldHead;
        }
    }

    /**
     * Remove top element
     * Time Complexity: O(1)
     */
    public void pop() {

        if (head != null) {
            head = head.next;
        }
    }

    /**
     * Get top element
     * Time Complexity: O(1)
     */
    public int top() {

        return head != null ? head.value : -1;
    }

    /**
     * Get minimum element
     * Time Complexity: O(1)
     */
    public int getMin() {

        return head != null ? head.min : -1;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // Returns -3
        minStack.pop();
        System.out.println(minStack.top());    // Returns 0
        System.out.println(minStack.getMin()); // Returns -2
    }

}
