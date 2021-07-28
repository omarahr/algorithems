package com.company.leetcode.challenges.y2021.july.week3.threesumclosest;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.threeSumClosest(new int[]{-1,2,1,-4}, 1));
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int currentDiff = Integer.MAX_VALUE;
        int closestSum = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            int remaining = target - nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                int totalSum = sum + nums[i];
                int diff = Math.abs(target - totalSum);
                if (diff < currentDiff) {
                    closestSum = totalSum;
                    currentDiff = diff;
                }

                if (sum > remaining) {
                    right--;
                } else if (sum < remaining) {
                    left++;
                } else {
                    break;
                }
            }
        }

        return closestSum;
    }
}
