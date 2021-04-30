package com.company.leetcode.challenges.y2021.april.week2.beautifullarrangmentii;

public class Solution {
    public int[] constructArray(int n, int k) {
        // 1 2 3 4
        // 1 -> 1 2 3 4
        // 2 -> 1 2 4 3
        // 3 -> 1 4 2 3

        // 1 2 3 4 5
        // 1 -> 1 2 3 4 5
        // 2 -> 1 2 3 5 4
        // 3 -> 1 2 5 3 4
        // 4 -> 1 5 2 4 3 *** 4 3 2 1

        // 1 2 3 4 5 6
        // 1 -> 1 2 3 4 5 6
        // 2 -> 1 2 3 4 6 5
        // 3 -> 1 2 3 6 4 5 ** 1 1 3 2 1
        // 4 -> 1 2 6 3 5 4 ** 1 4 3 2 1
        // 5 -> 1 6 2 5 3 4 ** 5 4 3 2 1
        return new int[]{};
    }

    public static void main(String[] args) {

    }
}
