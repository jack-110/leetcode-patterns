package org.leetcode.DFS.PathwithMaximumSum;

public class Solution {

    private static int globalMaximumSum = Integer.MIN_VALUE;

    private int findMaximumPathSum(TreeNode root) {
        findMaximumPathSumRecursive(root);
        return globalMaximumSum;
    }

    private int findMaximumPathSumRecursive(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int maxLeft = findMaximumPathSum(root.left);
        int maxRight = findMaximumPathSum(root.right);

        globalMaximumSum = Math.max(globalMaximumSum, maxLeft + maxRight + root.val);

        return Math.max(maxLeft, maxRight) + root.val;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
