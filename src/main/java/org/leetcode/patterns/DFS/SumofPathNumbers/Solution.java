package org.leetcode.patterns.DFS.SumofPathNumbers;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int findSumOfPathNumbers(TreeNode root) {
        List<Integer> sum = new ArrayList<>();
        int pathSum = 0;
        findSum(sum, pathSum, root);
        int value = 0;
        for (int i = 0; i < sum.size(); i++) {
            value += sum.get(i);
        }
        return value;
    }

    // method one
    private void findSum(List<Integer> sum, int pathSum, TreeNode root) {
        if (root == null) {
            return;
        }

        pathSum = pathSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum.add(pathSum);
        } else {
            findSum(sum, pathSum, root.left);
            findSum(sum, pathSum, root.right);
        }

        pathSum = (pathSum - root.val) / 10;
    }

    //method two
    private int calculateSum(int pathSum, TreeNode root) {
        if (root == null) {
            return 0;
        }

        pathSum = pathSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return pathSum;
        }

        return calculateSum(pathSum, root.left) + calculateSum(pathSum, root.right);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        System.out.println("Total Sum of Path Numbers: " +
                sol.findSumOfPathNumbers(root));
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
