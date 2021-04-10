package com.company.leetcode.challenges.y2021.april.week1.onesandzeros;

public class Solution {
    public static int[] ones, zeros;
    public static int mm, nn;
    public static int[][][] memo;

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.findMaxForm(new String[]{"111001", "0001", "10", "1", "0"}, 5, 3);
        System.out.println(res);
    }

    public int findMaxForm(String[] strs, int m, int n) {
        ones = new int[strs.length];
        zeros = new int[strs.length];
        memo = new int[strs.length][101][101];

        for (int i = 0; i < strs.length; i++) {
            int numOnes = 0, numZeros = 0;
            for (char x : strs[i].toCharArray()) {
                numOnes = x == '1' ? numOnes + 1 : numOnes;
                numZeros = x == '0' ? numZeros + 1 : numZeros;
            }
            ones[i] = numOnes;
            zeros[i] = numZeros;
        }

        nn = n;
        mm = m;

        return subset(0, 0, 0);
    }

    private int subset(int index, int prevOnes, int prevZeros) {
        if (index >= ones.length)
            return 0;

        if (memo[index][prevOnes][prevZeros] != 0)
            return memo[index][prevOnes][prevZeros];


        int extraOnes = ones[index];
        int extraZeros = zeros[index];

        int newOnes = extraOnes + prevOnes, newZeros = extraZeros + prevZeros;
        boolean matched = newOnes <= nn && newZeros <= mm;

        int taken = matched ? subset(index + 1, newOnes, newZeros) + 1 : -1;
        int not_taken = subset(index + 1, prevOnes, prevZeros);

        return memo[index][prevOnes][prevZeros] = Math.max(taken, not_taken);
    }

}
