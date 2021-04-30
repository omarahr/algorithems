package com.company.leetcode.challenges.y2021.april.week4.firstandlastposition;

import java.util.Arrays;

public class Solution {
    public int[] searchRange(int[] nums, int target) {

        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int midValue = nums[mid];
            if (midValue < target) {
                left = mid + 1;
            } else if (midValue > target) {
                right = mid - 1;
            } else {
                left = right = mid;
                while (left > 0 && nums[left - 1] == target) left--;
                while (right < nums.length - 1 && nums[right + 1] == target) right++;
                return new int[]{left, right};
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));
        System.out.println(Arrays.toString(solution.searchRange(new int[]{}, 0)));
        System.out.println(Arrays.toString(solution.searchRange(new int[]{1}, 1)));
    }
}
