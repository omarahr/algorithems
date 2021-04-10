package com.company.leetcode.challenges.y2021.april.week1.globalandlocalinversions;

public class Solution {
    public boolean isIdealPermutation(int[] nums) {
        int localInversions = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1])
                localInversions++;
        }

        int globalInversions = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j])
                    globalInversions++;
            }
        }
        return localInversions == globalInversions;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isIdealPermutation(new int[]{1, 0, 2}));
        System.out.println(solution.isIdealPermutation(new int[]{1, 2, 0}));
    }
}
