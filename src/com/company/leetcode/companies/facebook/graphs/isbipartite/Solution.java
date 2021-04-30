package com.company.leetcode.companies.facebook.graphs.isbipartite;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isBipartite(new int[][]{
                new int[]{1},
                new int[]{0, 3},
                new int[]{3},
                new int[]{1, 2},
        }));
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        boolean[] visited = new boolean[n];
        int BLACK = -1, RED = 1, NOT_COLORED = 0;

        Queue<Integer> queue = new LinkedList<>();


        for (int x = 0; x < n; x++) {
            if (colors[x] != NOT_COLORED) {
                continue;
            }
            queue.add(x);

            while (!queue.isEmpty()) {
                int current = queue.poll();
                if (visited[current])
                    continue;

                visited[current] = true;

                if (colors[current] == NOT_COLORED) {
                    colors[current] = RED;
                }

                for (int i = 0; i < graph[current].length; i++) {
                    int nextIdx = graph[current][i];
                    if (colors[nextIdx] == colors[current]) {
                        return false;
                    } else if (colors[nextIdx] == NOT_COLORED) {
                        colors[nextIdx] = colors[current] == BLACK ? RED : BLACK;
                        queue.add(nextIdx);
                    } else {
                        queue.add(nextIdx);
                    }
                }
            }
        }

        return true;
    }
}
