package com.company.leetcode.challenges.y2021.april.week1.minimumoperationstomakearrayequal;

public class Solution {
    public int minOperations(int n) {
        int sum = 0;

        for (int i = 0, j = 1; i < n; i++, j += 2) {
            sum += j;
        }

        int target = sum / n;

        int operations = 0;
        for (int i = 0, j = 1; i < n && target > j; i++, j += 2) {
            operations += (target - j);
        }

        return operations;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minOperations(3));
        System.out.println(solution.minOperations(6));
    }
}
