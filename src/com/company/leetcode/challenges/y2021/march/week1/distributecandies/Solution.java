package com.company.leetcode.challenges.y2021.march.week1.distributecandies;

import java.util.HashSet;

public class Solution {
    public int distributeCandies(int[] candyType) {
        HashSet<Integer> candies = new HashSet<>();

        int maxTypes = candyType.length / 2;
        int ans = 0;
        for (int i = 0; i < candyType.length && ans < maxTypes; i++) {
            if (!candies.contains(candyType[i])) {
                candies.add(candyType[i]);
                ans++;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.distributeCandies(new int[]{1, 1, 2, 2, 3, 3}));
        System.out.println(solution.distributeCandies(new int[]{1, 1, 2, 3}));
        System.out.println(solution.distributeCandies(new int[]{6, 6, 6, 6}));
    }
}
