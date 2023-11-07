package org.leetcode.fastslowpointers.StartofLinkedListCycle;

/**
 * Given the head of a Singly LinkedList that contains a cycle, write a function to find the starting node of the cycle.
 *
 */
public class Solution {

    public static ListNode findCycleStart(ListNode head) {
         ListNode slow = head, fast = head;
         while (fast != null && fast.next != null) {
             slow = slow.next;
             fast = fast.next.next;
             if (slow == fast) {
                 int length = calculateLength(slow);
                 return findCycleStart(head, length);
             }
         }
        return null;
    }

    private static int calculateLength(ListNode slow) {
        int length = 1;
        ListNode current = slow.next;
        while (current != slow) {
            length++;
            current = current.next;
        }
        return length;
    }

    private static ListNode findCycleStart(ListNode head, int length) {
        ListNode pointerOne = head, pointerTwo = head;
        while (length > 0) {
            length--;
            pointerTwo = pointerTwo.next;
        }
        while (pointerTwo != null) {
            pointerOne = pointerOne.next;
            pointerTwo = pointerTwo.next;
            if (pointerOne == pointerTwo) {
                return pointerOne;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        //one node has cycle
        ListNode head = new ListNode(1);
        head.next = head;
        assert findCycleStart(head) == head;

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = head.next.next;
        assert findCycleStart(head) == head.next.next;
    }
}

