package com.company.leetcode.challenges.jan2021.week4.oneeditdistance;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isOneEditDistance("ab", "acb"));
        System.out.println(solution.isOneEditDistance("", ""));
        System.out.println(solution.isOneEditDistance("a", ""));
        System.out.println(solution.isOneEditDistance("", "A"));
        System.out.println(solution.isOneEditDistance("a", "A"));
    }

    public boolean isOneEditDistance(String s, String t) {
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();


        int sIndex = 0, tIndex = 0;
        while (sIndex < ss.length || tIndex < tt.length) {

            if (sIndex == ss.length) {
                return tt.length - tIndex == 1;
            } else if (tIndex == tt.length) {
                return ss.length - sIndex == 1;
            }

            if (ss[sIndex] == tt[tIndex]) {
                sIndex++;
                tIndex++;
            } else {
                // delete from s -> s+1, t
                // replace from s -> s+1, t+1
                // insert to s -> s, t+1

                boolean opA = isOneEditDistance(ss, tt, sIndex + 1, tIndex + 1);
                boolean opB = isOneEditDistance(ss, tt, sIndex, tIndex + 1);
                boolean opC = isOneEditDistance(ss, tt, sIndex + 1, tIndex);

                return (opA || opB || opC);
            }
        }

        return false;
    }

    private boolean isOneEditDistance(char[] s, char[] t, int sIndex, int tIndex) {

        if (sIndex == s.length) {
            return t.length - tIndex == 0;
        } else if (tIndex == t.length) {
            return false;
        }

        if (s[sIndex] == t[tIndex]) {
            return isOneEditDistance(s, t, sIndex + 1, tIndex + 1);
        } else {
            return false;
        }
    }
}
