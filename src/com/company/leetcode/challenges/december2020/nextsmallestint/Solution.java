package com.company.leetcode.challenges.december2020.nextsmallestint;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.nextGreaterElement(230241));
    }


    private void swap(int idxA, int idxB, char[] arr) {
        char temp = arr[idxA];
        arr[idxA] = arr[idxB];
        arr[idxB] = temp;
    }

    public int nextGreaterElement(int n) {
        char[] arr = (n+"").toCharArray();

        if (arr.length <= 1)
            return -1;

        int last = arr.length - 2;

        while (last >= 0) {
            if (arr[last] < arr[last + 1]) {
                break;
            }
            last--;
        }

        if (last == -1)
            return -1;

        int sucIndex = -1;
        for (int i = arr.length - 1; i > last; i--) {
            if (arr[i] > arr[last]) {
                sucIndex = i;
                break;
            }
        }

        // swap
        swap(last, sucIndex, arr);

        // revers
        for (int i = last + 1, j = arr.length - 1; i < j; i++, j--) {
            swap(i, j, arr);
        }

        // convert to int
        StringBuilder sb = new StringBuilder();
        for(char x : arr) sb.append(x);

        long result = Long.parseLong(sb.toString());

        return result > Integer.MAX_VALUE ? -1 : (int) result;
    }
}
