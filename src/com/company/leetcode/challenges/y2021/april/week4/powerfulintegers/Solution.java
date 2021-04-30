package com.company.leetcode.challenges.y2021.april.week4.powerfulintegers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        HashSet<Integer> results = new HashSet<>();

        int currentX = 1, currentY, maxPower = 32;
        for (int i = 0; i < maxPower; i++) {

            if (currentX > bound) {
                break;
            }

            currentY = 1;
            for (int j = 0; j < maxPower; j++) {
                int result = currentY + currentX;

                if (result <= bound) {
                    results.add(result);
                } else {
                    break;
                }

                currentY *= y;
            }

            currentX *= x;
        }

        return new ArrayList<>(results);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.powerfulIntegers(2, 3, 10));
        System.out.println(solution.powerfulIntegers(3, 5, 15));
    }
}
