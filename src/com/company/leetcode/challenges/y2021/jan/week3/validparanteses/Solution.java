package com.company.leetcode.challenges.y2021.jan.week3.validparanteses;

import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.isValid("()"));
        System.out.println(solution.isValid("()[]{}"));
        System.out.println(solution.isValid("(]"));
        System.out.println(solution.isValid("([)]"));
        System.out.println(solution.isValid("{[]}"));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char x : s.toCharArray()) {
            if (isOpening(x)) {
                stack.add(x);
            } else if (stack.isEmpty()) {
                return false;
            } else {
                boolean match = matches(stack.pop(), x);
                if (!match)
                    return false;
            }
        }

        return stack.isEmpty();
    }

    private boolean matches(char open, char close) {
        return (close == ']' && open == '[')
                || (close == '}' && open == '{')
                || (close == ')' && open == '(');
    }

    private boolean isOpening(char x) {
        return x == '(' || x == '{' || x == '[';
    }
}
