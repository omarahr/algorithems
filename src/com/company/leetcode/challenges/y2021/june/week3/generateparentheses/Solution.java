package com.company.leetcode.challenges.y2021.june.week3.generateparentheses;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<>();
        generate(0, new char[n*2], results);
        return results;
    }

    private void generate(int n, char[] str, List<String> results) {
        if (n == str.length) {
            boolean isValid = isValidParenthesis(str);
            if (isValid) {
                StringBuilder sb = new StringBuilder();
                IntStream.range(0, str.length).mapToObj(i -> str[i]).forEach(sb::append);
                results.add(sb.toString());
            }
            return;
        }

        str[n] = '(';
        generate(n + 1, str, results);
        str[n] = ')';
        generate(n + 1, str, results);
    }

    private boolean isValidParenthesis(char[] str) {
        int sum = 0;
        for (char c : str) {
            if (c == '(') {
                sum++;
            } else if (c == ')') {
                sum--;
            }
            if (sum < 0) {
                return false;
            }
        }
        return sum == 0;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generateParenthesis(1));
        System.out.println(solution.generateParenthesis(3));
        System.out.println(solution.generateParenthesis(8));
    }
}
