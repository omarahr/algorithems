package com.company.leetcode.challenges.y2021.april.week2.lettercombinationsofaphonenumber;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0)
            return new ArrayList<>();

        char[][] phone = new char[10][];
        phone[0] = new char[]{};
        phone[1] = new char[]{};
        phone[2] = new char[]{'a', 'b', 'c'};
        phone[3] = new char[]{'d', 'e', 'f'};
        phone[4] = new char[]{'g', 'h', 'i'};
        phone[5] = new char[]{'j', 'k', 'l'};
        phone[6] = new char[]{'m', 'n', 'o'};
        phone[7] = new char[]{'p', 'q', 'r', 's'};
        phone[8] = new char[]{'t', 'u', 'v'};
        phone[9] = new char[]{'w', 'x', 'y', 'z'};


        List<String> answer = new ArrayList<>();
        generate(digits, 0, "", phone, answer);
        return answer;
    }


    private void generate(String digits, int index, String combination, char[][] phone, List<String> answer) {
        if (index == digits.length()) {
            answer.add(combination);
            return;
        }

        int digit = digits.charAt(index) - '0';
        for (int i = 0; i < phone[digit].length; i++) {
            generate(digits, index + 1, combination + phone[digit][i], phone, answer);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.letterCombinations("23").toString());
        System.out.println(solution.letterCombinations("").toString());
        System.out.println(solution.letterCombinations("2").toString());
    }
}
