package com.company.facebook.matchingpairs;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    int matchingPairs(String s, String t) {
        int n = s.length();
        boolean[] matches = new boolean[n];

        int[] freq = new int[26];
        int[] freqMisMatch = new int[26];

        List<Integer> mismatchIndex = new ArrayList<>();


        int countOfMismatch = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == t.charAt(i)) {
                freq[s.charAt(i) - 'a']++;
                matches[i] = true;
            } else {
                mismatchIndex.add(i);
                countOfMismatch++;
                freqMisMatch[s.charAt(i) - 'a']++;
            }
        }

        int countOfMatches = n - countOfMismatch;

        if (n == countOfMatches) {
            for (int x : freq) {
                if (x >= 2) {
                    return countOfMatches;
                }
            }
            return countOfMatches - 2;
        } else if (countOfMismatch == 1){
            int index = mismatchIndex.get(0);
            if (freq[s.charAt(index) - 'a'] > 0 || freq[t.charAt(index) - 'a'] > 0) {
                return countOfMatches;
            } else {
                return countOfMatches - 1;
            }
        } else {
            int maxResult = -2;
            for (int i = 0; i < mismatchIndex.size(); i++) {
                int index = mismatchIndex.get(i);
                if (freqMisMatch[t.charAt(index) - 'a'] > 1 || freq[t.charAt(index) - 'a'] > 0) {
                    maxResult = 1;
                } else {
                    maxResult = Math.max(maxResult, -1);
                }
            }
            return countOfMatches + maxResult;
        }
        // m + 2
        // m + 1
        // m
        // m - 1
        // m - 2

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.matchingPairs("abc", "abd"));
//        System.out.println(solution.matchingPairs("ab", "ab"));
//        System.out.println(solution.matchingPairs("aab", "aaa"));
    }
}
