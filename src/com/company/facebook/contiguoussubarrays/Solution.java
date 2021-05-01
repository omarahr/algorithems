package com.company.facebook.contiguoussubarrays;

import java.util.Arrays;

public class Solution {

    int[] countSubArrays(int[] arr) {
        int size = arr.length;
        int[] result = new int[size];

        for (int i = 0; i < size; i++) {
            result[i]++;
            int maxNumber = arr[i];
            for (int j = i + 1; j < size; j++) {
                if (arr[i] > arr[j] && arr[i] >= maxNumber) {
                    result[i]++;
                } else if (arr[j] > arr[i] && arr[j] >= maxNumber) {
                    result[j]++;
                }
                maxNumber = Math.max(maxNumber, arr[j]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.countSubArrays(new int[]{3, 4, 1, 6, 2})));
    }
}
