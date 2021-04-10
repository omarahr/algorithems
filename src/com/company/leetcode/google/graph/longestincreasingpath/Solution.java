package com.company.leetcode.google.graph.longestincreasingpath;

public class Solution {

    private static int[] xs = new int[]{0, 0, 1, -1};
    private static int[] ys = new int[]{1, -1, 0, 0};
    private static int maxLen, width, height;
    private static int[][] dp;
    private static boolean[][] visited;

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.longestIncreasingPath(new int[][]{
                new int[]{9, 9, 4},
                new int[]{6, 6, 8},
                new int[]{2, 1, 1}
        });
        System.out.print(result);
    }

    public int longestIncreasingPath(int[][] matrix) {
        height = matrix.length;
        if (height == 0)
            return 0;
        width = matrix[0].length;
        maxLen = 1;
        dp = new int[height][width];
        visited = new boolean[height][width];

        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++) {
                dp[i][j] = -1;
                visited[i][j] = false;
            }


        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                maxLen = Math.max(maxLen, getLongestPathFrom(i, j, matrix));
            }
        }

        return maxLen;
    }

    private int getLongestPathFrom(int row, int col, int[][] matrix) {
        if (dp[row][col] != -1)
            return dp[row][col];

        visited[row][col] = true;

        int max = 1;

        for (int i = 0; i < 4; i++) {
            int new_row = row + xs[i];
            int new_col = col + ys[i];

            if (valid(new_row, new_col) && !visited[new_row][new_col] && matrix[row][col] < matrix[new_row][new_col]) {
                max = Math.max(max, 1 + getLongestPathFrom(new_row, new_col, matrix));
            }
        }

        visited[row][col] = false;

        return dp[row][col] = max;
    }

    private boolean valid(int row, int col) {
        return row >= 0 && row < height && col >= 0 && col < width;
    }
}
