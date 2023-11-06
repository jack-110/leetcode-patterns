package org.leetcode.fastslowpointers.MiddleoftheLinkedList;

import java.util.Objects;

/**
 * Given the head of a Singly LinkedList, write a method to return the middle node of the LinkedList.
 *
 */
public class Solution {

    public static ListNode findMiddle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        //one node
        ListNode head = new ListNode(1);
        ListNode middle = findMiddle(head);
        assert middle == head;

        //multiple nodes with even
        head = new ListNode(2);
        head.next = new ListNode(3);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next = null;
        middle = findMiddle(head);
        assert Objects.equals(middle, new ListNode(5));

    }
}

