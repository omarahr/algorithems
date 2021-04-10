package com.company.leetcode.challenges.jan2021.week4.sortthematrixdiagonally;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.diagonalSort(new int[][]{
                new int[]{3, 3, 1, 1},
                new int[]{2, 2, 1, 2},
                new int[]{1, 1, 1, 2},
        });
    }


    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int size = m + n - 1;

        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < size; i++)
            lists.add(new ArrayList<>());

        int index = 0;
        // columns
        while (index < m) {
            List<Integer> items = lists.get(index);
            for (int i = index, j = 0; i < m && j < n; i++, j++) {
                items.add(mat[i][j]);
            }
            index++;
        }


        int col = 1;
        while (index < size) {
            List<Integer> items = lists.get(index);
            for (int i = 0, j = col; i < m && j < n; i++, j++) {
                items.add(mat[i][j]);
            }
            index++;
            col++;
        }
        /** print to check the correctness
         for (int i = 0; i < size; i++) {
         for (int x : lists.get(i)) {
         System.out.print(x+" , ");
         }
         System.out.println();
         }
         */

        for (List<Integer> x : lists) {
            Collections.sort(x);
        }

        // put back
        index = 0;
        // columns
        while (index < m) {
            List<Integer> items = lists.get(index);
            for (int i = index, j = 0, k = 0; i < m && j < n; i++, j++, k++) {
                mat[i][j] = items.get(k);
            }
            index++;
        }


        col = 1;
        while (index < size) {
            List<Integer> items = lists.get(index);
            for (int i = 0, j = col, k = 0; i < m && j < n; i++, j++, k++) {
                mat[i][j] = items.get(k);
            }
            index++;
            col++;
        }

        /**
         for (int i = 0; i < m; i++) {
         System.out.println(Arrays.toString(mat[i]));
         }
         */

        return mat;
    }
}
