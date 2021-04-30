package com.company.leetcode.companies.google.arraysandstrings.backspacestringcompare;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.backspaceCompare("a#c", "b"));
    }

    public boolean backspaceCompare(String S, String T) {
        return convert(S.toCharArray()).equals(convert(T.toCharArray()));
    }

    private String convert(char[] str) {
        StringBuilder sb = new StringBuilder();
        int bcCounter = 0;
        int index = str.length - 1;
        while (index > -1) {
            if (str[index] == '#') {
                bcCounter++;
            } else {
                if (bcCounter == 0) {
                    sb.append(str[index]);
                } else {
                    bcCounter--;
                }
            }
            index--;
        }

        return sb.toString();
    }
}
