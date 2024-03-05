package org.leetcode.DFS.CountPathsforaSum;

public class Solution {

    public static int countPaths(TreeNode root, int S) {
        if (root == null) {
            return 0;
        }

        //the paths can start or end at any node
        //todo: how to fix?
        if (S == root.val) {
            return 1;
        }

        return countPaths(root.left, S - root.val) + countPaths(root.right, S - root.val) + countPaths(root.left, S) + countPaths(root.right, S);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(3);
        System.out.println(countPaths(root, 10));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
