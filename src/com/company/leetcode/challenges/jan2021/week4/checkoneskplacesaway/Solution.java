package com.company.leetcode.challenges.jan2021.week4.checkoneskplacesaway;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.kLengthApart(new int[]{1,0,0,0,1,0,0,1}, 2));
        System.out.println(solution.kLengthApart(new int[]{1,0,0,1,0,1}, 2));
        System.out.println(solution.kLengthApart(new int[]{1,0,0,1,0,1}, 0));
        System.out.println(solution.kLengthApart(new int[]{0,1,0,1}, 1));
    }

    public boolean kLengthApart(int[] nums, int k) {
        int lastPosition = -k - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if(i - lastPosition - 1 < k) {
                    return false;
                }

                lastPosition = i;
            }
        }
        return true;
    }


}
