package com.company.facebook.minimumlengthsubstring;

public class Solution {
    int minLengthSubstring(String s, String t) {
        if (s.length() < t.length())
            return -1;

        int minLength = 1000001;


        int[] aFreq = new int[26];
        int[] tFreq = new int[26];
        for (char x : t.toCharArray()) {
            tFreq[x-'a']++;
        }

        int start = 0, end = t.length() - 1;
        for (int i = 0; i <= end; i++) {
            aFreq[s.charAt(i)-'a']++;
        }

        while (start < end && end < s.length()) {
            if (isFreqMatching(aFreq, tFreq)) {
                minLength = Math.min(minLength, end - start + 1);
                aFreq[s.charAt(start) - 'a']--;
                start++;
            } else {
                // expand
                end++;
                if (end < s.length()) {
                    aFreq[s.charAt(end) - 'a']++;
                }
            }
        }

        return minLength == 1000001 ? -1 : minLength;
    }

    boolean isFreqMatching(int[] source, int[] target) {
        for (int i = 0; i < 26; i++) {
            if (source[i] < target[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minLengthSubstring("dcbefebce", "fd"));
    }
}
