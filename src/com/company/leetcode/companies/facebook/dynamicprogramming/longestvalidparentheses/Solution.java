package com.company.leetcode.companies.facebook.dynamicprogramming.longestvalidparentheses;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestValidParentheses("(())"));
    }


    public int longestValidParentheses(String s) {

        char closing = ')', opening = '(';
        char[] str = s.toCharArray();
        int[] dp = new int[s.length()];
        int max = 0;

        for (int i = 1; i < str.length; i++) {
            if (str[i] == closing) {
                if (str[i - 1] == opening) {
                    dp[i] = i < 2 ? 2 : dp[i - 2] + 2;
                } else {
                    if (i - dp[i - 1] > 0 && str[i - dp[i - 1] - 1] == opening) {
                        dp[i] = dp[i - 1] + 2;

                        if (i - dp[i - 1] - 2 > 0) dp[i] += dp[i - dp[i - 1] - 2];
                    }
                }
            }

            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
