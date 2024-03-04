package org.leetcode.DFS.AllPathsforaSum;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static List<List<Integer>> findPaths(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> path = new ArrayList<Integer>();
        findPaths(allPaths, path, root, sum);
        return allPaths;
    }

    public static void findPaths(List<List<Integer>> allPaths, List<Integer> path, TreeNode root, int sum) {
        if (root == null) {
            return;
        }

        path.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            allPaths.add(new ArrayList<>(path));
        } else {
            findPaths(allPaths, path, root.left, sum - root.val);
            findPaths(allPaths, path, root.right, sum - root.val);
        }

        path.remove(path.size() - 1);
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
