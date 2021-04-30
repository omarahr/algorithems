package com.company.leetcode.companies.facebook.recursion.removeinvalidparentheses;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> result = solution.removeInvalidParentheses(")(");
        for (String str : result) {
            System.out.println(str);
        }
    }

    public List<String> removeInvalidParentheses(String s) {
        int minInvalid = getMinInvalidParentheses(s);

        List<String> results = new ArrayList<>();

        int length = s.length() - minInvalid;
        permute(s.toCharArray(), new char[length], 0, 0, results, new HashSet<>());

        return results;
    }

    private void permute(char[] str, char[] current, int len, int index, List<String> results, HashSet<String> set) {
        if (len == current.length) {
            if (isValid(current)) {
                StringBuilder stringBuilder = new StringBuilder();
                for (char c : current) stringBuilder.append(c);
                String arrStr = stringBuilder.toString();
                if (!set.contains(arrStr)) {
                    set.add(arrStr);
                    results.add(arrStr);
                }
            }
            return;
        }

        if (index == str.length) {
            return;
        }

        // not choose
        permute(str, current, len, index + 1, results, set);

        // choose
        current[len] = str[index];
        permute(str, current, len + 1, index + 1, results, set);
    }

    private boolean isValid(char[] str) {
        int counter = 0;
        for (char c : str) {
            if (c == '(') {
                counter++;
            } else if (c == ')') {
                counter--;
            }
            if (counter < 0)
                return false;
        }
        return counter == 0;
    }


    private int getMinInvalidParentheses(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                    stack.add(c);
                    break;
                case ')':
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        stack.push(')');
                    }
                    break;
                default:
            }
        }

        return stack.size();
    }


}
