package patternBase.slowFast;

public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode entry = head;
                while (entry != slow) {
                    entry = entry.next;
                    slow = slow.next;
                }
                System.out.println("Cycle detected at node with value: " + entry.val);
                return entry;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        DetectCycle sol = new DetectCycle();
        ListNode head1 = new ListNode(3);
        ListNode node1_2 = new ListNode(2);
        ListNode node1_3 = new ListNode(0);
        ListNode node1_4 = new ListNode(-4);
        head1.next = node1_2;
        node1_2.next = node1_3;
        node1_3.next = node1_4;
        node1_4.next = node1_2; // Creates a cycle
        System.out.println(sol.detectCycle(head1).val); // Output: 2

        ListNode head2 = new ListNode(1);
        ListNode node2_2 = new ListNode(2);
        head2.next = node2_2;
        System.out.println(sol.detectCycle(head2)); // Output: null
    }
}
