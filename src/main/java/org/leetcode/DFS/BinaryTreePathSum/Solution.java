package org.leetcode.DFS.BinaryTreePathSum;

public class Solution {

    public static boolean hasPath(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        // the leaf node
        if (root.val == sum && root.left == null && root.right == null) {
            return true;
        }

        return hasPath(root.left, sum - root.val) || hasPath(root.right, sum - root.val);
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
