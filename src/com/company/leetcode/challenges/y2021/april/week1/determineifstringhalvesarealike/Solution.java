package com.company.leetcode.challenges.y2021.april.week1.determineifstringhalvesarealike;

import java.util.Arrays;
import java.util.HashSet;

public class Solution {
    public boolean halvesAreAlike(String s) {
        HashSet<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

        int firstHalfCounter = 0, secondHalfCounter = 0;

        for (int i = 0, j = s.length() / 2; i < s.length() / 2; i++, j++) {
            if (vowels.contains(s.charAt(i))) {
                firstHalfCounter++;
            }
            if (vowels.contains(s.charAt(j))) {
                secondHalfCounter++;
            }
        }

        return firstHalfCounter == secondHalfCounter;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.halvesAreAlike("book"));
        System.out.println(solution.halvesAreAlike("textbook"));
        System.out.println(solution.halvesAreAlike("MerryChristmas"));
        System.out.println(solution.halvesAreAlike("AbCdEfGh"));
    }
}
