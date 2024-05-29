package org.leetcode.patterns.Islands.FloodFill;

import java.util.Arrays;

public class Solution {

    public int[][] floodFill(int[][] matrix, int x, int y, int newColor) {
        //check inputs
        if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length) {
            return matrix;
        }

        if (matrix[x][y] == 0 || matrix[x][y] == newColor) {
            return matrix;
        }

        //mark current cell
        if (matrix[x][y] == 1) {
            matrix[x][y] = newColor;
        }

        floodFill(matrix, x + 1, y, newColor);
        floodFill(matrix, x - 1, y, newColor);
        floodFill(matrix, x, y + 1, newColor);
        floodFill(matrix, x, y - 1, newColor);
        return matrix;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.deepToString(sol.floodFill(
                new int[][] {
                        { 0, 1, 1, 1, 0 },
                        { 0, 0, 0, 1, 1 },
                        { 0, 1, 1, 1, 0 },
                        { 0, 1, 1, 0, 0 },
                        { 0, 0, 0, 0, 0 }
                }, 1, 3, 2)));
    }
}
