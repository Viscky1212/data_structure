package patternBase.binarySearch;

public class ReverseLinkedList {

    // Linked List Node
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    // =========================================================
    // 1. ITERATIVE APPROACH
    // =========================================================

    public static ListNode reverseIterative(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {

            // Save next node
            ListNode next = curr.next;

            // Reverse current node's pointer
            curr.next = prev;

            // Move prev forward
            prev = curr;

            // Move curr forward
            curr = next;
        }

        return prev;
    }


    // =========================================================
    // 2. RECURSIVE APPROACH
    // =========================================================

    public static ListNode reverseRecursive(ListNode head) {

        // Base case
        if (head == null || head.next == null) {
            return head;
        }

        // Reverse remaining linked list
        ListNode newHead = reverseRecursive(head.next);

        // Put current node after its next node
        head.next.next = head;

        // Break old connection
        head.next = null;

        return newHead;
    }


    // =========================================================
    // PRINT LINKED LIST
    // =========================================================

    public static void printList(ListNode head) {

        while (head != null) {
            System.out.print(head.val);

            if (head.next != null) {
                System.out.print(" -> ");
            }

            head = head.next;
        }

        System.out.println();
    }


    // =========================================================
    // CREATE LINKED LIST
    // =========================================================

    public static ListNode createList(int[] arr) {

        if (arr.length == 0) {
            return null;
        }

        ListNode head = new ListNode(arr[0]);
        ListNode current = head;

        for (int i = 1; i < arr.length; i++) {

            current.next = new ListNode(arr[i]);
            current = current.next;
        }

        return head;
    }


    // =========================================================
    // MAIN METHOD
    // =========================================================

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};

        // -------------------------------
        // Iterative
        // -------------------------------

        ListNode head1 = createList(arr);

        System.out.println("Original List:");
        printList(head1);

        ListNode reversedIterative = reverseIterative(head1);

        System.out.println("Iterative Reverse:");
        printList(reversedIterative);


        // -------------------------------
        // Recursive
        // -------------------------------

        ListNode head2 = createList(arr);

        System.out.println("\nOriginal List:");
        printList(head2);

        ListNode reversedRecursive = reverseRecursive(head2);

        System.out.println("Recursive Reverse:");
        printList(reversedRecursive);
    }
}