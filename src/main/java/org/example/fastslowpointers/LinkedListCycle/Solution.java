package org.example.fastslowpointers.LinkedListCycle;

/**
 * Given the head of a Singly LinkedList, write a function to determine if the LinkedList has a cycle in it or not.
 *
 */
public class Solution {
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        //one node has cycle
        ListNode head = new ListNode(1);
        head.next = head;
        assert hasCycle(head);

        //one node has no cycle
        head = new ListNode(2);
        assert !hasCycle(head);

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        assert !hasCycle(head);

        head.next.next.next.next.next.next = head.next.next;
        assert hasCycle(head);
    }
}

