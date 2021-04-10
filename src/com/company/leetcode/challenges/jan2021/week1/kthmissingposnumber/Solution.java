package com.company.leetcode.challenges.jan2021.week1.kthmissingposnumber;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findKthPositive(new int[]{2, 3, 4, 7, 11}, 5));
        System.out.println(solution.findKthPositive(new int[]{1, 2, 3, 4}, 2));
    }


    public int findKthPositive(int[] arr, int k) {
        int missingNumberIndex = 0;
        for (int i = 1, j = 0; i <= 2000; i++) {
            if (j < arr.length) {
                if (arr[j] == i) {
                    j++;
                } else {
                    missingNumberIndex++;
                }
            } else {
                missingNumberIndex++;
            }

            if (missingNumberIndex == k)
                return i;
        }

        return 2000;
    }

}
