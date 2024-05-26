package org.leetcode.patterns.DFS.BinaryTreePathSum;

public class Solution {

    public static boolean hasPath(TreeNode root, int sum) {
        if (root == null) {
            return sum == 0;
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
