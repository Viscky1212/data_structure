package patternBase.slowFast;


import java.util.List;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}


public class HasCycle {

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        HasCycle sol = new HasCycle();
        ListNode head1 = new ListNode(3);
        ListNode node1_2 = new ListNode(2);
        ListNode node1_3 = new ListNode(0);
        ListNode node1_4 = new ListNode(-4);
        head1.next = node1_2;
        node1_2.next = node1_3;
        node1_3.next = node1_4;
        node1_4.next = node1_2; // Creates a cycle
        System.out.println(sol.hasCycle(head1)); // Output: true

        ListNode head2 = new ListNode(1);
        ListNode node2_2 = new ListNode(2);
        head2.next = node2_2;
        System.out.println(sol.hasCycle(head2)); // Output: false
    }
}
