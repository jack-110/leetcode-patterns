package org.leetcode.patterns.InplaceReversalofaLinkedList.ReverseaLinkedList;

class Solution {

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        ListNode previousNode = head.next;
        ListNode nextNode = previousNode.next;
        previousNode.next = null;
        while (nextNode != null) {
            ListNode tempNode = nextNode.next;

            nextNode.next = previousNode;

            previousNode = nextNode;
            nextNode = tempNode;
        }
        head.next = previousNode;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(2);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(6);
        head.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next = new ListNode(10);

        ListNode reversed = reverse(head);
        while (reversed != null) {
            System.out.println(reversed.val);
            reversed = reversed.next;
        }
    }
}

class ListNode {
  int val = 0;
  ListNode next;

  ListNode(int value) {
    this.val = value;
  }
}
