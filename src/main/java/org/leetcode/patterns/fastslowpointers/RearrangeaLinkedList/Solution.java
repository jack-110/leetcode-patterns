package org.leetcode.patterns.fastslowpointers.RearrangeaLinkedList;


/**
 * Any number will be called a happy number if, after repeatedly replacing it with a number equal to the sum of the square of all of its digits, leads us to the number 1.
 *
 */
public class Solution {

    public static ListNode reorder(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode headFirstHalf = head;
        ListNode headSecondHalf = reverse(slow);
        while (headFirstHalf != null && headSecondHalf != null) {
            ListNode nodeFirstHalf = headFirstHalf.next;
            ListNode nodeSecondHalf = headSecondHalf.next;

            headFirstHalf.next = headSecondHalf;
            headSecondHalf.next = nodeFirstHalf;

            headFirstHalf = nodeFirstHalf;
            headSecondHalf = nodeSecondHalf;
        }

        if (headFirstHalf != null) {
            headFirstHalf.next = null;
        }

        return head;
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = null;
        head = reorder(head);
        System.out.println("done");
    }
}

