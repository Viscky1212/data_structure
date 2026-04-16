package slidingwindow.april10.recursion;


import two_pointer_problem.KDistantIndicesApp;

class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) { this.val = val; }
}
public class ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k){
        if (head  ==  null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevGroup = dummy;

        while (true){
            //Step 1 : find kth node
            ListNode kth = getKth(prevGroup, k);
            if (kth == null) break;

            ListNode nextGruop = kth.next;

            //Step 2 : Reverse group
            ListNode prev = nextGruop;
            ListNode curr = prevGroup.next;

            while (curr != nextGruop){
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            //Step 3 : reconnect
            ListNode temp = prevGroup.next;
            prevGroup.next = kth;
            prevGroup = temp;
        }
        return dummy.next;
    }



    //Helper to get kth node
    private ListNode getKth(ListNode curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }


    public static void main(String[] args) {

        ReverseKGroup sol = new ReverseKGroup();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 3;

        ListNode result = sol.reverseKGroup(head, k);

        // Print result
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
