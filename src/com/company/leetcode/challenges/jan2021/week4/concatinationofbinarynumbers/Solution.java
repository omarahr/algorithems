package com.company.leetcode.challenges.jan2021.week4.concatinationofbinarynumbers;

public class Solution {


    public int concatenatedBinary(int n) {
        long modulo = 1000000007L;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(Integer.toBinaryString(i));
        }

        char[] binary = sb.toString().toCharArray();
        long result = 0;
        long position = 1;
        for (int i = binary.length - 1; i >= 0; i--) {
            result += binary[i] == '1' ?  position % modulo: 0;
            position = ((position % modulo) * 2) % modulo;
        }

        return (int)(result % (modulo));
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.concatenatedBinary(1));
        System.out.println(solution.concatenatedBinary(3));
        System.out.println(solution.concatenatedBinary(12));
        System.out.println(solution.concatenatedBinary(100));
        System.out.println(solution.concatenatedBinary(100000));
    }
}
