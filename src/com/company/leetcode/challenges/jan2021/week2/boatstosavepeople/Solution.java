package com.company.leetcode.challenges.jan2021.week2.boatstosavepeople;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numRescueBoats(new int[]{2, 1}, 3));
        System.out.println(solution.numRescueBoats(new int[]{3, 2, 2, 1}, 3));
        System.out.println(solution.numRescueBoats(new int[]{3, 5, 3, 4}, 5));
    }

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int counter = 0;
        for (int i = 0, j = people.length - 1; i <= j; ) {
            if (i == j) {
                counter++;
                break;
            }
            int light = people[i];
            int heavy = people[j];
            if (light + heavy <= limit) {
                i++;
            }
            j--;
            counter++;
        }

        return counter;
    }
}
