package two_pointer_problem.aprill01;

import java.util.List;

public class SwapNodes {

    public ListNode swapNodes(ListNode head, int k){
        ListNode first = head;

        //1. Move 'first' to the k -th node from the beggining
        for (int i = 1; i < k; i++) {
            first = first.next;
        }

        //2. Setup two pointers to find the k-th node from the end
        ListNode current = first;
        ListNode second = head;

        //Move both pointer until 'current' reaches the last end
        while (current.next != null){
            current = current.next;
            second = second.next;
        }

        // Swap the values of the two nodes
        int temp = first.val;
        first.val = second.val;
        second.val = temp;

        return head;
    }

    //---helper method for testing
    private static ListNode buildList(int[] arr){
        if (arr == null || arr.length == 0) return null;
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int val : arr){
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

    //Helper to print linked list
    public static  void printList(ListNode head){
    ListNode current = head;
        System.out.println("[");
        while (current != null){
            System.out.println(current.val);
            if (current.next != null) System.out.println(",  ");
            current = current.next;
        }
        System.out.println("]");
    }



    public static void main(String[] args) {
        SwapNodes sol = new SwapNodes();
        // Example 1
        int[] arr1 = {1, 2, 3, 4, 5};
        int k1 = 2;
        ListNode head1 = buildList(arr1);
        System.out.print("Example 1 Original: ");
        printList(head1);
        ListNode result1 = sol.swapNodes(head1, k1);
        System.out.print("Example 1 Swapped:  ");
        printList(result1);
        // Expected: [1, 4, 3, 2, 5]

        System.out.println("-------------------");

        // Example 2
        int[] arr2 = {7, 9, 6, 6, 7, 8, 3, 0, 9, 5};
        int k2 = 5;
        ListNode head2 = buildList(arr2);
        System.out.print("Example 2 Original: ");
        printList(head2);
        ListNode result2 = sol.swapNodes(head2, k2);
        System.out.print("Example 2 Swapped:  ");
        printList(result2);
        // Expected: [7, 9, 6, 6, 8, 7, 3, 0, 9, 5]
    }
}
