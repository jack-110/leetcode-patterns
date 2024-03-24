package org.leetcode.patterns.DFS.PathWithGivenSequence;

public class Solution {

    public static boolean findPath(TreeNode root, int[] sequence) {
        return findPath(root, sequence, 0);
    }

    public static boolean findPath(TreeNode root, int[] sequence, int height) {
        if (root == null || height >= sequence.length || sequence[height] != root.val) {
            return false;
        }

        //height == sequence.length - 1: the sequence is longer than the tree path
        if (root.left == null && root.right == null && height == sequence.length - 1) {
            return true;
        }

        height++;
        return findPath(root.left, sequence, height) || findPath(root.right, sequence, height);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.right = new TreeNode(9);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(9);
        System.out.println(findPath(root, new int[]{1, 9, 2, 4}));
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
