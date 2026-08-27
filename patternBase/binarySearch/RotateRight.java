package patternBase.binarySearch;

public class RotateRight {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    private static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k <= 0) {
            return head;
        }

        // First, determine the length of the list
        ListNode current = head;
        int length = 1; // Start with 1 to count the head
        while (current.next != null) {
            current = current.next;
            length++;
        }

        // Connect the last node to the head to make it circular
        current.next = head;

        // Find the new tail: (length - k % length - 1)th node
        // and the new head: (length - k % length)th node
        k = k % length;
        int stepsToNewHead = length - k;
        ListNode newTail = head;

        for (int i = 1; i < stepsToNewHead; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;

        // Break the circle
        newTail.next = null;

        return newHead;
    }

      private static ListNode createList(int[] arr) {
        if (arr.length == 0) return null;

        ListNode head = new ListNode(arr[0]);
        ListNode current = head;

        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }

        return head;
    }

    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 2;

        ListNode head = createList(arr);

        System.out.println("Original List:");
        printList(head);

        head = rotateRight(head, k);

        System.out.println("After Rotation:");
        printList(head);
    }

//    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 4, 5};
//        int k = 2;
//        rotateRight(nums, k);
//        for (int num : nums) {
//            System.out.print(num + " ");
//        }
//    }
//
//    public static void rotateRight(int[] nums, int k) {
//        int n = nums.length;
//        k = k % n;
//        reverse(nums, 0, n - 1);
//        reverse(nums, 0, k - 1);
//        reverse(nums, k, n - 1);
//    }
//
//    private static void reverse(int[] nums, int start, int end) {
//        while (start < end) {
//            int temp = nums[start];
//            nums[start] = nums[end];
//            nums[end] = temp;
//            start++;
//            end--;
//        }
//    }
}
