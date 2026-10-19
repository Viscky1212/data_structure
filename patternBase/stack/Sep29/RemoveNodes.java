package patternBase.stack.Sep29;

import java.util.*;

/**
 1. Linked List reverse karo
 2. First node ko keep karo
 3. max value maintain karo
 4. Agar current.val < max:
 current node remove
 5. Else:
 node keep
 max update
 6. Final list reverse karo

 reverse head

 max = head.val
 current = head

 while current.next exists:

 if current.next.val < max:
 current.next = current.next.next

 else:
 current = current.next
 max = current.val

 reverse head again

 return head


 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}


public class RemoveNodes {
    // public ListNode removeNodes(ListNode head) {

    //     //Step 1 : Reverse the linkedList
    //     head = reverse(head);

    //     //maximum value seen so far
    //     int max = head.val;

    //     ListNode current = head;

    //     //step 2 : Remove nodes smaller than max
    //     while(current != null && current.next != null){

    //         if(current.next.val < max){

    //             //remove current.next
    //             current.next = current.next.next;
    //         } else {
    //             //keep current.next
    //             current = current.next;

    //             //update maximum
    //             max = current.val;
    //         }
    //     }

    //     //step 3 : Reverse again to restore original order
    //     return reverse(head);

    // }

    // private ListNode reverse(ListNode head){
    //     ListNode prev = null;
    //     ListNode current = head;

    //     while(current != null){
    //         ListNode next = current.next;
    //         current.next = prev;
    //         prev = current;
    //         current = next;
    //     }
    //     return prev;
    // }

    public ListNode removeNodes(ListNode head) {

        Deque<ListNode> stack = new ArrayDeque<>();

        ListNode current = head;

        while (current != null) {

            // Remove smaller nodes because
            // current is greater and exists on their right
            while (!stack.isEmpty()
                    && stack.peek().val < current.val) {

                stack.pop();
            }

            // Add current node
            stack.push(current);

            current = current.next;
        }

        // Reconstruct list
        ListNode result = null;
        ListNode tail = null;

        while (!stack.isEmpty()) {

            ListNode node = stack.removeLast();

            // Important: disconnect old next pointer
            node.next = null;

            if (result == null) {

                result = node;
                tail = node;

            } else {

                tail.next = node;
                tail = node;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        RemoveNodes solution = new RemoveNodes();

        // Create linked list: 5 -> 2 -> 13 -> 3 -> 8
        ListNode head = new ListNode(5);
        head.next = new ListNode(2);
        head.next.next = new ListNode(13);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(8);

        // Remove nodes
        ListNode result = solution.removeNodes(head);

        // Print result
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

}
