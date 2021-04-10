package com.company.leetcode.challenges.y2021.jan.week4.pathwithmineffort;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    private int[] x = new int[]{1, 0, 0, -1};
    private int[] y = new int[]{0, 1, -1, 0};

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimumEffortPath(new int[][]{
                new int[]{1, 2, 2},
                new int[]{3, 8, 2},
                new int[]{5, 3, 5},
        }));
        System.out.println(solution.minimumEffortPath(new int[][]{
                new int[]{1, 2, 3},
                new int[]{3, 8, 4},
                new int[]{5, 3, 5},
        }));
        System.out.println(solution.minimumEffortPath(new int[][]{
                new int[]{1, 2, 1, 1, 1},
                new int[]{1, 2, 1, 2, 1},
                new int[]{1, 2, 1, 2, 1},
                new int[]{1, 2, 1, 2, 1},
                new int[]{1, 1, 1, 2, 1},
        }));
    }

    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] visited = new boolean[rows][cols];
        PriorityQueue<Point> pq = new PriorityQueue<Point>(Comparator.comparing(o -> o.maxEffort));
        pq.add(new Point(0, 0, 0));

        while (!pq.isEmpty()) {
            Point point = pq.poll();


            if (visited[point.row][point.col])
                continue;

            if (point.row == rows - 1 && point.col == cols - 1)
                return point.maxEffort;

            visited[point.row][point.col] = true;

            for (int i = 0; i < 4; i++) {
                int new_row = x[i] + point.row;
                int new_col = y[i] + point.col;
                boolean validRow = new_row >= 0 && new_row < rows;
                boolean validCol = new_col >= 0 && new_col < cols;

                if (validRow && validCol && !visited[new_row][new_col]) {
                    int effort = Math.abs(heights[new_row][new_col] - heights[point.row][point.col]);
                    pq.add(new Point(new_row, new_col, Math.max(point.maxEffort, effort)));
                }
            }

        }

        return 0;
    }

    public static class Point {
        public int row, col, maxEffort;

        public Point(int row, int col, int maxEffort) {
            this.row = row;
            this.col = col;
            this.maxEffort = maxEffort;
        }
    }
}
