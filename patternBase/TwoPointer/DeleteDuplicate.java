package patternBase.TwoPointer;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class DeleteDuplicate {
    private ListNode deleteDuplicates(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null) {

            //unique node found
            if (slow.val != fast.val) {
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next; // Always move fast pointer
        }

        //cut off remaining duplicates references
        slow.next = null; // Terminate the list//
        return head;
    }



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


    public static void main(String[] args) {
        DeleteDuplicate sol = new DeleteDuplicate();

        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(1);
        head1.next.next = new ListNode(2);
        ListNode result1 = sol.deleteDuplicates(head1);
        printList(result1); // Output: 1 -> 2

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(1);
        head2.next.next = new ListNode(2);
        head2.next.next.next = new ListNode(3);
        head2.next.next.next.next = new ListNode(3);
        ListNode result2 = sol.deleteDuplicates(head2);
        printList(result2); // Output: 1 -> 2 -> 3
    }


}
