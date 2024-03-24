package org.leetcode.patterns.BFS.BinaryTreeLevelOrderTraversal;

import java.util.*;

public class Solution {


    private List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);
            for (int i = 0; i < queue.size(); i++) {
                TreeNode currentTreeNode = queue.poll();
                currentLevel.add(currentTreeNode.val);
                if (currentTreeNode.left != null) {
                    queue.offer(currentTreeNode.left);
                }
                if (currentTreeNode.right != null) {
                    queue.offer(currentTreeNode.right);
                }
            }
            result.add(currentLevel);
        }
        return result;
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
