package org.leetcode.patterns.fastslowpointers.PalindromeLinkedList;


/**
 * Given the head of a Singly LinkedList, write a method to check if the LinkedList is a palindrome or not.
 *
 */
public class Solution {

    public static boolean isPalindrome(ListNode head) {
        //todo: the space complexity should be constant.
        ListNode pointer = head.next;
        ListNode reverseHead = new ListNode(head.val);
        while (pointer != null) {
            ListNode node = new ListNode(pointer.val);
            node.next = reverseHead;
            reverseHead = node;
            pointer = pointer.next;
        }

        ListNode originalPointer = head, reversePointer = reverseHead;
        while (originalPointer != null && reversePointer != null) {
            if (originalPointer != reversePointer) {
                return false;
            }
            originalPointer = originalPointer.next;
            reversePointer = reversePointer.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(1);
        assert isPalindrome(head);

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(1);
        assert isPalindrome(head);

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(0);
        assert !isPalindrome(head);
    }
}

