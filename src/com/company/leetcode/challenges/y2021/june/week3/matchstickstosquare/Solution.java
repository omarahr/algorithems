package com.company.leetcode.challenges.y2021.june.week3.matchstickstosquare;

import java.util.Arrays;

public class Solution {
    public boolean makesquare(int[] matchsticks) {
        // sorting the array and starting from the end
        // will improve your running time by cutting off early
        Arrays.sort(matchsticks);
        int sum = Arrays.stream(matchsticks).sum();
        boolean canBeSquare = sum % 4 == 0;
        if (!canBeSquare) {
            return false;
        }

        int oneSideLength = sum / 4;

        return hasSum(matchsticks.length - 1, new int[4], matchsticks, oneSideLength);
    }

    private boolean hasSum(int index, int[] sides, int[] matchsticks, int target) {
        if (index == -1) {
            return true;
        }

        for (int i = 0; i < 4; i++) {
            if (sides[i] + matchsticks[index] > target) {
                continue;
            }
            sides[i] += matchsticks[index];
            boolean result = hasSum(index - 1, sides, matchsticks, target);
            if (result) {
                return true;
            }
            sides[i] -= matchsticks[index];
        }

        return false;
    }

    private boolean hasSumTimeLimitExceeded(int[] matchsticks, boolean[] visited, int mainTarget, int index, int target, int state) {
        if (target == 0) {
            if (state == 4) {
                return true;
            } else {
                int nextIndex = 0;
                for (int i = 0; i < matchsticks.length; i++) {
                    if (!visited[i]) {
                        nextIndex = i;
                        break;
                    }
                }
                return hasSumTimeLimitExceeded(matchsticks, visited, mainTarget, nextIndex, mainTarget, state + 1);
            }
        }

        if (visited[index] || target < 0) {
            return false;
        }

        visited[index] = true;

        for (int i = 0; i < matchsticks.length; i++) {
            boolean result = hasSumTimeLimitExceeded(matchsticks, visited, mainTarget, i, target - matchsticks[index], state);
            if (result) {
                return true;
            }
        }

        visited[index] = false;

        return false;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.makesquare(new int[]{1, 1, 1}));
        System.out.println(solution.makesquare(new int[]{1, 1, 1, 1}));
        System.out.println(solution.makesquare(new int[]{1, 1, 2, 2, 2}));
        System.out.println(solution.makesquare(new int[]{3, 3, 3, 3, 4}));
        System.out.println(solution.makesquare(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}));
        System.out.println(solution.makesquare(new int[]{3, 1, 3, 3, 10, 7, 10, 3, 6, 9, 10, 3, 7, 6, 7}));
        System.out.println(solution.makesquare(new int[]{5969561,8742425,2513572,3352059,9084275,2194427,1017540,2324577,6810719,8936380,7868365,2755770,9954463,9912280,4713511}));
    }
}
