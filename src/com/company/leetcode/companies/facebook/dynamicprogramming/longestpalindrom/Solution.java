package com.company.leetcode.companies.facebook.dynamicprogramming.longestpalindrom;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("babad"));
        System.out.println(solution.longestPalindrome("cbbd"));
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return "";

        int start = 0, end = 0;
        char[] str = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            int evenLen = expandFromTheMiddle(str, i, i + 1);
            int oddLen = expandFromTheMiddle(str, i, i);

            int len = Math.max(evenLen, oddLen);
            if (len > end - start) {
                start = i - ((len - 1) / 2);
                end = i + (len / 2);
            }
        }

        return s.substring(start, end + 1);
    }

    private int expandFromTheMiddle(char[] str, int start, int end) {
        if (start > end || str.length == 0)
            return 0;

        while (start >= 0 && end < str.length && str[start] == str[end]) {
            start--;
            end++;
        }

        return end - start - 1;
    }
}
