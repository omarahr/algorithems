package com.company.leetcode.challenges.y2021.jan.week1.longestsubstring;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.lengthOfLongestSubstring("abc"));
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
        System.out.println(solution.lengthOfLongestSubstring(""));
    }


    public int lengthOfLongestSubstring(String s) {
        if (s == null)
            return 0;

        if (s.length() < 2)
            return s.length();

        int[] lastSeen = new int[256];
        Arrays.fill(lastSeen, -1);

        char[] letters = s.toCharArray();

        int start = 0;
        int maxLen = 1;

        lastSeen[letters[0]] = 0;

        for (int i = 1; i < letters.length; i++) {
            int lastIndex = lastSeen[letters[i]];
            if (lastIndex >= start) {
                start = lastIndex + 1;
            }

            lastSeen[letters[i]] = i;
            maxLen = Math.max(maxLen, i - start + 1);
        }

        return maxLen;
    }


}
