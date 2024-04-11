package org.leetcode.patterns.Graph.NumberofProvinces;

public class Solution {

    public static int findCircleNum(int[][] isConnected) {
        int provinces = 0;
        boolean[] visited = new boolean[isConnected.length];
        for (int vertex = 0; vertex < isConnected.length; vertex++) {
            if (!visited[vertex]) {
                dfs(isConnected, visited, vertex);
                provinces++;
            }
        }
        return provinces;
    }

    private static void dfs(int[][] isConnected, boolean[] visited, int vertex) {
        visited[vertex] = true;
        for (int neighbor = 0; neighbor < isConnected[vertex].length; neighbor++) {
            if (isConnected[vertex][neighbor] == 1 && !visited[neighbor]) {
                dfs(isConnected, visited, neighbor);
            }
        }
    }

    public static void main(String[] args) {
        int[][] isConnected = new int[5][5];
        isConnected[0] = new int[]{1, 1, 1, 0, 0};
        isConnected[1] = new int[]{1, 1, 1, 0, 0};
        isConnected[2] = new int[]{0, 1, 1, 0, 0};
        isConnected[3] = new int[]{0, 0, 0, 1, 1};
        isConnected[4] = new int[]{0, 0, 0, 1, 1};
        System.out.println(findCircleNum(isConnected));
    }
}
