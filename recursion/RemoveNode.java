package recursion;

import java.util.List;

class  ListNode{
    int val;
    ListNode next;
    ListNode(){};
    ListNode(int val){
        this.val = val;
    }

    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}

public class RemoveNode {
    public ListNode removeNodes(ListNode head){
        head = reverse(head);

        int maxSoFar = 0;
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        ListNode curr = head;

        while (curr != null){
            if (curr.val >= maxSoFar){
                maxSoFar = curr.val;
                tail.next = curr;
                tail = curr;
            }
            curr = curr.next;
        }
        tail.next = null;
        return reverse(dummy.next);

    }

    private ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null){
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    public static ListNode createList(int[] arr){
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;


        for (int num : arr){
            tail.next = new ListNode(num);
            tail = tail.next;
        }
        return dummy.next;
    }

    public static void printList(ListNode head){
        System.out.println("[");

        while (head != null){
            System.out.println(head.val);
            if (head.next != null){
                System.out.println(",");
            }
            head = head.next;
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        RemoveNode sol = new RemoveNode();

        int[] arr1 = {5, 2, 13, 3, 8};
        ListNode head1 = createList(arr1);
        ListNode result1 = sol.removeNodes(head1);
        System.out.print("Output for [5,2,13,3,8]: ");
        printList(result1);

        int[] arr2 = {1, 1, 1, 1};
        ListNode head2 = createList(arr2);
        ListNode result2 = sol.removeNodes(head2);
        System.out.print("Output for [1,1,1,1]: ");
        printList(result2);
    }
}
