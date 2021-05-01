package com.company.leetcode.challenges.y2021.may.week1.connectedcomponents;

public class Solution {

    public int countComponents(int n, int[][] edges) {
        boolean[][] graph = new boolean[n][n];
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            graph[a][b] = graph[b][a] = true;
        }

        boolean[] visited = new boolean[n];
        int components = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                components++;
                dfs(i, graph, visited);
            }
        }

        return components;
    }

    private void dfs(int index, boolean[][] graph, boolean[] visited) {
        if (visited[index])
            return;

        visited[index] = true;
        for (int i = 0; i < graph.length; i++) {
            if (graph[index][i] && !visited[i])
                dfs(i, graph, visited);
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countComponents(5, new int[][]{
                new int[]{0, 1},
                new int[]{1, 2},
                new int[]{3, 4},
        }));
        System.out.println(solution.countComponents(5, new int[][]{
                new int[]{0, 1},
                new int[]{1, 2},
                new int[]{2, 3},
                new int[]{3, 4},
        }));
    }
}
