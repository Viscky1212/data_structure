package two_pointer_problem.april02;


import two_pointer_problem.aprill01.ListNode;

public class DeleteMiddle {

    //Function to delete middle node
    public ListNode deleteMiddle(ListNode head){
        //for edge case : only node
        if (head == null || head.next == null){
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        //move fast by 2 and slow by 1
        while (fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        //Delete middle node
        prev.next = slow.next;
        return  head;
    }




    //helper method to print list
    public static void printList(ListNode head){
        ListNode temp = head;
        while (temp != head){
            System.out.println(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    //helper method to create linked list
    public static ListNode createList(int[] arr){
        if (arr.length == 0) return null;

        ListNode head =  new ListNode(arr[0]);
        ListNode current = head;

        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }


    public static void main(String[] args) {

        DeleteMiddle sol = new DeleteMiddle();

        int[] arr = {1, 3, 4, 7, 1, 2, 6};

        ListNode head = createList(arr);

        System.out.println("Original List:");
        printList(head);

        head = sol.deleteMiddle(head);

        System.out.println("After Deleting Middle:");
        printList(head);
    }
}
