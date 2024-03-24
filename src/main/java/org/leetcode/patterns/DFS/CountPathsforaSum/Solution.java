package org.leetcode.patterns.DFS.CountPathsforaSum;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Solution {

    public static int countPaths(TreeNode root, int S) {
        return countPaths(new ArrayList<>(), root, S);
    }

    private static int countPaths(List<Integer> path, TreeNode root, int S) {
        if (root == null) {
            return 0;
        }

        path.add(root.val);
        int pathCount = 0;
        double pathSum = 0;
        ListIterator<Integer> pathIterator = path.listIterator(path.size());
        while (pathIterator.hasPrevious()) {
            pathSum += pathIterator.previous();
            if (pathSum == S) {
                pathCount++;
            }
        }

        pathCount += countPaths(path, root.left, S);
        pathCount += countPaths(path, root.right, S);

        path.remove(path.size() - 1);

        return pathCount;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(3);
        System.out.println(countPaths(root, 8));
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
