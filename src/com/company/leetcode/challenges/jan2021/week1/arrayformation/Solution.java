package com.company.leetcode.challenges.jan2021.week1.arrayformation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    // [91,4,64,78], pieces = [[78],[4,64],[91]]
    /*
    from arr
     91 -> 0, 4 -> 1, 64 -> 2, 78-> 3
    from pieces
     78 -> 3
     4 -> 1, 64 -> 2
     91 -> 0
     */

    // [49,18,16], pieces = [[16,18,49]]
    /*
    from arr
    49 -> 0, 18 -> 1, 16 -> 2
    from pieces
    16 -> 2, 18 -> 3 break !
     */

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{1, 3, 5, 7};
        int[][] pieces = new int[][] {
                new int[]{78},
                new int[]{4, 64},
                new int[]{91},
        };

        System.out.println(solution.canFormArray(arr, pieces));
    }

    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, Integer> arrIdxToVal = new HashMap<>();
        Set<Integer> piecesIdx = new HashSet<>();

        for (int i = 0; i < arr.length; i++)
            arrIdxToVal.put(arr[i], i);


        for (int[] piece : pieces) {
            int currentIndex = -1;
            for (int i = 0; i < piece.length; i++) {

                if (!arrIdxToVal.containsKey(piece[i]))
                    return false;

                if (i == 0) {
                    currentIndex = arrIdxToVal.get(piece[i]);
                } else {
                    if (arrIdxToVal.get(piece[i]) != currentIndex)
                        return false;
                }

                if (piecesIdx.contains(currentIndex))
                    return false;
                piecesIdx.add(currentIndex);

                currentIndex++;
            }
        }

        return true;
    }
}
