package com.company.leetcode.challenges.y2021.june.week3.shortestdistancetotargetcolor;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        List<Integer> results = new ArrayList<>();
        int[][] index = colorIndex(colors);

        for (int[] query : queries) {
            int currentIndex = query[0];
            int target = query[1] - 1;
            results.add(index[currentIndex][target]);
        }
        return results;
    }

    private int[][] colorIndex(int[] color) {
        int[][] index = new int[color.length][3];

        // for zero
        index[0][0] = index[0][1] = index[0][2] = -1;
        index[0][color[0] - 1] = 0;

        for (int i = 1; i < color.length; i++) {
            for (int j = 0; j < 3; j++) {
                index[i][j] = index[i - 1][j] == -1 ? -1 : index[i - 1][j] + 1;
            }
            index[i][color[i] - 1] = 0;
        }

        for (int i = color.length - 2; i >= 0; i--) {
            for (int j = 0; j < 3; j++) {
                index[i][j] = index[i][j] == -1 ? (index[i + 1][j] == -1 ? -1 : index[i + 1][j] + 1) : Math.min(index[i][j], index[i + 1][j] + 1);
            }
        }

        return index;
    }


    private int shortestDistanceTimeLimit(int[] colors, int startIndex, int targetColor) {
        int left = startIndex, right = startIndex;
        while (left >= 0 || right < colors.length) {
            if (left >= 0) {
                if (colors[left] == targetColor) {
                    return Math.abs(startIndex - left);
                }
                left--;
            }

            if (right < colors.length) {
                if (colors[right] == targetColor) {
                    return Math.abs(startIndex - right);
                }
                right++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.shortestDistanceColor(
                new int[]{1, 1, 2, 1, 3, 2, 2, 3, 3},
                new int[][]{new int[]{1, 3}, new int[]{2, 2}, new int[]{6, 1}}
        ));

        System.out.println(solution.shortestDistanceColor(new int[]{1, 2}, new int[][]{new int[]{0, 3}}));
    }
}
