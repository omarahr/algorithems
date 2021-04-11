package com.company.leetcode.challenges.y2021.march.week1.singlerowkeyboard;

public class Solution {

    public int calculateTime(String keyboard, String word) {
        int[] index = new int[26];

        if (word.length() == 0)
            return 0;

        for (int i = 0; i < 26; i++) {
            index[keyboard.charAt(i) - 'a'] = i;
        }

        int sum = index[word.charAt(0) - 'a'];

        for (int i = 0; i < word.length() - 1; i++) {
            sum += Math.abs(index[word.charAt(i) - 'a'] - index[word.charAt(i + 1) - 'a']);
        }

        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.calculateTime("abcdefghijklmnopqrstuvwxyz", "cba"));
        System.out.println(solution.calculateTime("pqrstuvwxyzabcdefghijklmno", "leetcode"));
    }
}
