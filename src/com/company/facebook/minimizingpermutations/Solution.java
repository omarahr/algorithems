package com.company.facebook.minimizingpermutations;

public class Solution {
    // 3, 2, 1
    // 3, 2, 1
    // 1, 2, 3
    // 3, 2, 1

    int minOperations(int[] arr) {
        int numberOfOperations = 0;
        while (needsReversing(arr)) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int j = i + 1;
                    while (j < arr.length - 1 && arr[j] > arr[j + 1]) {
                        j++;
                    }
                    reverseArray(i, j, arr);
                    numberOfOperations++;
                    break;
                }
            }

        }

        return numberOfOperations;
    }

    void reverseArray(int start, int end, int[] arr) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    boolean needsReversing(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minOperations(new int[]{1, 2, 5, 4, 3}));
        System.out.println(solution.minOperations(new int[]{3, 1, 2}));
    }
}
