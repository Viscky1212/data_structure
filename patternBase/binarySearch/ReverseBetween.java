package patternBase.binarySearch;

public class ReverseBetween {

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

    public static ListNode reverseBetween(ListNode head, int left, int right) {

        //dummy node handles the case when left = 1
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        //Move prev to the node before the left position
        ListNode prev = dummy;

        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        //first node of the part to be reversed
        ListNode start = prev.next;

        //reverse from left to right
       for (int i = 0; i < right - left; i++) {

           //node to be moved to the front of the reversed part
            ListNode temp = start.next;

            //Remove next from its current position and move it to the front of the reversed part
            start.next = temp.next;

            //Insert next after prev
            temp.next = prev.next;
            prev.next = temp;
        }

        return dummy.next;
    }

    // Print linked list
    public static void printList(ListNode head) {

        ListNode curr = head;

        while (curr != null) {
            System.out.print(curr.val);

            if (curr.next != null) {
                System.out.print(" -> ");
            }

            curr = curr.next;
        }

        System.out.println();
    }

    public  static ListNode createLinkedList(int[] nums) {
        if (nums.length == 0) return null;
        ListNode head = new ListNode(nums[0]);
        ListNode current = head;
        for (int i = 1; i < nums.length; i++) {
            current.next = new ListNode(nums[i]);
            current = current.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int left = 2;
        int right = 4;

        ListNode head = createLinkedList(nums);
        System.out.println("Original List:");
        printList(head);

        head = reverseBetween(head, left, right);
        System.out.println("List after reversing between positions " + left + " and " + right + ":");
        printList(head);

    }
}
