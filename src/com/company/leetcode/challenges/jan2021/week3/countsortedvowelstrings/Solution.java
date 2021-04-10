package com.company.leetcode.challenges.jan2021.week3.countsortedvowelstrings;

import java.util.Arrays;

public class Solution {
    int[][] dp;

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countVowelStrings(2));
        System.out.println(solution.countVowelStrings(50));
    }

    public int countVowelStrings(int n) {
        int sum = 0;
        dp = new int[n][5];
        for (int i = 0; i < n; i++)
            Arrays.fill(dp[i], -1);
        for (int i = 0; i < 5; i++) {
            sum += countVowelStrings(1, i, n);
        }
        return sum;
    }

    public int countVowelStrings(int index, int prev, int n) {
        if (index == n)
            return 1;

        if (dp[index][prev] != -1)
            return dp[index][prev];

        int sum = 0;
        for (int i = prev; i < 5; i++) {
            sum += countVowelStrings(index + 1, i, n);
        }

        return dp[index][prev] = sum;
    }
}
