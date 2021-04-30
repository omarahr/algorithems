package com.company.leetcode.companies.facebook.recursion.lettercombinationofphonenumber;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> result = solution.letterCombinations("");
        System.out.println("ssss");
        for (String str : result)
            System.out.println(str);
        System.out.println("ssss");
    }

    public List<String> letterCombinations(String digits) {
        char[][] map = new char[][]{
                new char[]{'a', 'b', 'c'},
                new char[]{'d', 'e', 'f'},
                new char[]{'g', 'h', 'i'},
                new char[]{'j', 'k', 'l'},
                new char[]{'m', 'n', 'o'},
                new char[]{'p', 'q', 'r', 's'},
                new char[]{'t', 'u', 'v'},
                new char[]{'w', 'x', 'y', 'z'},
        };

        char[] letters = digits.toCharArray();
        List<String> result = new ArrayList<>();

        permute(0, letters, map, new char[letters.length], result);

        return result;
    }

    private void permute(int index, char[] letters, char[][] map, char[] word, List<String> result) {
        if (index == letters.length) {
            if (index == 0)
                return;
            StringBuilder permutation = new StringBuilder();
            for (char x : word) permutation.append(x);
            result.add(permutation.toString());
            return;
        }

        char[] possible = map[letters[index] - '2'];
        for (char c : possible) {
            word[index] = c;
            permute(index + 1, letters, map, word, result);
        }
    }
}
