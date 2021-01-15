package com.company.leetcode.challenges.jan2021.week2.minoperations;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minOperations(new int[]{1, 1, 4, 2, 3}, 5));
        System.out.println(solution.minOperations(new int[]{5, 6, 7, 8, 9}, 4));
        System.out.println(solution.minOperations(new int[]{3, 2, 20, 1, 1, 3}, 10));
    }


    public int minOperations(int[] nums, int x) {
        int n = nums.length;

        int sum = 0, right = n - 1, result = -1;
        for (int num : nums) sum += num;

        if (sum == x)
            result = n;

        for (int left = n - 1; left >= 0; left--) {
            sum -= nums[left];
            while (right > left & sum < x) {
                sum += nums[right];
                right--;
            }

            if (sum == x) {
                result = result == -1 ? left + n - right - 1 : Math.min(left + n - right - 1, result);
            }
        }


        return result;
    }


    public int minOperations(int[] nums, int left, int right, int rem) {
        if (rem == 0)
            return 0;

        if (left > right || rem < 0) {
            return 100010;
        }

        int useLeft = minOperations(nums, left + 1, right, rem - nums[left]);
        int useRight = minOperations(nums, left, right - 1, rem - nums[right]);

        return 1 + Math.min(useLeft, useRight);
    }
}
