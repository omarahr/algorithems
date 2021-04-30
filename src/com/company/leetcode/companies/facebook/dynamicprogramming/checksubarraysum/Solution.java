package com.company.leetcode.companies.facebook.dynamicprogramming.checksubarraysum;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.checkSubarraySum(new int[]{1, 0}, 2));
        System.out.println(solution.checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 6));
    }


    public boolean checkSubarraySum(int[] nums, int k) {

        if (nums.length < 2)
            return false;

        if (k == 0) {
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] == 0 && nums[i + 1] == 0)
                    return true;
            }

            return false;
        }

        if (k == 1)
            return true;
        // [0],[1],[2],[3],[4],[5],[6],[7],[8]
        // [[0],[1]], [[0],[1],[2]], [[0],[1],[2],[3]]
        // [[0],[1],[2] - [0]]

        int[] preSum = new int[nums.length];
        preSum[0] = nums[0];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = nums[i] + preSum[i - 1];
            if (preSum[i] % k == 0)
                return true;
        }

        Map<Integer, Integer> remToIndex = new HashMap<>();
        for (int i = 0; i < preSum.length; i++) {
            int rem = preSum[i] % k;
            if (remToIndex.containsKey(rem)) {
                if (remToIndex.get(rem) != i - 1) {
                    return true;
                }
            } else {
                remToIndex.put(rem, i);
            }
        }

        return false;
    }
}
