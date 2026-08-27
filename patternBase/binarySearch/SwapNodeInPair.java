package patternBase.binarySearch;

import two_pointer_problem.aprill01.ListNode;

public class SwapNodeInPair {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            this.val = x;
        }

        ListNode(int x, ListNode next) {
            this.val = x;
            this.next = next;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = head.next; // The new head will be the second node
        ListNode prev = null; // To keep track of the previous node for linking

        while (head != null && head.next != null) {
            ListNode first = head;
            ListNode second = head.next;

            // Swapping
            first.next = second.next;
            second.next = first;

            // Linking the previous pair to the current swapped pair
            if (prev != null) {
                prev.next = second;
            }

            // Move prev to the end of the swapped pair
            prev = first;

            // Move head to the next pair
            head = first.next;
        }

        return newHead;
    }

    public static ListNode createLinkedList(int[] arr) {
        if (arr.length == 0) return null;

        ListNode head = new ListNode(arr[0]);
        System.out.println("Head created with value: " + head.val);
        ListNode current = head;
        System.out.println("Current node initialized with value: " + current.val);

        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
            System.out.println("Node created with value: " + current.val);
        }

        return head;
    }

    public static void printList(ListNode head) {

        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");

            if (curr.next != null) {
                System.out.print("-> ");
            }
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
       int[] arr = {1, 2, 3, 4};
       ListNode head = createLinkedList(arr);
       System.out.println("Original List:");
       printList(head);
       ListNode swappedHead = swapPairs(head);
       System.out.println("List after swapping pairs:");
       printList(swappedHead);

    }
}
