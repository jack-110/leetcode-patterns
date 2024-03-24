package org.leetcode.patterns.InplaceReversalofaLinkedList.ReverseaSublist;

class Solution {

    public static ListNode reverse(ListNode head, int p, int q) {
        int nodeIndex = 0;
        ListNode currentNode = head, previousNode = null;
        while (nodeIndex < p) {
            if (currentNode == null) {
                return head;
            }
            nodeIndex++;
            previousNode = currentNode;
            currentNode = currentNode.next;
        }

        ListNode lastNodeOfFirstPart = previousNode;
        ListNode lastNodeOfSubList = currentNode;

        ListNode nextNode = null;
        while (p <= q) {
            if (currentNode == null) {
                return head;
            }

            p++;

            nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }

        lastNodeOfFirstPart.next = previousNode;
        lastNodeOfSubList.next = currentNode;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);

        ListNode reversed = reverse(head, 2, 4);
    }
}

class ListNode {
  int val = 0;
  ListNode next;

  ListNode(int value) {
    this.val = value;
  }
}