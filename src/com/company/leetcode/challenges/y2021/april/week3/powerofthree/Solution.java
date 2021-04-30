package com.company.leetcode.challenges.y2021.april.week3.powerofthree;

public class Solution {


    public boolean isPowerOfThree(int n) {
        if (n < 1)
            return false;
        if (n == 1)
            return true;
        long current = 1;

        while (current < n) {
            current *= 3;
        }

        if (current == n) {
            return true;
        }

        return false;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPowerOfThree(27));
        System.out.println(solution.isPowerOfThree(0));
        System.out.println(solution.isPowerOfThree(9));
        System.out.println(solution.isPowerOfThree(45));
        System.out.println(solution.isPowerOfThree(1000000));
    }

}
