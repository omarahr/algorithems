package com.company.leetcode.challenges.y2021.april.week2.longestincreasingpathinamatrix;

public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        rows = matrix.length;
        cols = matrix[0].length;
        _matrix = matrix;

        memo = new int[rows][cols];

        int ans = 0;


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                ans = Math.max(dfs(i, j), ans);
            }
        }
        return ans;
    }


    int[] _x = new int[]{1, -1, 0, 0};
    int[] _y = new int[]{0, 0, -1, 1};
    int rows, cols;
    int[][] _matrix;
    int[][] memo;

    private int dfs(int x, int y) {
        if (memo[x][y] != 0)
            return memo[x][y];

        int maxLength = 0;
        for (int i = 0; i < 4; i++) {
            int new_x = x + _x[i];
            int new_y = y + _y[i];

            boolean inBounds = new_x >= 0 && new_x < rows && new_y >= 0 && new_y < cols;
            boolean match = inBounds && _matrix[new_x][new_y] > _matrix[x][y];

            if (match) {
                maxLength = Math.max(maxLength, dfs(new_x, new_y));
            }
        }

        return memo[x][y] = 1 + maxLength;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestIncreasingPath(new int[][]{
                new int[]{9, 9, 4},
                new int[]{6, 6, 8},
                new int[]{2, 1, 1},
        }));
        System.out.println(solution.longestIncreasingPath(new int[][]{
                new int[]{3, 4, 5},
                new int[]{3, 2, 6},
                new int[]{2, 2, 1},
        }));
        System.out.println(solution.longestIncreasingPath(new int[][]{
                new int[]{1},
        }));

    }
}
