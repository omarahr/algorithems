package com.company.leetcode.challenges.jan2021.palindromepermutation;

public class Solution {


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canPermutePalindrome("code"));
        System.out.println(solution.canPermutePalindrome("aab"));
        System.out.println(solution.canPermutePalindrome("carerac"));
    }

    public boolean canPermutePalindrome(String s) {
        char[] letters = s.toCharArray();
        int[] frequency = new int[256];

        int oddCount = 0;

        for (char letter : letters) frequency[letter]++;
        for (int freq : frequency) {
            if (freq % 2 != 0)
                oddCount++;
        }

        return oddCount < 2;
    }
}
