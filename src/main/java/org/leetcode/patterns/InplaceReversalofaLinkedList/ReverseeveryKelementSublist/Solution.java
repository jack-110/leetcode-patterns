package org.leetcode.patterns.InplaceReversalofaLinkedList.ReverseeveryKelementSublist;

class Solution {
    public static ListNode reverse(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }

        ListNode previousNode = null;
        ListNode currentNode = head;
        ListNode nextNode = null;
        while (currentNode != null) {
            ListNode endOfPreviousKSubListNode = previousNode;
            ListNode endOfKSubListNode = currentNode;
            for (int i  = 0; i < k && currentNode != null; i++) {
                nextNode = currentNode.next;
                currentNode.next = previousNode;
                previousNode = currentNode;
                currentNode = nextNode;
            }

            if (endOfPreviousKSubListNode == null) {
                head = previousNode;
            } else {
                endOfPreviousKSubListNode.next = previousNode;
            }
            endOfKSubListNode.next = currentNode;
            previousNode = endOfKSubListNode;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        ListNode reversed = reverse(head, 3);
        System.out.println(reversed);
    }
}

class ListNode {
  int val = 0;
  ListNode next;

  ListNode(int value) {
    this.val = value;
  }
}
