package com.company.leetcode.challenges.y2021.march.week1.missingnumber;

import java.util.Arrays;

public class Solution {

    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = (n * (n + 1)) / 2;
        return expectedSum - Arrays.stream(nums).sum();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.missingNumber(new int[]{3, 0, 1}));
        System.out.println(solution.missingNumber(new int[]{0, 1}));
        System.out.println(solution.missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
        System.out.println(solution.missingNumber(new int[]{0}));
    }
}
