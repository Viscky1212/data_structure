package patternBase.slowFast;

public class A {

    public static ListNode detectCycle(
            ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null &&
                fast.next != null) {

            slow = slow.next;
            System.out.println("Slow pointer at: " + slow.val);
            fast = fast.next.next;
            System.out.println("Fast pointer at: " + fast.val);

            if (slow == fast) {

                slow = head;
                System.out.println("Cycle detected. Resetting slow pointer to head: " + slow.val);

                while (slow != fast) {

                    slow = slow.next;
                    System.out.println("Moving slow pointer to: " + slow.val);
                    fast = fast.next;
                    System.out.println("Moving fast pointer to: " + fast.val);
                }
                System.out.println("Cycle starts at node with value: " + slow.val);

                return slow;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(-4);

        head.next = n2;
        n2.next = n3;
        n3.next = n4;

        // Create cycle
        n4.next = n2;

        ListNode cycleStart =
                detectCycle(head);

        if (cycleStart != null) {
            System.out.println(
                    "Cycle starts at: "
                            + cycleStart.val
            );
        } else {
            System.out.println(
                    "No Cycle"
            );
        }
    }
}
