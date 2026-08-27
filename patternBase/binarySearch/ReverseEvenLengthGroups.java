package patternBase.binarySearch;

public class ReverseEvenLengthGroups {

        // Linked List Node
        static class ListNode {

            int val;
            ListNode next;

            ListNode(int val) {
                this.val = val;
            }

            ListNode(int val, ListNode next) {
                this.val = val;
                this.next = next;
            }
        }

        public static ListNode reverseEvenLengthGroups(ListNode head) {

            ListNode dummy = new ListNode(0);
            dummy.next = head;

            // Node before current group
            ListNode groupPrev = dummy;

            // Expected group size
            int groupSize = 1;

            while (groupPrev.next != null) {

                /*
                 * Find actual size of current group.
                 */
                ListNode curr = groupPrev.next;

                int actualSize = 0;

                while (curr != null && actualSize < groupSize) {
                    actualSize++;
                    curr = curr.next;
                }

                /*
                 * curr is now the first node
                 * after the current group.
                 */
                ListNode groupNext = curr;

                /*
                 * If group size is even,
                 * reverse the group.
                 */
                if (actualSize % 2 == 0) {

                    ListNode prev = groupNext;
                    curr = groupPrev.next;

                    /*
                     * Reverse current group.
                     */
                    for (int i = 0; i < actualSize; i++) {

                        ListNode next = curr.next;

                        curr.next = prev;

                        prev = curr;
                        curr = next;
                    }

                    /*
                     * Old first node becomes
                     * the last node after reversal.
                     */
                    ListNode oldGroupStart = groupPrev.next;

                    // Connect previous group to reversed group
                    groupPrev.next = prev;

                    // Move groupPrev to end of reversed group
                    groupPrev = oldGroupStart;

                } else {

                    /*
                     * Group is odd.
                     * No reversal needed.
                     *
                     * Move groupPrev to the
                     * last node of current group.
                     */
                    for (int i = 0; i < actualSize; i++) {
                        groupPrev = groupPrev.next;
                    }
                }

                // Next expected group size
                groupSize++;
            }

            return dummy.next;
        }

        // Create linked list
        public static ListNode createList(int[] arr) {

            ListNode dummy = new ListNode(0);
            ListNode curr = dummy;

            for (int value : arr) {

                curr.next = new ListNode(value);
                curr = curr.next;
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

        public static void main(String[] args) {

            int[] arr = {
                    5, 2, 6, 3, 9,
                    1, 7, 3, 8, 4
            };

            ListNode head = createList(arr);

            System.out.println("Before:");
            printList(head);

            head = reverseEvenLengthGroups(head);

            System.out.println("After:");
            printList(head);
        }
    }
