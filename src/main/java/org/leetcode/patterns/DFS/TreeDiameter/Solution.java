package org.leetcode.patterns.DFS.TreeDiameter;

public class Solution {

    private int treeDiameter = 0;

    public int findDiameter(TreeNode root) {
        treeDiameter = 0;
        maxPath(root);
        return treeDiameter;
    }

    public int maxPath(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int maxLeft = maxPath(root.left);
        int maxRight = maxPath(root.right);

        if (maxLeft != 0 && maxRight != 0) {
            treeDiameter = Math.max(treeDiameter, maxRight + maxLeft + 1);
        }


        return Math.max(maxLeft, maxRight) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        Solution sol = new Solution();
        System.out.println("Tree Diameter: " + sol.findDiameter(root));
        root.left.left = null;
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        root.right.left.right.left = new TreeNode(10);
        root.right.right.left.left = new TreeNode(11);
        System.out.println("Tree Diameter: " + sol.findDiameter(root));
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
