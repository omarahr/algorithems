package com.company.leetcode.facebook.dynamicprogramming.wordbreak;

import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean result = solution.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat"));
        System.out.println(result);
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        return constructWord(0, s, wordDict, new boolean[s.length()]);
    }

    private boolean constructWord(int index, String s, List<String> dict, boolean[] visited) {
        if (index == s.length()){
            return true;
        }

        if (visited[index])
            return false;

        visited[index] = true;

        String rem = s.substring(index);
        for (String str : dict) {
            // check can take word
            if (rem.startsWith(str)) {
                boolean result = constructWord(index + str.length(), s, dict, visited);
                if (result)
                    return true;
            }
        }
        return false;
    }
}
