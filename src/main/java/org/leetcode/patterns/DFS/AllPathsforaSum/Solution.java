package org.leetcode.patterns.DFS.AllPathsforaSum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    static List<List<Integer>> result = new ArrayList<>();

    public static List<List<Integer>> findPaths(TreeNode root, int sum) {

        return result;
    }

    private static void findPaths(TreeNode root, int sum, List<Integer> path) {
        if (root == null) {
            return;
        }

        path.add(root.val);
        if (root.val == sum && root.left == null && root.right == null) {
            result.add(path);
        } else {
            sum = sum - root.val;
            findPaths(root.left, sum, path);
            findPaths(root.right, sum, path);
        }
        path.remove(root.val);
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
