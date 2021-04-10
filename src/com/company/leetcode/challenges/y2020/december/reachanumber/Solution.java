package com.company.leetcode.challenges.y2020.december.reachanumber;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reachNumber(0));
    }

    public int reachNumber(int target) {
        target = Math.abs(target);
        int numberOfSteps = 0;
        int sum = 0;

        while (sum < target || (sum != target && Math.abs(sum - target) % 2 != 0)) {
            sum += numberOfSteps;
            numberOfSteps++;
        }

        return Math.max(numberOfSteps - 1, 0);
    }

}
