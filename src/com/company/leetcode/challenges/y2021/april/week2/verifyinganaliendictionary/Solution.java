package com.company.leetcode.challenges.y2021.april.week2.verifyinganaliendictionary;

public class Solution {

    public boolean isAlienSorted(String[] words, String order) {
        char[] orderArr = order.toCharArray();
        int[][] strOrder = new int[words.length][];
        for (int i = 0; i < words.length; i++) {
            strOrder[i] = new int[words[i].length()];
            for (int j = 0; j < words[i].length(); j++) {
                strOrder[i][j] = order.indexOf(words[i].charAt(j));
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            if (!isCorrectOrder(strOrder[i], strOrder[i + 1], orderArr))
                return false;
        }

        return true;
    }

    private boolean isCorrectOrder(int[] first, int[] second, char[] order) {
        int i = 0;
        while (i < first.length && i < second.length) {
            if (first[i] == second[i]) {
                i++;
            } else if (first[i] < second[i]) {
                return true;
            } else {
                return false;
            }
        }

        if (i == first.length && i == second.length)
            return true;

        return i == first.length;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isAlienSorted(new String[]{"hello","leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
        System.out.println(solution.isAlienSorted(new String[]{"word","world","row"}, "worldabcefghijkmnpqstuvxyz"));
        System.out.println(solution.isAlienSorted(new String[]{"apple","app"}, "abcdefghijklmnopqrstuvwxyz"));
    }
}
