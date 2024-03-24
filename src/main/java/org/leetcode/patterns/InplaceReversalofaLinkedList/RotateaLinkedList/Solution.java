package org.leetcode.patterns.InplaceReversalofaLinkedList.RotateaLinkedList;

class Solution {
    public static ListNode rotate(ListNode head, int rotations) {
        if (head == null || head.next == null || rotations <= 0) {
            return head;
        }

        int lengthOfNodeList = 1;
        ListNode endOfNodeList = head;
        while (endOfNodeList.next != null) {
            endOfNodeList = endOfNodeList.next;
            lengthOfNodeList++;
        }

        ListNode endOfRotateNodeList = head;
        int steps = lengthOfNodeList - (lengthOfNodeList % rotations);
        for (int i = 1; i < steps; i++) {
            endOfRotateNodeList = endOfRotateNodeList.next;
        }

        if (endOfRotateNodeList != head) {
            endOfNodeList.next = head;
            head = endOfRotateNodeList.next;
            endOfRotateNodeList.next = null;
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

        rotate(head, 8);
    }
}

class ListNode {
  int val = 0;
  ListNode next;

  ListNode(int value) {
    this.val = value;
  }
}
