package com.company.leetcode.companies.google.arraysandstrings.validparentheses;

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
        for (char letter : s.toCharArray()) {

            if (isOpening(letter)) {
                stack.push(letter);
            } else {
                if (stack.isEmpty())
                    return false;

                char peek = stack.peek();
                if (isMatching(peek, letter)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private boolean isOpening(char letter) {
        return letter == '(' || letter == '{' || letter == '[';
    }

    private boolean isMatching(char open, char close) {
        boolean caseOne = open == '[' && close == ']';
        boolean caseTwo = open == '{' && close == '}';
        boolean caseThree = open == '(' && close == ')';
        return caseOne || caseTwo || caseThree;
    }


}
