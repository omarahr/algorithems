package com.company.leetcode.challenges.y2021.jan.week3.maxnumberofksumpairs;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxOperations(new int[]{1, 2, 3, 4}, 5));
        System.out.println(solution.maxOperations(new int[]{3, 1, 3, 4, 3}, 6));
    }

    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum == k) {
                count++;
                left++;
                right--;
            } else if (sum < k) {
                left++;
            } else {
                right--;
            }
        }

        return count;
    }
}
