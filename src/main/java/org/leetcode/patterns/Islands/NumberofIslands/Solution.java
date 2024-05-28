package org.leetcode.patterns.Islands.NumberofIslands;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static int countIslands(int[][] matrix) {
        int totalIslands = 0;
        int rows = matrix.length, cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 1) {
                    totalIslands++;
                    visitLandsBFS(matrix, i, j);
                }
            }
        }

        return totalIslands;
    }

    private static void visitLandsBFS(int[][] matrix, int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                int[] node = queue.poll();
                assert node != null;
                if (matrix == null || node[0] < 0 || node[0] >= matrix.length || node[1] < 0 || node[1] >= matrix[0].length) {
                    continue;
                }
                //it will run forever without checking this.
                if (matrix[node[0]][node[1]] == 0) {
                    continue;
                }
                matrix[node[0]][node[1]] = 0;
                queue.offer(new int[]{node[0], node[1] + 1});
                queue.offer(new int[]{node[0], node[1] - 1});
                queue.offer(new int[]{node[0] + 1, node[1]});
                queue.offer(new int[]{node[0] - 1, node[1]});
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Solution.countIslands(
                new int[][] {
                        { 0, 1, 1, 1, 0 },
                        { 0, 0, 0, 1, 1 },
                        { 0, 1, 1, 1, 0 },
                        { 0, 1, 1, 0, 0 },
                        { 0, 0, 0, 0, 0 }
                }));
    }
}
