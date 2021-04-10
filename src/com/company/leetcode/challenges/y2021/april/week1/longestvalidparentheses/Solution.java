package com.company.leetcode.challenges.y2021.april.week1.longestvalidparentheses;

import java.util.Stack;

public class Solution {


    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();

        int longest = 0;
        stack.push(-1);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    longest = Math.max(longest, i - stack.peek());
                }
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestValidParentheses("(()"));
        System.out.println(solution.longestValidParentheses(")()())"));
        System.out.println(solution.longestValidParentheses(""));
        System.out.println(solution.longestValidParentheses("()(()(()"));
    }
}
