package com.company.leetcode.challenges.y2021.june.week3.numberofsubarrayswithboundedmaximum;

public class Solution {

    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int maxNumber = nums[i];
            for (int j = i; j < nums.length; j++) {
                maxNumber = Math.max(maxNumber, nums[j]);
                if (maxNumber >= left && maxNumber <= right) {
                    result++;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numSubarrayBoundedMax(new int[]{2, 1, 4, 3}, 2, 3));
        System.out.println(solution.numSubarrayBoundedMax(new int[]{4, 4, 4, 4}, 2, 3));
        System.out.println(solution.numSubarrayBoundedMax(new int[]{73, 55, 36, 5, 55, 14, 9, 7, 72, 52}, 32, 69));
    }
}
