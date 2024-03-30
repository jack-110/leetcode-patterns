package org.leetcode.patterns.BFS.ConnectAllLevelOrderSiblings;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public static TreeNode connect(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode preiousNode = null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                if (preiousNode != null) {
                    preiousNode.next = currentNode;
                }
                preiousNode = currentNode;
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(7);
        TreeNode connected = connect(treeNode);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode next;

        TreeNode(int x) {
            val = x;
            left = right = next = null;
        }
    }
}
