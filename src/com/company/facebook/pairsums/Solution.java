package com.company.facebook.pairsums;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {

    int numberOfWays(int[] arr, int k) {

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == k) {
                    sum++;
                }
            }
        }

        return sum;
    }


    int numberOfWaysOptimized(int[] arr, int k) {
        Arrays.sort(arr);

        HashMap<Integer, Integer> frequency = new HashMap<>();
        for (int item : arr) {
            frequency.put(item, frequency.getOrDefault(item, 0) + 1);
        }

        int sum = 0;
        int prev = 0;
        for (int item : arr) {
            if (item == prev)
                continue;
            int freqA = frequency.get(item);
            int target = k - item;
            if (target > item) {
                int freqB = frequency.getOrDefault(target, 0);
                sum += freqA * freqB;
            } else if (target == item && freqA > 1) {
                if (freqA == 2) {
                    sum++;
                } else {
                    sum += nc2(freqA);
                }
            }
            prev = item;
        }

        return sum;
    }

    int nc2(int n) {
        return f(n) / (2 * f(n - 2));
    }

    int f(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numberOfWaysOptimized(new int[]{1, 2, 3, 4, 3}, 6));
        System.out.println(solution.numberOfWaysOptimized(new int[]{1, 5, 3, 3, 3}, 6));
    }
}
