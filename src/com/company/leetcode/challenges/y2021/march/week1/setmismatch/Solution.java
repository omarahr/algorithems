package com.company.leetcode.challenges.y2021.march.week1.setmismatch;

import java.util.Arrays;
import java.util.HashSet;

public class Solution {

    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int sum = n * (n + 1) / 2;
        HashSet<Integer> numbersSet = new HashSet<>();

        int duplicateNumber = -1;
        int currentSum = 0;
        for (int num : nums) {
            if (!numbersSet.contains(num)) {
                numbersSet.add(num);
                currentSum += num;
            } else {
                duplicateNumber = num;
            }
        }

        int missingNumber = sum - currentSum;

        return new int[]{duplicateNumber, missingNumber};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.findErrorNums(new int[]{1, 2, 2, 4})));
        System.out.println(Arrays.toString(solution.findErrorNums(new int[]{1, 1})));
    }
}
