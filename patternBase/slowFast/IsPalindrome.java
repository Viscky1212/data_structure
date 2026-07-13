package patternBase.slowFast;

public class IsPalindrome {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;

        // Find the middle of the linked list
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half of the linked list
        ListNode prev = null;
        while (slow != null) {
            ListNode nextTemp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = nextTemp;
        }

        // Compare the first half and the reversed second half
        ListNode left = head;
        ListNode right = prev; // 'prev' is now the head of the reversed second half
        while (right != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }

    public static void main(String[] args) {
        IsPalindrome sol = new IsPalindrome();
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(2);
        head1.next.next.next = new ListNode(1);
        System.out.println(sol.isPalindrome(head1)); // Output: true

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        System.out.println(sol.isPalindrome(head2)); // Output: false
    }
}
