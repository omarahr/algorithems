package com.company.leetcode.challenges.jan2021.week3.getmaximumingeneratedarray;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getMaximumGenerated(0));
        System.out.println(solution.getMaximumGenerated(1));
        System.out.println(solution.getMaximumGenerated(2));
        System.out.println(solution.getMaximumGenerated(3));
        System.out.println(solution.getMaximumGenerated(7));
    }


    public int getMaximumGenerated(int n) {
        int max = 0;
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        int[] values = new int[n+1];
        values[0] = 0;
        values[1] = 1;
        for (int i = 2; i <= n; i++) {
            values[i] = i % 2 == 0 ? values[i/2] : values[i/2] + values[(i/2)+1];
            max = Math.max(max, values[i]);
        }

        return max;
    }
}
